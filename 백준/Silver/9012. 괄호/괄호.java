import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0;i<T;i++) {
			Stack<String> stack = new Stack<>();
			String[] input_ = br.readLine().split("");
			boolean isPoss = true;
			for (String ps : input_) {
				if (ps.equals("(")) stack.add("(");
				else {
					if (!stack.isEmpty() && stack.peek().equals("(")) stack.pop();
					else {
						isPoss=false;
						break;
					}
				}
			}
			if (stack.isEmpty() && isPoss) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
