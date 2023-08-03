import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	  N개의 재료는 각각 쓴맛과 신맛의 정도를 가지고 있다.
 * 	  신맛은 사용한 재료의 곱이며 쓴맛은 사용한 재료의 합이다.
 * 	  재료를 적절하게 사용하여 신맛과 쓴맛의 차이가 가장 적은 요리를 만들어라.
 * 2. strategy: 풀이전략
 * 	  재료를 뽑는 모든 경우의 수의 신맛과 쓴맛의 차이를 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	static int[] sourTaste;
	static int[] badTaste;
	static int N;
	static int minDiff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sourTaste = new int[N];
		badTaste = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			sourTaste[i] = Integer.parseInt(tokenizer.nextToken());
			badTaste[i] = Integer.parseInt(tokenizer.nextToken());
		}
		minDiff = 1000000000;
		getBestCook(0, new boolean[N], 1, 0, 0);
		System.out.println(minDiff);

	}

	private static void getBestCook(int index, boolean[] visited, int sour, int bad, int choose) {
		if (index == N) {
			if (choose!=0) {
				int diff = Math.abs(sour - bad);
				if (diff < minDiff) {
					minDiff = diff;
				}
			}
			return;
		}

		visited[index] = true;
		getBestCook(index + 1, visited, sour * sourTaste[index], bad + badTaste[index], choose+1);
		visited[index] = false;
		getBestCook(index + 1, visited, sour, bad, choose);
	}
}