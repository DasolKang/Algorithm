import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N개의 식재료로 요리를 할 때 요리의 맛은 각 식재료의 시너지의 합이다.
 * N개의 식재료를 둘로 나누어 최대한 비슷한 맛의 요리를 하고자한다
 * 맛의 최소 차이를 구하라
 * 2. strategy: 풀이전략
 * N개의 재료 중 N/2개의 재료를 선택하는 조합을 구하고
 * 맛의 차이를 계산하며 최소값을 구한다.
 * 3. note: 주의할 사항(특이사항)
 * N이 6이상일 때의 시너지는 [a][b]+[b][a]+[a][c]+[c][a]+[b][c]+[c][b]
 */

public class Solution {

	private static int N, taste[][], minDiff;
	private static int[] ingredients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			taste = new int[N + 1][N + 1];
			ingredients = new int[(int) N / 2];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					taste[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			minDiff = Integer.MAX_VALUE;
			chooseIngredient(1, 0, new boolean[N + 1]);
			sb.append("#").append(test_case).append(" ");
			sb.append(minDiff).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void getTasteDiff(boolean[] visited) {
		int[] ingredient2 = getAnotherIngredient(visited);
		int taste1 = getTaste(ingredients);
		int taste2 = getTaste(ingredient2);
		minDiff = Math.min(minDiff, Math.abs(taste1 - taste2));
	}

	private static int getTaste(int[] ingredient) {
		int totalTaste = 0;
		for (int i = 0; i < (int) N / 2; i++) {
			for (int j = i + 1; j < (int) N / 2; j++) {
				totalTaste += (taste[ingredient[i]][ingredient[j]] + taste[ingredient[j]][ingredient[i]]);
			}
		}
		return totalTaste;
	}

	private static int[] getAnotherIngredient(boolean[] ingredient) {
		int index = 0;
		int[] result = new int[(int) N / 2];
		for (int i = 1; i <= N; i++) {
			if (ingredient[i])
				continue;
			result[index++] = i;
		}
		return result;
	}

	private static void chooseIngredient(int start, int index, boolean[] visited) {
		if (index == (int) N / 2) {
			getTasteDiff(visited);
			return;
		}

		for (int i = start; i <= N; i++) {
			ingredients[index] = i;
			visited[i] = true;
			chooseIngredient(i + 1, index + 1, visited);
			visited[i] = false;
		}
	}

}