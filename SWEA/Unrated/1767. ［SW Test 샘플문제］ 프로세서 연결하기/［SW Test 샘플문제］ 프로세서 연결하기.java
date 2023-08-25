import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N*N 크기 멕시노스의 가장 자리에 전원이 흐르고 있다.
 * 셀에 존재하는 최대한 많은 Core를 연결하는 전선 (Core 수 같을 때는 전선의 최소 길이)를 구하라
 * 2. strategy: 풀이전략
 * 각 Core의 방향을 선택하여 재귀로 모든 경우의 수를 확인한다.
 * 3. note: 주의할 사항(특이사항)
 * 만약 남은 Core를 모두 연결하더라도 정답의 최대 Core 수보다 작다면 더 이상 탐색할 필요 없다.
 */


public class Solution {

	static int N, board[][], answer, coreNum;
	static List<int[]> core;
	static int maxNum;
	static boolean[][] visited;
	static int[] dxs = { -1, 0, 1, 0 };
	static int[] dys = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input(br);
			answer = Integer.MAX_VALUE;
			maxNum = 0;
			connect(0, 0, 0, visited);

			sb.append("#").append(test_case).append(" ");
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void connect(int index, int length, int connectCore, boolean[][] visit) {
		if (index == coreNum) {
			if (maxNum < connectCore) { // 현재까지 연결한 최대 코어보다 많이 연결했을 때
				maxNum = connectCore;
				answer = length;
			} else if (maxNum == connectCore) { // 같은 수의 코어를 연결했을 때
				answer = Math.min(answer, length);
			}
			return;
		}
		// 남은 코어를 모두 연결해도 최대 코어 수보다 작다면 답일 가능성 없다.
		if (connectCore + (coreNum - index) < maxNum)
			return;
		
		for (int d = 0; d < 4; d++) { // 4방향에 대하여 연결 가능한지 확인
			boolean[][] temp = deepCopy(visit);
			int len = isPoss(index, d, temp);
			if (len != -1) {
				// 연결 가능할 경우 연결한 전선 수 더하여 탐색
				connect(index + 1, length + len, connectCore + 1, temp);
			} else {
				// 연결 불가능할 경우 해당 코어 넘어감
				connect(index + 1, length, connectCore, deepCopy(visit));
			}
		}
	}

	private static int isPoss(int index, int dirIndex, boolean[][] visit) {
		int result = 0;
		int nx = core.get(index)[0], ny = core.get(index)[1];
		while (true) {
			nx += dxs[dirIndex];
			ny += dys[dirIndex];
			if (!inRange(nx, ny)) // 범위 벗어났다면 (가장자리 연결) 전선의 길이 반환
				return result;
			if (visit[nx][ny] || board[nx][ny] == 1) // 이미 연결된 전선이나 코어 만나면 연결 불가
				return -1;
			result++;
			visit[nx][ny] = true;
		}
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static boolean[][] deepCopy(boolean[][] origin) {
		boolean[][] result = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			result[i] = origin[i].clone();
		}
		return result;
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		core = new ArrayList<>();
		coreNum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
					core.add(new int[] { i, j });
					visited[i][j] = true;
					coreNum++;
				}
			}
		}
	}

}