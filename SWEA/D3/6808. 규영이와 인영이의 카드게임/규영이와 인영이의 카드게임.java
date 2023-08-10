import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 1~18의 수가 적인 18장의 카드로 게임을 하려고 한다.
 * 규영이가 받은 9장의 숫자카드와 순서가 주어질 때,
 * 인영이가 낼 수 있는 9!의 경우의 수에 대해 규영이가 이기고 지는 횟수를 구하라
 * 2. strategy: 풀이전략
 * 규영이가 가지고 있는 카드를 제외한 9개의 숫자로
 * 만들 수 있는 순열을 만들어 이긴 횟수를 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	static final int N = 9;
	static int[] kyuyoung = new int[N], inyoung = new int[N];
	static int[] possCase = new int[N];
	static int kyuWin, inWin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			boolean[] kyuCard = new boolean[2 * N + 1];
			for (int i = 0; i < N; i++) {
				int card = Integer.parseInt(tokenizer.nextToken());
				kyuyoung[i] = card;
				kyuCard[card] = true;
			}
			getInyoungCard(kyuCard);
			kyuWin = 0;
			inWin = 0;
			game(0, new boolean[N]);
			sb.append("#").append(test_case).append(" ");
			sb.append(kyuWin).append(" ").append(inWin).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void game(int index, boolean[] visited) {
		if (index == N) {
			getWinNum();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				possCase[index] = inyoung[i];
				visited[i] = true;
				game(index + 1, visited);
				visited[i] = false;
			}
		}
	}

	private static void getWinNum() {
		int kyu = 0, in = 0;
		for (int i = 0; i < N; i++) {
			if (kyuyoung[i] == possCase[i])
				continue;

			if (kyuyoung[i] > possCase[i])
				kyu += (kyuyoung[i] + possCase[i]);
			else
				in += (kyuyoung[i] + possCase[i]);
		}
		if (kyu > in)
			kyuWin++;
		else
			inWin++;
	}

	private static void getInyoungCard(boolean[] kyuCard) {
		int index = 0;
		for (int i = 1; i <= 18; i++) {
			if (kyuCard[i])
				continue;
			inyoung[index++] = i;
		}
	}

}