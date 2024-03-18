import java.util.*;
import java.io.*;

public class Main {

    private static int N, parents[];
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        parents[1] = -1;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int child : graph[p]) {
                if (parents[child] == 0) {
                    parents[child] = p;
                    queue.add(child);
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}