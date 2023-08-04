import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	4종류의 괄호문자 (), [], {}, <>로 이루어진 문자열의 괄호들이 모두 짝이 맞는지 판별하라
 * 2. strategy: 풀이전략
 * 	Stack에 (, [, {, <일 시에 담고 ), ], }, >일시에는 poll하며 판별
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	static final Map<Character, Character> isPair = new HashMap<Character, Character>() {
		{
			put(')', '(');
			put('}', '{');
			put('>', '<');
			put(']', '[');
		}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[] inputChar = br.readLine().toCharArray();
			sb.append("#").append(test_case).append(" ");
			if (isCorrect(inputChar)) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean isCorrect(char[] charArr) {
		Stack<Character> stack = new Stack<>();
		for (char c : charArr) {
			if (isPair.containsValue(c)) {
				stack.add(c);
			} else {
				if (stack.isEmpty()) return false;
				if (stack.pop()!=isPair.get(c)) return false;
			}
		}
		if (!stack.isEmpty()) return false;
		return true;
	}

}