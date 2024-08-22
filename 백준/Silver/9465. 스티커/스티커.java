import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, sticker[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init(br);
			int beforeMax = Integer.max(dp[0][0], dp[1][0]);
			for (int i = 1; i < N; i++) {
				// 첫번째 스티커 사용하는 경우 : 두번째 스티커 사용 or 전 스티커 미사용
				dp[0][i] = Integer.max(dp[1][i - 1] + sticker[0][i], dp[2][i - 1] + sticker[0][i]);
				// 두번째 스티커 사용하는 경우 : 첫번째 스티커 사용 or 전 스티커 미사용
				dp[1][i] = Integer.max(dp[0][i - 1] + sticker[1][i], dp[2][i - 1] + sticker[1][i]);
				// 이번 스티커 사용하지 않는 경우 : 전 스티커 사용 최대 점수
				dp[2][i] = beforeMax;
				beforeMax = Integer.max(dp[0][i], dp[1][i]);
				beforeMax = Integer.max(beforeMax, dp[2][i]);
			}
			int answer = Integer.max(dp[0][N-1], dp[1][N-1]);
			answer = Integer.max(answer, dp[2][N-1]);
			System.out.println(answer);
		}

	}

	private static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		sticker = new int[2][N];
		dp = new int[3][N];
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sticker[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = sticker[0][0];
		dp[1][0] = sticker[1][0];
	}

}