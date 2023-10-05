import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 *  비버가 물을 피해 굴로 이동하는 최소시간을 구하라
 *  물은 비어있는 인접한 칸으로 확장하며, 비버도 인접한 4칸으로 이동가능하다
 *  비버는 물이 차있거나 물이 찰 예정인 칸으로 이동할 수 없다.
 * 2. strategy: 풀이전략
 * 	비버는 물이 찰 예정인 칸으로 이동할 수 없으므로 물부터 확장시킨다.
 *  물을 확장시킨 후 이동할 수 있는 칸이 있다면 비버를 이동시키고 시간을 증가시킨다.
 *  비버가 굴에 도착하는 시간이 정답, 이동할 칸이 없다면 "KAKTUS"
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int R, C;
	private static char[][] board;
	private static final int[] dxs = { -1, 0, 1, 0 };
	private static final int[] dys = { 0, 1, 0, -1 };
	private static int dochiX, dochiY;
	private static Queue<int[]> water;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		int possible = isPossible();
		System.out.println(possible == 0 ? "KAKTUS" : possible);
	}

	private static int isPossible() {
		int time = 0;
		int[][] visited = new int[R][C];
		visited[dochiX][dochiY] = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { dochiX, dochiY });
		while (!queue.isEmpty()) {
			spreadWater();
			int move = queue.size();
			while (move>0) {
				move--;
				int[] temp = queue.poll();
				if (board[temp[0]][temp[1]] == 'D')
					time = visited[temp[0]][temp[1]] - 1;
				for (int d = 0; d < 4; d++) {
					int nx = temp[0] + dxs[d];
					int ny = temp[1] + dys[d];
					if (inRange(nx, ny) && board[nx][ny] != '*' && board[nx][ny] != 'X' && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[temp[0]][temp[1]] + 1;
						queue.offer(new int[] { nx, ny });
					}
				}
			}
		}
		return time;
	}

	private static void spreadWater() {
		int spread = water.size();
		while (spread > 0) {
			spread--;
			int[] w = water.poll();
			int x = w[0], y = w[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dxs[d];
				int ny = y + dys[d];
				if (inRange(nx, ny) && board[nx][ny] != '*' 
						&& board[nx][ny] != 'D' && board[nx][ny] != 'X') {
					board[nx][ny] = '*';
					water.offer(new int[] { nx, ny });
				}
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		water = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '*') {
					water.offer(new int[] { i, j });
				} else if (board[i][j] == 'S') {
					dochiX = i;
					dochiY = j;
				}
			}
		}
	}
}