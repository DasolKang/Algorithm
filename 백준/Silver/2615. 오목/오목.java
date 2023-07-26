import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dxs = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dys = {1, 1, 1, 0, -1, -1, -1, 0};
	final static int SIZE = 19;
	static int winner = 0;
	static int winX=0, winY=0;
	static boolean[][] visited=new boolean[SIZE][SIZE];
	
	public static void main(String[] args) throws IOException {
		int[][] board = input_();
		for (int i=0;i<SIZE;i++) {
			for (int j=0;j<SIZE;j++) {
				if (board[i][j]==1) {
					for (int d=0;d<4;d++) {
						isWinner(board, i, j, i, j, 1, 1, d);
					}
				} else if (board[i][j]==2) {
					for (int d=0;d<4;d++) {
						isWinner(board, i, j, i, j, 2, 1, d);
					}
				} 
			}
		}
		System.out.println(winner);
		if (winner!=0)	System.out.println((winX+1) + " " + (winY+1));
	}
	
	static void isWinner(int[][] board, int x, int y, int startX, int startY, int player, int depth, int dirIndex) {
		// 현재까지의 depth==5 and 다음 칸의 바둑알을 색이 달라지면 winner
		visited[x][y]=true;
		int nx = x+dxs[dirIndex];
		int ny = y+dys[dirIndex];
		if (inRange(nx, ny) && board[nx][ny]==player) {
				isWinner(board, nx, ny, startX, startY, player, depth+1, dirIndex);
		} else if (depth==5){
			if (checkRealWinner(board, startX, startY, dirIndex, player)) {
				winner = player;
				winX=startX;
				winY=startY;
				return ;
			} 
		} 
	}
	
	static boolean checkRealWinner(int[][] board, int x, int y, int dirIndex, int player) {
		int dir = (dirIndex+4)%8;
		int nx = x+dxs[dir];
		int ny = y+dys[dir];
		if (inRange(nx, ny) && board[nx][ny]==player) return false;
		return true;
	}
	
	static boolean inRange(int x, int y) {
		return 0<=x && x<SIZE && 0<=y && y<SIZE;
	}
	
	static int[][] input_() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int[][] inputBoard = new int[SIZE][SIZE];
		for (int i=0;i<SIZE;i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j=0;j<SIZE;j++) {
				inputBoard[i][j]=Integer.parseInt(tokenizer.nextToken());
			}
		}
		return inputBoard;
	}
}