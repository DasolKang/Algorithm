import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, indegree[];
    private static boolean graph[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            init(br);
            StringBuilder answer = new StringBuilder();
            int ansNum = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                answer.append(cur).append(" ");
                ansNum++;
                for (int next = 1; next <= N; next++) {
                    if (next == cur) continue;
                    if (graph[cur][next]) {
                        indegree[next]--;
                        if (indegree[next] == 0) {
                            queue.add(next);
                        }
                    }
                }
            }
            if (ansNum == N) System.out.println(answer.toString());
            else System.out.println("IMPOSSIBLE");
        }
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new boolean[N + 1][N + 1];
        indegree = new int[N + 1];
        List<Integer> before = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            // 작년 순위 저장
            int team = Integer.parseInt(st.nextToken());
            for (int b : before) {
                graph[b][team] = true;
            }
            before.add(team);
            indegree[team] = i - 1;
        }

        M = Integer.parseInt(br.readLine());
        // 순위 바뀐 팀
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (graph[a][b]) {
                graph[a][b] = false;
                graph[b][a] = true;
                indegree[a]++;
                indegree[b]--;
            } else {
                graph[a][b] = true;
                graph[b][a] = false;
                indegree[b]++;
                indegree[a]--;
            }
        }
    }
}