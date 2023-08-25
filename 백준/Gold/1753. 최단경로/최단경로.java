import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 방향그래프가 주어질 때, 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하라.
 * 2. strategy: 풀이전략
 * 다익스트라
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static final int INF = Integer.MAX_VALUE;
	private static int V, E, K;
	private static List<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		int[] distance = dijkstra(K);
		for (int i = 1; i <= V; i++) {
            System.out.println(distance[i]==INF?"INF":distance[i]);
		}
	}

	private static int[] dijkstra(int start) {
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;

		for (int i = 1; i <= V; i++) {
			int minCost = INF, minNode = -1;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && distance[j] < minCost) {
					minCost = distance[j];
					minNode = j;
				}
			}
			if (minNode == -1)
				break;
			visited[minNode] = true;

			for (int[] next : graph[minNode]) {
				int nextNode = next[0];
				int weight = next[1];
				if (!visited[nextNode] && distance[nextNode] > minCost + weight) {
					distance[nextNode] = minCost + weight;
				}
			}
		}
		return distance;
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new int[] { to, weight });
		}
	}

}