import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N*N 크기의 각 방에 숫자가 적혀있을 때, 
 * 인접한 방이면서, 현재 방에 적힌 수보다 1 큰수인 방에만 이동할 수 있다.
 * 가장 많은 개수의 방을 이동하기 위해 처음 들어가야하는 방을 구하라
 * 2. strategy: 풀이전략
 * 각 방에서 대하여 BFS로 탐색하며 최대 이동 수를 가지는 방을 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static int N, board[][], visited[][];
	private static int max, answer;
	private static final int[] dxs = { -1, 0, 1, 0 };
	private static final int[] dys = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer tokenizer = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			max = 0;
			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						bfs(i, j);
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = 1;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cx = temp[0];
			int cy = temp[1];
			for (int d = 0; d < 4; d++) {
				int nx = cx + dxs[d];
				int ny = cy + dys[d];
				if (inRange(nx, ny) && board[nx][ny] == board[cx][cy] + 1 && visited[nx][ny] < visited[cx][cy] + 1) {
					visited[nx][ny] = visited[cx][cy] + 1;
					if (visited[nx][ny] > max || (visited[nx][ny] == max && answer > board[x][y])) {
						max = visited[nx][ny];
						answer = board[x][y];
					}
					queue.offer(new int[] { nx, ny });
					break;
				}
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}