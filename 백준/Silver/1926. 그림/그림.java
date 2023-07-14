import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[][] board = new int[n][m];
		for (int i=0;i<n;i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		int[] dxs = {-1, 0, 0, 1};
		int[] dys = {0, -1, 1, 0};
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		int answer=0;
		int paintNum=0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (board[i][j]==1 && !visited[i][j]) {
					visited[i][j]=true;
					queue.offer(new int[] {i, j});
					int maxSize = 1;
					paintNum++;
					while (queue.size()!=0) {
						int[] temp = queue.poll();
						int x = temp[0];
						int y = temp[1];
						for (int d=0;d<4;d++) {
							int nx = x+dxs[d];
							int ny = y+dys[d];
							if (inRange(nx, ny, n, m) && !visited[nx][ny] && board[nx][ny]==1) {
								visited[nx][ny]=true;
								queue.offer(new int[] {nx, ny});
								maxSize++;
							}
						}
					}
					if (maxSize>answer) answer=maxSize;
				}
			}
		}
		System.out.println(paintNum);
		System.out.println(answer);
	}
	
	public static boolean inRange(int x, int y, int n, int m) {
		return 0<=x && x<n && 0<=y && y<m;
	}
}