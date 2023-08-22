import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 암호는 최소 한 개의 모음과 두 개의 자음으로 길이가 L이다.
 * 알파벳들이 입력으로 주어질 때 만들 수 있는 가능성 있는 암호들을 모두 구하라
 * 2. strategy: 풀이전략
 * 입력된 알파벳을 정렬한 후 순서대로 L개를 뽑아 가능성 있는지 판별한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {
	private static int L, C;
	private static String[] alphabet, password;
	private static Set<String> aeiou = new HashSet<String>() {
		{
			add("a");
			add("e");
			add("i");
			add("o");
			add("u");
		}
	};
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = br.readLine().split(" ");
		Arrays.sort(alphabet);
		password = new String[L];
		getPassword(0, 0);
		System.out.println(sb);
	}

	private static void getPassword(int index, int start) {
		if (index == L) {
			if (isPoss()) {
				printPassword();
			}
			return;
		}
		for (int i = start; i < C; i++) {
			password[index] = alphabet[i];
			getPassword(index + 1, i + 1);
		}
	}

	private static boolean isPoss() {
		int j = 0;
		boolean flag = false;
		// 모음이 하나 이상 존재
		for (String p : password) {
			if (aeiou.contains(p)) {
				flag = true;
			} else
				j++;
		}
		// 자음이 2개 이상 존재
		if (flag && j >= 2)
			return true;
		return false;
	}
	
	private static void printPassword() {
		for (String p : password) {
			sb.append(p);
		}
		sb.append("\n");
	}
}