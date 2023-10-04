import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	N*M 크기의 이차원 격자에 섬으로 이루어진 나라가 있다
 * 	바다에 가로, 세로 방향의 다리를 설치하여 모든 섬을 연결하고자 한다.
 * 	나라의 정보가 주어질 때, 모든 섬을 연결하는 다리 길이의 최솟값을 구하라
 * 2. strategy: 풀이전략
 *  BFS를 이용하여 각 섬에 번호를 붙인다
 *  모든 섬에 대하여 연결 가능한 다리의 길이를 저장한다 -> distance
 *  Prim 알고리즘을 통해 모든 다리에 대한 MST를 구한다.
 * 3. note: 주의할 사항(특이사항)
 *  prim 알고리즘으로 섬을 연결한 후 모든 섬이 연결되었는지 확인해야한다.
 */

public class Main {

	private static int N, M, country;
	private static int[][] board;
	private static Bridge[][] distance;
	private static final int INF = Integer.MAX_VALUE;
	private static final int[] dxs = { -1, 0, 1, 0 };
	private static final int[] dys = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		getAllDistance();
		System.out.println(prim());
	}

	static class Bridge implements Comparable<Bridge> {
		int next;
		int dist;

		Bridge(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}

		public int compareTo(Bridge o) {
			return this.dist - o.dist;
		}

		@Override
		public String toString() {
			return "Bridge [next=" + next + ", dist=" + dist + "]";
		}

	}

	private static int prim() {
		boolean[] visited = new boolean[country + 1];
		PriorityQueue<Bridge> pQueue = new PriorityQueue<>();
		pQueue.offer(new Bridge(1, 0));
		int answer = 0;
		while (!pQueue.isEmpty()) {
			Bridge bridge = pQueue.poll();
			int next = bridge.next;
			int dist = bridge.dist;

			if (visited[next])
				continue;
			visited[next] = true;
			answer += dist;
			for (Bridge b : distance[next]) {
				if (!visited[b.next] && b.dist != INF) {
					pQueue.offer(b);
				}
			}
		}
		for (int i=1;i<=country;i++) {
			if (!visited[i]) return -1;
		}
		if (answer==0) return -1;
		return answer;
	}

	private static void getAllDistance() {
		distance = new Bridge[country + 1][country + 1];
		for (int i = 0; i <= country; i++) {
			for (int j = 0; j <= country; j++) {
				distance[i][j] = new Bridge(j, INF);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					boolean[] visited = new boolean[country+1];
					int nx = i, ny = j;
					int dist = 0;
					while (inRange(nx, ny)) {
						nx += dxs[d];
						ny += dys[d];
						if (!inRange(nx, ny) || board[nx][ny] == board[i][j])
							break;
						dist++;
						if (board[nx][ny] != 0 && !visited[board[nx][ny]]) {
							int originDist = distance[board[i][j]][board[nx][ny]].dist;
							int newDist = Math.min(originDist, dist - 1);
							visited[board[nx][ny]]=true;
							if (newDist>=2)
								distance[board[i][j]][board[nx][ny]] = new Bridge(board[nx][ny], newDist);
							break;
						}
					}
				}
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		country = 1;
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					divideCountry(i, j, country++, visited);
				}
			}
		}
		country--;
	}

	private static void divideCountry(int x, int y, int country, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			board[temp[0]][temp[1]] = country;
			visited[temp[0]][temp[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nx = temp[0] + dxs[d], ny = temp[1] + dys[d];
				if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] == 1) {
					board[nx][ny] = country;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
	}

}