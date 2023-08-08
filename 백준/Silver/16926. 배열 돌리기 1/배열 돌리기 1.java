import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int r = Integer.parseInt(input[2]);
		
		int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		int[][] arr = new int[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		
		for (int i = 0; i < r; i++) {
			int[][] rotatedArr = new int[n][m];
			int sx = 0, sy = 0;
			int cx = 0, cy = 0;
			int dir = 0;
			while (rotatedArr[sx][sy] == 0) {
				int nx = cx + dxy[dir][0], ny = cy + dxy[dir][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || rotatedArr[nx][ny] > 0) {
					dir = dir + 1 == 4 ? 1: dir + 1;
					nx = cx + dxy[dir][0];
					ny = cy + dxy[dir][1];
				}
				rotatedArr[nx][ny] = arr[cx][cy];
				
				cx = nx;
				cy = ny;
				if (cx == sx && cy == sy) {
					cx ++;
					cy ++;
					sx ++;
					sy ++;
					dir = 0;
				}
			}
			
			arr = rotatedArr;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}