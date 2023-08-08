import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 한빈이는 최대한 양이 많게 2봉지의 과자를 구매하고자 한다.
 * 과자 두 봉지가 M그램을 초과하면 한빈이가 들 수 없다.
 * 한빈이가 들 수 있는 과자 2봉지의 무게 내의 최대의 무게를 구하라.
 * 2. strategy: 풀이전략
 * 전체 과자 무게 중 2봉지를 뽑아 M그램보다 작은 최댓값을 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static final int r = 2;
	private static int N, M, snack[], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());
			snack = new int[N];
			result = -1;
			tokenizer = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(tokenizer.nextToken());
			}
			getMaxWeight(0, 0, 0);
			System.out.println("#" + test_case + " " + result);
		}

	}

	private static void getMaxWeight(int start, int index, int weight) {
		if (index == r) {
			result = Math.max(result, weight);
			return;
		}
		for (int i = start; i < N; i++) {
			if (weight + snack[i] <= M) {
				getMaxWeight(i + 1, index + 1, weight + snack[i]);
			}
		}
	}

}