import java.util.*;
import java.io.*;

public class Main {
	private static int N, M, board[][], tempBoard[][];
	private static int cctvNum, maxArea;
	private static List<int[]> cctvLocation;
	private static final int[] dxs = { -1, 0, 1, 0 };
	private static final int[] dys = { 0, 1, 0, -1 };
	private static int[] cctvDir = { 0, 4, 2, 4, 4, 1 };
	private static Map<Integer, int[][]> cctv = new HashMap<Integer, int[][]>() {
		{
			put(1, new int[][] { { 0 }, { 1 }, { 2 }, { 3 } });
			put(2, new int[][] { { 1, 3 }, { 2, 0 } });
			put(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } });
			put(4, new int[][] { { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } });
			put(5, new int[][] { { 0, 1, 2, 3 } });
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctvLocation = new ArrayList<>();
		cctvNum = 0;
		int blank = 0;
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0)
					blank++;
				if (board[i][j] != 0 && board[i][j] != 6) {
					cctvLocation.add(new int[] { i, j });
					cctvNum++;
				}
			}
		}
		solution(board, 0, 0);
		System.out.println(blank - maxArea);
	}

	private static void solution(int[][] board, int cur, int area) {
		if (cur == cctvNum) {
			maxArea = Math.max(area, maxArea);
			return;
		}
		int[] curCctv = cctvLocation.get(cur);
		int cctvNumber = board[curCctv[0]][curCctv[1]];
		for (int i = 0; i < cctvDir[cctvNumber]; i++) {
			tempBoard = deepCopy(board);
			solution(tempBoard, cur + 1, area + getArea(curCctv[0], curCctv[1], cctvNumber, i));
		}
	}

	private static int getArea(int x, int y, int c, int dir) {
		int result = 0;
		int[] move = cctv.get(c)[dir];
		int nx = x, ny = y;
		for (int m : move) {
			nx = x + dxs[m];
			ny = y + dys[m];
			while (inRange(nx, ny) && tempBoard[nx][ny] != 6) {
				if (tempBoard[nx][ny] == 0) {
					result++;
					tempBoard[nx][ny] = 1;
				}
				nx = nx + dxs[m];
				ny = ny + dys[m];
			}
		}
		return result;
	}

	private static int[][] deepCopy(int[][] board) {
		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			result[i] = board[i].clone();
		}
		return result;
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}