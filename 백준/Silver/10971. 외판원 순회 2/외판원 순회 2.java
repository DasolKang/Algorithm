import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 한 도시에서 출발하여 N개의 도시를 모두 거쳐 다시 출발 도시로 돌아오고자 한다.
 * 한 번 갔던 도시로는 다시 갈 수 없다.
 * 가장 적은 비용으로 도시를 순회하는 경로를 구하라.
 * 2. strategy: 풀이전략
 * 출발했던 도시로 다시 돌아오는 경로를 짜기 위해 모든 경로를 다 탐색해본다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int N, cities[][];
	private static int minCost, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		minCost = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			end = i;
			getMinCost(i, new int[N], 0);
		}
		System.out.println(minCost);
	}

	private static void getMinCost(int cur, int[] visited, int depth) {
		if (depth == N - 1) {
			// 모든 섬 방문했을 경우 시작점으로 돌아갈 수 있는지 확인
			if (cities[cur][end] != 0) {
				minCost = Math.min(minCost, visited[cur] + cities[cur][end]);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (i != end && cities[cur][i] != 0 && visited[i] == 0) {
				// 시작점 아니고 연결되어 있고 방문한적 없다면
				visited[i] = visited[cur] + cities[cur][i];
				getMinCost(i, visited, depth + 1);
				visited[i] = 0;
			}
		}
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		cities = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cities[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}