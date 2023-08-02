import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snail = drawSnail(N);
			sb.append("#").append(test_case).append("\n");
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int[][] drawSnail(int N) {
		int[][] result = new int[N][N];
		int[] dxs = { 0, 1, 0, -1 };
		int[] dys = { 1, 0, -1, 0 };
		int count = 1;
		int x = 0, y = 0, dir = 0;
		while (result[x][y] == 0) {
			result[x][y] = count++;
			int nx = x + dxs[dir], ny = y + dys[dir];
			if (inRange(nx, ny, N) && result[nx][ny] == 0) {
				x = nx;
				y = ny;
			} else {
				dir = (dir + 1) % 4;
				x = x + dxs[dir];
				y = y + dys[dir];
				if (!inRange(x, y, N)) break;
			}
		}
		return result;

	}

	static boolean inRange(int x, int y, int N) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}