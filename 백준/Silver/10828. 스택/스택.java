import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i=0;i<N;i++) {
			String[] command = br.readLine().split(" ");
			if (command[0].equals("push")) {
				stack.add(Integer.parseInt(command[1]));
			} else if (command[0].equals("pop")) {
				if (stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			} else if (command[0].equals("size")) {
				System.out.println(stack.size());
			} else if (command[0].equals("empty")) {
				if (stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if (command[0].equals("top")) {
				if (stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			}
		}
	}

}
