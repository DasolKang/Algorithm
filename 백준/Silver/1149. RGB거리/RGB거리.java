import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N개의 집을 빨강, 초록, 파랑 중 하나의 색으로 칠하고자 한다.
 * 인접한 집을 같은 색으로 칠할 수 없다.
 * 2. strategy: 풀이전략
 * 인접한 집은 같은 색으로 칠할 수 없으므로
 * 집을 순서대로 색칠한 최소 비용을 저장해놓은 배열을 이용하여
 * i번째 집을 3가지로 칠하는 최소비용을 
 * i-1번째 집을 현재 색과 다른 색으로 칠한 최소비용과 현재 집을 칠하는 비용과 합친다.
 * dp[i][0] = dp[i-1][1]+cost[i][0] vs dp[i-1][2]+cost[i][0]
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] colorCost = new int[N][3]; // 빨강-초록-파랑 순
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				colorCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] minCost = new int[N][3]; // minCost[i][j] : i번째 집을 j로 칠했을 때 최소비용
		for (int i = 0; i < 3; i++)
			minCost[0][i] = colorCost[0][i];
		for (int i = 1; i < N; i++) { // i번째 집 칠하기
			for (int j = 0; j < 3; j++) { // 해당 집 칠할 색
				int cost = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) { // i-1번째 집 색
					if (j == k)
						continue; // 같은 색일 경우 넘어가기
					cost = Math.min(cost, minCost[i - 1][k] + colorCost[i][j]);
				}
				minCost[i][j] = cost;
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, minCost[N - 1][i]);
		}
		System.out.println(answer);
	}

}