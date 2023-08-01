import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int[] dxs = {0, 0, 1};
	static final int[] dys = {1, -1, 0};
	static final int SIZE = 100;
	static boolean[][] visited;
	static int winner ;
	
	public static void main(String[] args) throws IOException {
		for (int test_case = 1; test_case<=10;test_case++) {
			winner=0;
			int[][] board = input_();
			for (int i=0;i<SIZE;i++) {
				if (board[0][i]==1) {
					visited = new boolean[SIZE][SIZE];
					isWinner(board, i, 0, i);
				}
				if (winner!=0) break;
			}
			System.out.println("#"+test_case+" "+winner);
		}
	}
	
	static void isWinner (int[][] board, int startX, int x, int y) {
		if (board[x][y]==2) {
			winner = startX;
			return ;
		}
		for (int d=0;d<3;d++) {
			int nx = x+dxs[d], ny = y+dys[d];
			if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny]!=0) {
				visited[nx][ny]=true;
				isWinner(board, startX, nx, ny);
				return ;
			}
		}
 	}
	
	static int[][] input_() throws IOException {
		StringTokenizer tokenizer;
		int[][] inputArr = new int[SIZE][SIZE];
		String temp = br.readLine();
		for (int i=0;i<SIZE;i++) {
			tokenizer=new StringTokenizer(br.readLine());
			for (int j=0;j<SIZE;j++) {
				inputArr[i][j]=Integer.parseInt(tokenizer.nextToken());
			}
		}
		return inputArr;
	}
	
	static boolean inRange(int x, int y) {
		return 0<=x && x<SIZE && 0<=y && y<SIZE;
	}
}