import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, nagaMax, posiMax;
    private static int books[];
    private static List<Integer> nega, posi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        int answer = 0;
        if (Math.abs(nagaMax) > posiMax) {
            // 음수 쪽이 더 멀리 있을 때
            answer += nega.get(0);
            for (int i=0;i<M;i++) {
                if (!nega.isEmpty()) nega.remove(0);
            }
        } else {
            // 양수 쪽이 더 멀리 있을 때
            answer += posi.get(posi.size()-1);
            for (int i=0;i<M;i++)  {
                if (!posi.isEmpty()) posi.remove(posi.size()-1);
            }
        }
        for (int i=0;i<nega.size();i+=M) {
            answer += (nega.get(i)*2);
        }
        for (int i=posi.size()-1;i>=0;i-=M) {
            answer += (posi.get(i)*2);
        }
        System.out.println(answer);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        nega = new LinkedList<>();
        posi = new LinkedList<>();
        Arrays.sort(books);
        for (int i=0;i<N;i++) {
            if (books[i]<0) nega.add(Math.abs(books[i]));
            else posi.add(books[i]);
        }
        nagaMax = books[0];
        posiMax = books[N-1];
    }
}