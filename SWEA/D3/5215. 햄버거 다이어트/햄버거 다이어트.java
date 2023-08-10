import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 민기는 햄버거의 맛을 최대한 유지하며 정해진 칼로리를 넘지 않는 햄버거를 만들고자 한다.
 * 각 재료는 맛 점수와 칼로리가 정해져 있다.
 * 제한 칼로리 내의 가장 맛 점수가 높은 햄버거의 점수를 구하라
 * 2. strategy: 풀이전략
 * dp[i][j] : i번 재료까지 j 칼로리 내에 얻을 수 있는 최대 점수
 * i-1번째 재료까지 j칼로리 내 최대점수 vs i-1재료까지 j-현재 재료 칼로리인 최대점수 + 재료의 점수
 * dp[i][j] = dp[i-1][j] vs dp[i-1][j-(i)재료 칼로리]+i번 재료 점수
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료 개수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			int[] cal = new int[N + 1], taste = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[N + 1][L + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if (j - cal[i] >= 0) // 해당 재료 넣을 수 있을 때
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal[i]] + taste[i]);
					else
						dp[i][j] = dp[i - 1][j];
				}
			}
			sb.append("#").append(test_case).append(" ");
			sb.append(dp[N][L]).append("\n");
		}
		System.out.println(sb.toString());

	}
}