import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, L;
    private static int[] pipe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        boolean[] tape = new boolean[1001];
        int answer = 0;
        for (int i=0;i<N;i++) {
            if (tape[pipe[i]]) continue;
            // 테이프 붙이기
            for (int j=0;j<L;j++) {
                if (pipe[i]+j<=1000) {
                    tape[pipe[i] + j] = true;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        pipe = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            pipe[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pipe);
    }
}