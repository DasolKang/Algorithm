import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			char[] inputArr = br.readLine().toCharArray();
			for (char c : inputArr) {
				if (stack.isEmpty() || stack.peek() != c) {
					stack.add(c);
				} else if (stack.peek() == c) {
					stack.pop();
				}
			}
			if (stack.isEmpty())
				answer++;
		}
		System.out.println(answer);
	}
}