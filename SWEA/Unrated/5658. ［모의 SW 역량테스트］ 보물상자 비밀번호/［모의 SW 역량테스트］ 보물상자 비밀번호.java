import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	각 변에 16진수 숫자가 적힌 보물상자가 있다.
 * 	보물상자를 시계방향으로 돌려 만들 수 있는 수 중 K번째 수를 10진수로 변환하라
 * 	서로 다른 회전 횟수에서 동일한 수가 중복으로 생성될 때 중복으로 세지 않는다.
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 * 	수는 중복되지 않게 내림차순으로 정렬한다.
 */

public class Solution {

	private static Set<Integer> numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = new HashSet<>();
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String inputStr = br.readLine();
			for (int i = 0; i <= N / 4; i++) {
				getNumber(inputStr, N / 4);
				char temp = inputStr.charAt(inputStr.length() - 1);
				inputStr = inputStr.substring(0, inputStr.length() - 1);
				inputStr = temp + inputStr;
			}
			Integer[] number = numbers.toArray(new Integer[numbers.size()]);
			Arrays.sort(number);
			sb.append("#").append(test_case).append(" ");
			sb.append(number[number.length - K]).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void getNumber(String str, int size) {
		for (int i = 0; i < str.length(); i += size) {
			numbers.add(Integer.parseInt(str.substring(i, i + size), 16));
		}
	}

}