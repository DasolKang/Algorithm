import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 흑백 영상을 압축하여 표현하는 데이터 구조로 쿼드 트리가 있다.
 * -> 영상이 모두 0이거나 1이면 0, 1로 압축한다.
 * -> 영상에 0과 1이 함께 있다면, 왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래로 나누어 압축
 * 2. strategy: 풀이전략
 * 분할정복을 이용하여 이미지를 압축한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int N, board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] input_ = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = input_[j] - '0';
			}
		}
		zip(N, 0, 0, N, N);
		System.out.println(sb.toString());
	}

	private static void zip(int size, int startX, int startY, int endX, int endY) {
		int sum = 0;
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				sum += board[i][j];
			}
		}
		
		if (sum == 0) {
			sb.append("0");
			return;
		}
		if (sum == size * size) {
			sb.append(1);
			return;
		}
		
		sb.append("(");
		int mid = size / 2;
		zip(mid, startX, startY, startX + mid, startY + mid);
		zip(mid, startX, startY + mid, startX + mid, endY);
		zip(mid, startX + mid, startY, endX, startY + mid);
		zip(mid, startX + mid, startY + mid, endX, endY);
		sb.append(")");
	}
}