import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dxs = {1, 0, -1, 0};
	static int[] dys = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] snail = new int[N][N];
		int startNum = N*N;
		int direction = 0;
		int x=0, y=0;
		while (startNum>0) {
			snail[x][y]=startNum--;
			int nx = x+dxs[direction];
			int ny = y+dys[direction];
			if (inRange(N, nx, ny) && snail[nx][ny]==0) {
				x=nx; y=ny;
			} else {
				direction=(direction+1+4)%4;
				x=x+dxs[direction];
				y=y+dys[direction];
			}
		}
		printAnswer(snail, M);
	}
	
	static boolean inRange(int N, int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	
	static void printAnswer(int[][] array, int M) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ansX=0, ansY=0;
 		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j]==M) {
					ansX=i+1;
					ansY=j+1;
				}
				bw.write(String.valueOf(array[i][j])+" ");
			}
			bw.write("\n");
		}
 		bw.write(String.valueOf(ansX)+" "+String.valueOf(ansY));
 		bw.flush();
	}

}
