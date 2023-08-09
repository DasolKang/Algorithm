import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 100*100 크기의 도화지에 10*10의 검은 색종이를 붙인 후 검은 영역의 넓이를 구하라
 * 2. strategy: 풀이전략
 * 색종이를 모두 붙인 후 검은 영역을 구한다.
 * 3. note: 주의할 사항(특이사항)
 * 색종이가 도화지 밖으로 나가는 경우는 없다.
 */

public class Main {

	private static int[][] board;
	private static final int SIZE = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[SIZE][SIZE];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			color(x, y);
		}
		
		int answer = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static void color(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				board[i][j] = 1;
			}
		}
	}
}