import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] graph;
    private static int[] hacking;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);

        for (int i=1;i<=N;i++) {
            getHacking(i, new boolean[N+1]);
        }

        int max = 0;
        for (int i=1;i<=N;i++) {
            if (max < hacking[i]) max = hacking[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=N;i++) {
            if (max == hacking[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void getHacking(int computer, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(computer);
        visited[computer] = true;

        while (!queue.isEmpty()) {
            int curCom = queue.poll();
            for (int next : graph[curCom]) {
                if (!visited[next]) {
                    visited[next] = true;
                    hacking[next]++;
                    queue.add(next);
                }
            }
        }
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        hacking = new int[N+1];
        for (int i=1;i<=N;i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
    }
}