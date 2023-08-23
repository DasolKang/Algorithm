import java.util.*;
import java.io.*;

public class Main {

	private static int N, numbers[], opNum[];
	private static char[] op;
	private static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		op = new char[N-1];
		max = -Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		solution(0, opNum[0], opNum[1], opNum[2], opNum[3]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void solution(int index, int add, int minus, int multi, int divide) {
		if (index == N-1) {
			int result = calculate();
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		if (add > 0) {
			op[index] = '+';
			solution(index + 1, add - 1, minus, multi, divide);
		}
		if (minus > 0) {
			op[index] = '-';
			solution(index + 1, add, minus - 1, multi, divide);
		}
		if (multi > 0) {
			op[index] = '*';
			solution(index + 1, add, minus, multi - 1, divide);
		}
		if (divide > 0) {
			op[index] = '/';
			solution(index + 1, add, minus, multi, divide - 1);
		}
	}

	private static int calculate() {
		int result = numbers[0];
		for (int i = 1; i < N; i++) {
			char oper = op[i - 1];
			if (oper == '+') {
				result += numbers[i];
			} else if (oper == '-') {
				result -= numbers[i];
			} else if (oper == '*') {
				result *= numbers[i];
			} else if (oper == '/') {
				result /= numbers[i];
			}
		}
		return result;
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		opNum = new int[4];
		for (int i = 0; i < 4; i++)
			opNum[i] = Integer.parseInt(st.nextToken());
	}

}