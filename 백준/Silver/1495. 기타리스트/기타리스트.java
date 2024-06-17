import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, S, M, volumn[];
	private static boolean dp[][];

	public static void main(String[] args) throws IOException {
		init();
		dp[0][S]=true;
		for (int i=1;i<=N;i++) {
			for (int j=0;j<=M;j++) {
				if (dp[i-1][j]) {
					if (j+volumn[i-1]<=M) {
						dp[i][j+volumn[i-1]] = true;
					}
					if (j-volumn[i-1]>=0) {
						dp[i][j-volumn[i-1]] = true;
					}
				}
			}
		}
		int answer = -1;
		for (int i=M;i>=0;i--) {
			if (dp[N][i]) {
				answer = i;
				break ;
			}
		}
		System.out.println(answer);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		volumn = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			volumn[i] = Integer.parseInt(st.nextToken());
		}
		dp = new boolean[N + 1][M + 1];
	}
}