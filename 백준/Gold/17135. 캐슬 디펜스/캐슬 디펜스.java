import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N*M 크기의 격자 내에서 캐슬 디펜스 게임을 진행한다.
 * 궁수는 성이 있는 칸에 위치하며 각 턴마다 거리가 적 하나를 공격한다.
 * 궁수는 거리가 D 이하인 적 중에서 가장 가까우면서 가장 왼쪽에 있는 적을 공격한다.
 * 적은 공격 당하거나 성이 있는 칸으로 이동한 경우 게임에서 제외된다.
 * 격자판의 상태가 주어질 때 궁수 3명을 적절하게 배치하여 제거할 수 있는 최대 적의 수를 구하라.
 * 2. strategy: 풀이전략
 * 궁수 3명을 배치할 위치를 조합으로 구한 후에 게임을 진행하며 최대 적의 수를 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int N, M, D, board[][];
	private static int answer, bow[], gameBoard[][];
	private static List<int[]> enemy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		bow = new int[3];
		setBow(0, 0);
		System.out.println(answer);
	}

	private static void setBow(int start, int index) {
		if (index == 3) {
			answer = Math.max(answer, game());
			return;
		}

		for (int i = start; i < M; i++) {
			bow[index] = i;
			setBow(i + 1, index + 1);
		}
	}

	private static int game() {
		// 제거할 수 있는 적의 수 구하기
		gameBoard = copy();
		int kill = 0;
		while (getEnemy() > 0) { // 적이 0명이면 게임 종료
			// 각 궁수가 공격할 수 있는 적 구하기
			boolean[][] visited = new boolean[N][M]; // 같은 적을 공격할 경우
			int[][] attack = getAttack();
			for (int[] a : attack) {
				if (a[0] == -1 && a[1] == -1) // 공격할 수 있는 적이 없을 때
					continue;
				if (visited[a[0]][a[1]]) // 이미 제거한 적일 때
					continue;
				gameBoard[a[0]][a[1]] = 0;
				visited[a[0]][a[1]] = true;
				kill++;
			}
			// 궁수가 공격을 종료하면 적들이 한 칸 전진
			enemyMove();
		}
		return kill;
	}

	private static int[][] getAttack() {
		int[][] result = new int[3][2];
		for (int i = 0; i < 3; i++) {
			Arrays.fill(result[i], -1);
		}
		for (int i = 0; i < 3; i++) {
			int minDist = Integer.MAX_VALUE;
			for (int j = 0; j < enemy.size(); j++) {
				int dist = getDistance(enemy.get(j)[0], enemy.get(j)[1], N, bow[i]);
				if (dist <= D && dist <= minDist) {
					if (dist == minDist && result[i][1] < enemy.get(j)[1]) {
						// 같은 거리 일 때는 왼쪽에 있는 적을 공격
						continue;
					}
					minDist = dist;
					result[i][0] = enemy.get(j)[0];
					result[i][1] = enemy.get(j)[1];
				}
			}
		}
		return result;
	}

	private static void enemyMove() {
		for (int i = 0; i < M; i++) {
			// 성이 있는 칸으로 이동한 경우 게임에서 제외
			gameBoard[N - 1][i] = 0;
		}
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (gameBoard[i][j] == 1) {
					gameBoard[i][j] = 0;
					gameBoard[i + 1][j] = 1;
				}
			}
		}
	}

	private static int getEnemy() {
		// 적의 수와 위치를 구하는 메서드
		int result = 0;
		enemy = new ArrayList<>();
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (gameBoard[i][j] == 1) {
					enemy.add(new int[] { i, j });
					result++;
				}
			}
		}
		return result;
	}

	private static int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	private static int[][] copy() {
		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(board[i], 0, result[i], 0, M);
		}
		return result;
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}