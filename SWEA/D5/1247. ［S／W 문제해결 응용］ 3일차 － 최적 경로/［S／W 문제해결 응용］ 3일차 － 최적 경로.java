import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N명의 고객을 방문하고 자신의 집으로 돌아갈 때 최단 경로로 방문하고자 한다.
 * 각 고객의 좌표가 주어질 때 가장 짧은 경로를 구하라.
 * 2. strategy: 풀이전략
 * 각 고객의 집들을 방문하는 경우의 수를 모두 구하여 가장 짧은 경로를 구한다.
 * -> 저장된 최단 경로의 길이보다 거리가 긴 경로는 더 이상 탐색하지 않는다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static BufferedReader br;
	private static int N, company[], home[], customer[][];
	private static int answer, result[];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			input_();
			result = new int[N];
			answer = Integer.MAX_VALUE;
			delivery(0, new boolean[N], company[0], company[1], 0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void delivery(int index, boolean[] visited, int lastX, int lastY, int distance) {
		if (index == N) {
			answer = Math.min(answer, distance + getDistance(lastX, lastY, home[0], home[1]));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			int dist = distance + getDistance(lastX, lastY, customer[i][0], customer[i][1]);
			if (dist > answer)
				continue;
			visited[i] = true;
			result[index] = i;
			delivery(index + 1, visited, customer[i][0], customer[i][1], dist);
			visited[i] = false;
		}
	}

	private static int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	private static void input_() throws IOException {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		company = new int[2];
		home = new int[2];
		company[0] = Integer.parseInt(st.nextToken());
		company[1] = Integer.parseInt(st.nextToken());
		home[0] = Integer.parseInt(st.nextToken());
		home[1] = Integer.parseInt(st.nextToken());
		customer = new int[N][2];
		for (int i = 0; i < N; i++) {
			customer[i][0] = Integer.parseInt(st.nextToken());
			customer[i][1] = Integer.parseInt(st.nextToken());
		}
	}

}