import java.util.*;
import java.io.*;

public class Main {

    private static int N, target, diameter;
    private static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        target = 1;
        dfs(1, 0, new boolean[N+1]);
        dfs(target, 0, new boolean[N+1]);
        System.out.println(diameter);
    }

    private static void dfs(int curNode, int dist, boolean[] visited) {
        visited[curNode] = true;
        if (dist > diameter) {
            diameter = dist;
            target = curNode;
        }
        for (int[] nextInfo : graph[curNode]) {
            if (!visited[nextInfo[0]]) {
                visited[nextInfo[0]] = true;
                dfs(nextInfo[0], dist + nextInfo[1], visited);
                visited[nextInfo[0]] = false;
            }
        }
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, v});
            graph[e].add(new int[]{s, v});
        }
    }
}