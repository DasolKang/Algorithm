import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 정수 n이 주어질 때, n을 1,2,3의 합 나타내는 방법의 수를 구하라
 * 2. strategy: 풀이전략
 * 인덱스를 만드는 합의 경우의 수를 저장해두었을 떄,
 * i의 경우의 수를 구하는 방법은 
 * i-3에 3을 더하는 경우
 * i-2에 2를 더하는 경우
 * i-1에 1을 더하는 경우
 * 3가지 이므로 dp[i]=dp[i-1]+dp[i-2]+dp[i-3]을 하여 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[12];
		getCases();
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}

	private static void getCases() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
	}

}