import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 6개국으로 구성된 국가들이 동일 조에 구성된 국가들과 총 5번의 경기를 치른다.
 * 각 나라의 승, 무승부, 패의 수가 4개 주어질 때,
 * 각각의 결과가 가능한지 판별하라. (가능 :1, 불가능 :0)
 * 2. strategy: 풀이전략
 * 각 나라가 치르는 경기의 경우의 수를 모두 구한 후 6C2
 * 각 경기에 대해 한 나라고 이기고/비기고/지는 경우에 대해 탐색한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	static boolean answer;
	static List<int[]> match;
	static int info[][], game[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		info = new int[6][3];
		match = new ArrayList<>();
		game = new int[2];

		getAllMatch(0, 0); // 6C2 : 가능한 경기 수 구하기
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int allScore = 0;
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					info[j][k] = Integer.parseInt(st.nextToken());
					allScore += info[j][k];
				}
			}

			answer = false;
			if (allScore == 30) {
				isPossible(0); // 각 경기가 가능한지 구하기
			}
			if (answer)
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
	}

	private static void isPossible(int index) {
		// 종료 조건 : 15경기를 모두 치를수 있다면 종료
		if (index == 15) {
			answer = true;
			return;
		}

		int[] matchInfo = match.get(index);
		int country1 = matchInfo[0];
		int country2 = matchInfo[1];
		for (int i = 0; i < 3; i++) {
			// 0:country1이 이기는 경우 1: 비기는 경우 2: country1이 지는 경우
			if (info[country1][i] > 0 && info[country2][2 - i] > 0) {
				info[country1][i]--;
				info[country2][2 - i]--;
				isPossible(index + 1);
				info[country1][i]++;
				info[country2][2 - i]++;
			}
		}
	}

	// 6C2 : 6개국의 경기 경우의 수 구하기
	private static void getAllMatch(int start, int index) {
		if (index == 2) {
			match.add(new int[] { game[0], game[1] });
			return;
		}

		for (int i = start; i < 6; i++) {
			game[index] = i;
			getAllMatch(i + 1, index + 1);
		}
	}

}