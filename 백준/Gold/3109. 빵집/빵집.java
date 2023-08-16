import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * R*C 격자에 첫번째 열은 근처 빵집이며 마지막 열은 원웅이의 빵집이다.
 * 파이프는 /, 오른쪽, \으로 연결할 수 있으며 건물이 있으면 연결할 수 없다.
 * 최대한 많은 가스를 훔치기위해 여러개의 파이프를 설치하고자 할 때, 
 * 연결 가능한 최대 파이프라인의 개수를 구하라. 
 * 2. strategy: 풀이전략
 * dfs로 탐색하며 가능한 경우를 모두 찾아준다.
 * 3. note: 주의할 사항(특이사항)
 * 같은 파이프라인이 마지막에 분리되는 경우를 고려하여 dfs 함수가 boolean을 반환하도록 설계
 */

public class Main {

	private static int R, C, answer;
	private static char[][] board;
	private static final int[] dxs = { -1, 0, 1 };
	private static final int[] dys = { 1, 1, 1 };
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			if (board[i][0] == '.') {
				dfs(i, 0);
			}
		}
		System.out.println(answer);
	}

	private static boolean dfs(int x, int y) {
		if (y == C - 1) {
			answer++;
			return true;
		}

		for (int d = 0; d < 3; d++) {
			int nx = x + dxs[d];
			int ny = y + dys[d];
			if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] == '.') {
				visited[nx][ny] = true;
				if (dfs(nx, ny))
					return true;
			}
		}
		return false;
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

}