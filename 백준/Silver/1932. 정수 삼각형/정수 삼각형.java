import java.util.*;
import java.io.*;

public class Main {

	private static int n, result, tree[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new int[n][];
		dp = new int[n][];
		for (int i = 0; i < n; i++) {
			tree[i] = new int[i + 1];
			dp[i] = new int[i + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = tree[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + tree[i][0];
			dp[i][i] = dp[i - 1][i - 1] + tree[i][i];
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tree[i][j];
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}
		System.out.println(answer);
	}
}