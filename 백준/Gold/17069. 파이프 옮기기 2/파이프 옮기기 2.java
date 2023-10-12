import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N*N 격자판에서 파이프를 (1, 1)에서 (N, N)으로 옮기고자 한다.
 * 파이프는 빈칸으로만 이동 가능하며 오른쪽, 아래, 오른쪽 대각선 아래로만 이동 가능하다.
 * 회전 역시 오른쪽, 아래, 오른쪽 아래 대각선 방향으로 45도만 회전 가능하다.
 * 파이프를 이동시키는 방법의 수를 구하라.
 * 2. strategy: 풀이전략
 * 오른쪽, 아래, 오른쪽 아래 대각선 방향에 대해 가능한 경우의 수를 합치며 풀이한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static final Map<Integer, int[]> directions = new HashMap<Integer, int[]>() {
		{
			put(0, new int[] { 0, 2 }); // 가로
			put(1, new int[] { 1, 2 }); // 세로
			put(2, new int[] { 0, 1, 2 }); // 대각선
		}
	};

	private static final int[][] move = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	private static int N, board[][];
    private static long dp[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		dp = new long[N][N][N]; // [x][y][direction]
		dp[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 3; d++) {
					if (dp[i][j][d] != 0 && board[i][j] == 0)
						getMoveNum(i, j, d);
				}
			}
		}
		long answer = 0;
		for (int i=0;i<3;i++) {
			answer+=dp[N-1][N-1][i];
		}
		System.out.println(answer);
	}

	private static void getMoveNum(int x, int y, int dir) {
		int[] temp = directions.get(dir);
		for (int d : temp) {
			int nx = x + move[d][0], ny = y + move[d][1];
			if (inRange(nx, ny) && board[nx][ny] == 0) {
				if (d == 2) {// 대각선일 때는 3칸이 비어있어야 함
					if (poss(nx, ny)) dp[nx][ny][d] += dp[x][y][dir];
				} else {
					dp[nx][ny][d] += dp[x][y][dir];
				}
			}
		}
	}

	private static boolean poss(int x, int y) {
		return inRange(x - 1, y) && board[x - 1][y] == 0 && inRange(x, y - 1) && board[x][y - 1] == 0;
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}