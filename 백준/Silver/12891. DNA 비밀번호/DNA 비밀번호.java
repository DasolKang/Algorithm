import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	  입력받은 문자열의 부분문자열을 비밀번호로 사용하기위해
 * 	  A, C, G, T의 문자가 일정 개수 이상 등장해야한다.
 * 	  사용 가능한 비밀번호의 수를 구하라.
 * 2. strategy: 풀이전략
 *	  문자열의 가능한 부분 문자열을 모두 구한 후 조건을 만족하는지 확인
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	static int S, P, answer;
	static char[] password;
	static final Map<Character, Integer> charIndexInfo = new HashMap<Character, Integer>() {
		{
			put('A', 0);
			put('C', 1);
			put('G', 2);
			put('T', 3);
		}
	};
	static int[] required = new int[4];
	static int[] checkArr = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		S = Integer.parseInt(tokenizer.nextToken());
		P = Integer.parseInt(tokenizer.nextToken());

		password = br.readLine().toCharArray();

		tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			required[i] = Integer.parseInt(tokenizer.nextToken());
		}
		getPassword();
		System.out.println(answer);
	}

	private static void getPassword() {
		int startIndex = 0, endIndex = P-1;
		for (int i = startIndex; i <= endIndex; i++) {
			checkArr[charIndexInfo.get(password[i])]++;
		}
		while (true) {
			if (checkPassword()) answer++;
			checkArr[charIndexInfo.get(password[startIndex++])]--;
			if (endIndex+1==S) break;
			checkArr[charIndexInfo.get(password[++endIndex])]++;
		}
	}

	private static boolean checkPassword() {
		for (int i = 0; i < 4; i++) {
			if (required[i] > checkArr[i])
				return false;
		}
		return true;
	}
}