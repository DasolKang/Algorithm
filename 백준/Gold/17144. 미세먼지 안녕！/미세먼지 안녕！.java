import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	R*C 크기의 격자에 공기청정기와 미세먼지가 존재한다.
 * 	미세먼지는 인접한 네 방향으로 A/5 만큼 확산한다. (해당 칸은 A-(A/5)*확산칸의 양만 남는다)
 * 	공기청정기는 2행을 차지하며 윗바람은 반시계, 아랫바람은 시계방향으로 순환한다.
 * 2. strategy: 풀이전략
 * 	격자를 탐색하여 미세먼지가 존재하는 인접한 방향으로 미세먼지 확산
 *  -> 미세먼지가 이미 존재하는 칸에 확산된 미세먼지 합쳐주어야 함
 *  -> 미세먼지가 확산할 때는 다른 칸에서 확산된 미세먼지를 제외한 먼지만 확산
 *  공기청정기의 위와 아래 위치를 저장하여 작동
 *  -> 윗바람은 반시계 방향, 아랫바람은 시계방향
 *  -> 공기청정기로 돌아온 먼지는 제거됨
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int R, C, T, board[][];
	private static int high, low;
	private static final int[] dxs = { 0, -1, 0, 1 };
	private static final int[] dys = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		for (int i = 0; i < T; i++) {
			spread();
			blow(high, 1);
			blow(low, -1);
		}
		System.out.println(getDustNum());
	}

	private static void spread() {
		// 미세먼지 확산
		int[][] newBoard = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] > 0) {
					if (board[i][j] < 5) {
						newBoard[i][j] += board[i][j];
						continue;
					}
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dxs[d];
						int ny = j + dys[d];
						if (inRange(nx, ny) && board[nx][ny] != -1) {
							newBoard[nx][ny] += board[i][j] / 5;
							cnt++;
						}
					}
					newBoard[i][j] += board[i][j] - board[i][j] / 5 * cnt;
				} else if (board[i][j] == -1) {
					newBoard[i][j] = -1;
				}
			}
		}
		board = newBoard;
	}

	private static void blow(int start, int next) {
		// 공기청정
		int x = start, y = 1, dir = 0, dust = board[start][1];
		board[start][1] = 0;
		while (true) {
			int nx = x + dxs[dir];
			int ny = y + dys[dir];
			if (!inRange(nx, ny)) {
				dir = (dir + next + 4) % 4;
				continue;
			}
			if (board[nx][ny] == -1)
				break;
			int temp = dust;
			dust = board[nx][ny];
			board[nx][ny] = temp;
			x = nx;
			y = ny;
		}
	}

	private static int getDustNum() {
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] > 0) {
					result += board[i][j];
				}
			}
		}
		return result;
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					if (high != 0)
						low = i;
					else
						high = i;
				}
			}
		}
	}

}