import java.util.*;
import java.io.*;
/*
 * 1. summary: 문제 해석
 * 전차 하나가 등장하는 게임 배틀필드를 개발하고자 한다.
 * 전차는 상하좌우 방향을 바라보고 이동할 수 있으며 포탄을 발사할 수 있다.
 * 포탄은 바라보는 방향으로 발사되며 벽돌벽을 만나면 부수고, 강철벽을 만나면 아무일도 일어나지 않는다.
 * 처음 게임의 구성과 사용자의 동작이 주어질 때, 동작을 모두 완료한 후의 게임 화면을 출력하라 
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static final int[] dxs = { -1, 0, 1, 0 };
	private static final int[] dys = { 0, 1, 0, -1 };
	private static Map<Character, Character> alphaToDir = new HashMap<Character, Character>() {
		{
			put('U', '^');
			put('R', '>');
			put('D', 'v');
			put('L', '<');
		}
	};
	private static Map<Character, Integer> direction = new HashMap<Character, Integer>() {
		{
			put('^', 0);
			put('>', 1);
			put('v', 2);
			put('<', 3);
		}
	};
	private static int H, W, N, x, y;
	private static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			board = new char[H][W];
			for (int i = 0; i < H; i++) {
				board[i] = br.readLine().toCharArray();
			}
			getStartLocation();
			br.readLine();
			char[] inputCommand = br.readLine().toCharArray();
			for (char command : inputCommand) {
				if (command == 'S') {
					shoot();
				} else {
					move(command);
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void shoot() {
		int dir = direction.get(board[x][y]);
		int nx = x, ny = y;
		while (true) {
			nx += dxs[dir];
			ny += dys[dir];
			if (!inRange(nx, ny))
				return;
			if (board[nx][ny] == '#') {
				return;
			}
			if (board[nx][ny] == '*') {
				board[nx][ny] = '.';
				return ;
			}
		}
	}

	private static void move(char dir) {
		dir = alphaToDir.get(dir);
		int next = direction.get(dir);
		int nx = x + dxs[next], ny = y + dys[next];
		if (inRange(nx, ny) && board[nx][ny] == '.') {
			board[x][y] = '.';
			board[nx][ny] = dir;
			x = nx;
			y = ny;
		} else {
			board[x][y] = dir;
		}
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}

	private static void getStartLocation() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (board[i][j] == '<' || board[i][j] == '^' || board[i][j] == '>' || board[i][j] == 'v') {
					x = i;
					y = j;
				}
			}
		}
	}

}