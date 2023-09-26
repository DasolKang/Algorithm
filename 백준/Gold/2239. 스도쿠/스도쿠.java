import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 *	완성되지 않은 스도쿠 퍼즐이 주어질 때, 
 *	스도쿠를 완성시킬 수 있는 경우의 수 중 사전순으로 가장 앞서는 답을 구하라
 * 2. strategy: 풀이전략
 * 	백트래킹을 사용하여 가로, 세로, 3*3을 확인한 후 가능한 경우만 재귀로 탐색
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static final int SIZE = 9;
	private static int zeroNum, board[][];
	private static List<int[]> zero;
	private static boolean already;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		sudoku(0);
	}

	private static void sudoku(int zeroIdx) {
		if (zeroIdx == zeroNum) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			already = true;
			return;
		}

		if (already)
			return;

		// 가능한 숫자 찾기
		boolean[] poss = new boolean[SIZE + 1];
		int x = zero.get(zeroIdx)[0], y = zero.get(zeroIdx)[1];
		for (int i = 0; i < SIZE; i++) {
			poss[board[x][i]] = true;
			poss[board[i][y]] = true;
		}

		// 3*3 확인
		int checkX = x / 3 * 3;
		int checkY = y / 3 * 3;
		for (int i = checkX; i < checkX + 3; i++) {
			for (int j = checkY; j < checkY + 3; j++) {
				poss[board[i][j]] = true;
			}
		}

		for (int i = 1; i <= SIZE; i++) {
			if (poss[i])
				continue;
			board[x][y] = i;
			sudoku(zeroIdx + 1);
			board[x][y] = 0;
		}

	}

	private static int[][] copy(int[][] array) {
		int[][] result = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			result[i] = array[i].clone();
		}
		return result;
	}

	private static void init(BufferedReader br) throws IOException {
		board = new int[SIZE][SIZE];
		zero = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = temp[j] - '0';
				if (board[i][j] == 0) {
					zeroNum++;
					zero.add(new int[] { i, j });
				}
			}
		}
	}
}
