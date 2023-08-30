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

	private static int N, M, dp[][]; // dp[n][r] : nCr 값 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[31][31];
		for (int i = 0; i <= 30; i++) {
			dp[i][i] = 1; // nCn : 1
			dp[i][1] = i; // nC1 : n
		}
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			input(br);
			System.out.println(combination(N, M));
		}
	}

	private static int combination(int n, int r) {
		if (dp[n][r] != 0)
			return dp[n][r];
		dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
		return dp[n][r];
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	}

}