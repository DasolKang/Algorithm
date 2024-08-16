import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n, k, coins[], dp[];

	public static void main(String[] args) throws IOException {
		init();
		for (int i = 1; i <= k; i++) {
			int minCount = 10001;
			for (int j = 0; j < n; j++) {
				if (i - coins[j] >= 0) {
					minCount = Integer.min(minCount, dp[i - coins[j]] + 1);
				}
			}
			dp[i] = minCount;
		}
		if (dp[k]==10001) dp[k]=-1;
		System.out.println(dp[k]);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins);
		dp = new int[k + 1];
	}
}