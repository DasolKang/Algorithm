import java.util.*;
import java.io.*;

public class Main {

	private static int N, M, T;
	private static ArrayList<Integer>[] board;
	private static final int[] dxs = { -1, 0, 1, 0 };
	private static final int[] dys = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			turn(x, d, k);
			check();
		}
		System.out.println(getSum());
	}

	private static void turn(int index, int dir, int k) {
		for (int i = index; i <= N; i += index) {
			ArrayDeque temp = new ArrayDeque<>(board[i]);
			if (dir == 0) { // 시계방향
				for (int j = 0; j < k; j++) {
					temp.offerFirst(temp.pollLast());
				}
			} else { // 반시계방향
				for (int j = 0; j < k; j++) {
					temp.offerLast(temp.pollFirst());
				}
			}
			board[i] = new ArrayList<>(temp);
		}
	}

	private static void check() {
		// 인접한 수가 같은 것 찾기 -> BFS
		boolean flag = true;
		int total = 0, num = 0;
		boolean[][] visited = new boolean[N + 1][M];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || board[i].get(j).equals(0))
					continue;
				total += board[i].get(j);
				num++;
				Queue<int[]> queue = new ArrayDeque<>();
				ArrayList<int[]> same = new ArrayList<>();
				visited[i][j] = true;
				int[] start = new int[] { i, j };
				queue.add(start);
				same.add(start);
				while (!queue.isEmpty()) {
					int[] cur = queue.poll();
					for (int d = 0; d < 4; d++) {
						// N+1 -> 1 1-1 -> N
						int nx = cur[0] + dxs[d];
						if (nx == 0 || nx == N + 1) continue;
						int ny = (cur[1] + dys[d] + M) % M;
						if (!visited[nx][ny] && board[nx].get(ny).equals(board[cur[0]].get(cur[1]))) {
							int[] next = new int[] { nx, ny };
							visited[nx][ny] = true;
							queue.add(next);
							same.add(next);
						}
					}
				}
				if (same.size() > 1) {
					flag = false;
					for (int[] delete : same) {
						total -= board[delete[0]].get(delete[1]);
						num--;
						board[delete[0]].set(delete[1], 0);
					}
				}
			}
		}
		if (flag)
			average(total, num);
	}

	private static void average(int total, int num) {
		double aver = (double) total / num;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				int value = board[i].get(j);
				if (value == 0) continue;
				if (value > aver) {
					board[i].set(j, value - 1);
				} else if (value < aver) {
					board[i].set(j, value + 1);
				}
			}
		}
	}

	private static int getSum() {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				result += board[i].get(j);
			}
		}
		return result;
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			board[i] = new ArrayList<Integer>();
			if (i == 0) continue;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}
	
	private static void print() {
		for (int i=1;i<=N;i++) {
			System.out.println(board[i]);
		}
		System.out.println();
	}

}

/**
6 5 2
1 2 3 2 1
4 5 4 2 3
6 8 2 1 2
7 6 2 8 8
3 2 4 2 8
5 8 2 1 1
2 0 2
2 1 4
>> 55

6 6 2
1 1 3 1 1 1
2 2 4 2 2 2
4 2 4 2 4 2
3 1 3 1 3 1
4 3 4 3 4 5
2 3 2 3 3 2
2 1 2
3 0 4
>> 42
**/