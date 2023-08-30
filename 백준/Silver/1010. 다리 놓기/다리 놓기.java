import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 동쪽과 서쪽에 위치한 사이트를 연결하는 다리를 짓고자 한다.
 * 다리끼지는 서로 겹쳐질 수 있을 때, N개의 다리를 지을 수 있는 경우의 수를 구하라
 * 2. strategy: 풀이전략
 * 반드시 N개의 다리를 연결해야 하므로 M개 중에 N개를 뽑는 조합을 사용한다.
 * 조합을 뽑는 식은 nCr = n-1Cr-1 + n-1Cr을 이용하여 dp에 저장된 조합값을 활용한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int N, M, dp[][]; //dp[n][r] : nCr 값 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			input(br);
			combination();
			System.out.println(dp[N][M]);
		}
	}

	private static void combination() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0, end = Math.min(i, M); j <= end; j++) {
				if (j == 0 || i == j) dp[i][j] = 1; 
				else // nCr = n-1Cr-1 + n-1Cr
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][N + 1];
	}

}