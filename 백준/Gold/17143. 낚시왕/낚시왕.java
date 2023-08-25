import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 낚시왕은 첫번째 열부터 오른쪽으로 이동하며 상어를 낚시한다.
 * 낚시왕은 위치한 열의 가장 가까운 상어를 잡을 수 있다.
 * 상어는 주어진 속도로 바라보고 있는 방향으로 이동한다. 
 * (격자를 벗어나면 방향을 반대로 바꾸어 계속 이동한다)
 * 여러 상어가 한 칸에 위치한다면, 크기가 가장 큰 상어가 다른 상어들을 잡아먹는다.
 * 낚시왕이 잡은 상어 크기의 합을 구하라.
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int R, C, M;
	private static int[] dxs = { -1, 1, 0, 0, 1, -1, 0, 0 };
	private static int[] dys = { 0, 0, 1, -1, 0, 0, -1, 1 };
	private static Shark[][] board;

	private static class Shark {
		int x, y, size, dir, speed;

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dir = dir;
			this.speed = speed;
		}

		private int[] move() {
			int[] result = new int[2];
			int x = this.x, y = this.y;
			for (int i = 0; i < speed; i++) {
				int nx = x + dxs[dir], ny = y + dys[dir];
				if (!inRange(nx, ny)) {
					turn();
					nx = x + dxs[dir];
					ny = y + dys[dir];
				}
				x = nx;
				y = ny;
			}
			this.x = x;
			this.y = y;
			return new int[] { x, y };
		}

		private void turn() {
			this.dir = (dir + 4) % 8;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		int answer = 0;
		for (int fisher = 0; fisher < C; fisher++) {
			for (int i = 0; i < R; i++) {
				if (board[i][fisher] != null) {
					answer += board[i][fisher].size;
					board[i][fisher] = null;
					break;
				}
			}
			moveShark();
		}
		System.out.println(answer);
	}

	private static void moveShark() {
		Shark[][] afterMove = new Shark[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == null)
					continue;
				Shark moveShark = board[i][j];
				int[] afterMoving = moveShark.move();

				if (afterMove[afterMoving[0]][afterMoving[1]] != null) {
					// 같은 위치에 상어 존재할 떄
					Shark alive = afterMove[afterMoving[0]][afterMoving[1]].size > moveShark.size
							? afterMove[afterMoving[0]][afterMoving[1]]
							: moveShark;
					afterMove[afterMoving[0]][afterMoving[1]] = alive;
				} else {
					afterMove[afterMoving[0]][afterMoving[1]] = moveShark;
				}
			}
		}
		board = afterMove;
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			board[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d - 1, z);
		}
	}

}