import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N*M 배열을 반시계 방향으로 R번 돌리고자 한다.
 * 2. strategy: 풀이전략
 * 반시계 방향으로 회전하는 메서드 만들어서 R번 반복
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int N, M, board[][];
	private static final int[] dxs = { 0, 1, 0, -1 };
	private static final int[] dys = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		int R = Integer.parseInt(tokenizer.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		for (int i = 0; i < R; i++)
			rotation();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void rotation() {
		int[][] result = new int[N][M];
		int minSize = Math.min((int) N / 2, (int) M / 2);
		for (int i = 0; i < minSize; i++) {
			int x = i, y = i;
			int dir = 0;
			int temp = board[x][y];
			while (true) {
				if (result[x][y] != 0)
					break;
				int nx = x + dxs[dir], ny = y + dys[dir];
				if (!inRange(nx, ny)) {
					// 범위 바깥이라면 방향 변환
					dir++;
					continue;
				}
				if (dir == 3 && result[nx][ny] != 0) {
					// 한바퀴 다 돌았다면 stop
					result[x][y] = temp;
					break;
				}
				if (result[nx][ny] != 0) {
					// 바깥 원을 만났다면 방향 전환
					dir = dir + 1;
					continue;
				}
				result[x][y] = board[nx][ny];
				x = nx;
				y = ny;
			}
		}

		board = result;
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}