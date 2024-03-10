import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        int answer = getTime(0);
        System.out.println(answer);
    }

    private static int getTime(int start) {
        if (tree[start].isEmpty()) return 0;
        int[] time = new int[tree[start].size()];
        for (int i = 0; i < tree[start].size(); i++) {
            time[i] = 1 + getTime(tree[start].get(i));
        }
        Arrays.sort(time);
        int max = 0;
        for (int i = 0; i < time.length; i++) {
            time[i] += (time.length - i -1);
            max = Math.max(max, time[i]);
        }
        return max;
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }
    }
}