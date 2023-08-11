import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 9명의 난쟁이가 각각 양의 정수를 하나씩 가지고 있다.
 * 일곱 난쟁이 수의 합은 100이므로 9명 중 진짜 일곱 난쟁이를 찾아라.
 * 2. strategy: 풀이전략
 * 9명의 난쟁이 중 7명을 뽑는 모든 조합에 대해 합이 100인지 확인한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static final int N = 9;
	private static int[] person = new int[7], numbers;
	private static boolean getAnswer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		choose(0, 0);
	}

	private static void choose(int start, int index) {
		if (getAnswer)
			return;
		if (index == 7) {
			checkIsReal();
			return;
		}
		for (int i = start; i < N; i++) {
			person[index] = i;
			choose(i + 1, index + 1);
		}
	}

	private static void checkIsReal() {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += numbers[person[i]];
		}
		if (!getAnswer && sum == 100) {
			getAnswer = true;
			for (int p : person) {
				System.out.println(numbers[p]);
			}
		}
	}

}