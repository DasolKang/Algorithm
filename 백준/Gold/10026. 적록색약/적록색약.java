import java.util.*;
import java.io.*;

public class Main {

	static boolean[][] visited;
	static int[] dxs = {-1, 0, 1, 0};
	static int[] dys = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		for (int i=0;i<N;i++) {
			board[i]=br.readLine().toCharArray();
		}
		
		int answer = getAreaNum(N, board);
		char[][] blindBoard = changeColor(N, board);
		int blindAns = getAreaNum(N, blindBoard);
		 System.out.println(answer+" "+blindAns);		
	}
	
	public static int getAreaNum(int N, char[][] board) {
		visited = new boolean[N][N];
		int tempAns=0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (!visited[i][j]) {
					tempAns++;
					bfs(N, board, i, j);
				}
			}
		}
		return tempAns;
	}
	
	public static void bfs(int N, char[][] board, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		while (queue.size()!=0) {
			int[] temp=queue.poll();
			int x=temp[0], y=temp[1];
			for (int d=0;d<4;d++) {
				int nx=x+dxs[d], ny=y+dys[d];
				if (inRange(nx, ny, N) && board[x][y]==board[nx][ny] && !visited[nx][ny]) {
					visited[nx][ny]=true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static boolean inRange(int x, int y, int N) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	
	public static char[][] changeColor(int size, char[][] board) {
		for (int i=0;i<size;i++) {
			for (int j=0; j<size;j++) {
				if (board[i][j]=='G') board[i][j]='R';
			}
		}
		return board;
	}
}