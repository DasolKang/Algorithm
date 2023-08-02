import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	   N*N 크기의 표에 수가 채워져 있을 때 (x1, y1)~(x2, y2)의 합을 구하라
 * 2. strategy: 풀이전략
 * 	  누적합을 이용하여 풀이한다
 *    1. (x, y)칸의 누적합을 구하는 경우
 *    	  prefixSum(x, y) = board(x, y) + prefixSum(x-1, y) + prefixSum(x, y-1) - prefixSum(x-1, y-1)
 *    2. (x1, y1) ~ (x2, y2)의 합을 구하는 경우
 *    	  prefixSum(x2, y2) - prefixSum(x1-1, y2) - prefixSum ( x2, y1-1) + prefixSum(x1-1, y1-1)
 * 3. note: 주의할 사항(특이사항)
 */


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		int[][] prefixSum = getPrefixSum(N, board);
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokenizer.nextToken()), y1 = Integer.parseInt(tokenizer.nextToken());
			int x2 = Integer.parseInt(tokenizer.nextToken()), y2 = Integer.parseInt(tokenizer.nextToken());
			sb.append(prefixSum[x2][y2]-prefixSum[x1-1][y2]-prefixSum[x2][y1-1]+prefixSum[x1-1][y1-1]+"\n");
		}
		System.out.println(sb.toString());
	}

	static int[][] getPrefixSum(int N, int[][] board) {
		int[][] result = new int[N+1][N+1];
		result[1][1] = board[0][0];
		for (int i = 1; i < N+1; i++) {
			result[1][i] = board[0][i-1] + result[1][i-1];
			result[i][1] = board[i-1][0] + result[i-1][1];
		}
		for (int i = 2; i < N+1; i++) {
			for (int j = 2; j < N+1; j++) {
				result[i][j] = board[i-1][j-1] + result[i - 1][j] + result[i][j - 1] - result[i - 1][j - 1];
			}
		}
		return result;
	}

}
