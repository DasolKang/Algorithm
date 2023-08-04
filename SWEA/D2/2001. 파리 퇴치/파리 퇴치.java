import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	  M x M 크기의 파리채를 내려쳐 최대한 많은 파리를 죽이고자 한다.
 *    파리채를 내리쳐 잡을 수 있는 파리의 최대 수를 구하라
 * 2. strategy: 풀이전략
 * 	  보드의 [0, 0] ~ [N-1, N-1] 까지 M x M 크기의 정사각형 내의 파리의 수를 모두 구해 최대를 구한다
 * 3. note: 주의할 사항(특이사항)
 */


public class Solution {
	static int N, M, board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());

			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int fly = getFlyNum(i, j);
					answer = Math.max(answer, fly);
				}
			}
			System.out.println("#" + t + " " + answer);
		}

	}

	static int getFlyNum(int x, int y) {
		int fly = 0;
		for (int i = x; i < x + M; i++) {
			for (int j = y; j < y + M; j++) {
				if (inRange(i, j))
					fly += board[i][j];
			}
		}
		return fly;
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}