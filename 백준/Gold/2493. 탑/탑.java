import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		int index = n-1;

		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.add(index--);
		while (index > -1) {
			while (!stack.isEmpty() && heights[index] > heights[stack.peek()]) {
				answer[stack.pop()] = index+1;
			}
			stack.add(index--);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}