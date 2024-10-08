import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, dp[][];

	public static void main(String[] args) throws IOException {
		init();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int[] compare = {dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]};
				dp[i][j] += Arrays.stream(compare).max().getAsInt();
			}
		}
		System.out.println(dp[N][M]);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}