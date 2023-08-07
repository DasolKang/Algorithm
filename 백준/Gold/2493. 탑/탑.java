import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();		
		int[] heights = new int[n];
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
			
			// 왼쪽에 있는 탑 중 더 낮은 탑은 pop
			while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
				stack.pop();
			}
			
			if (!stack.isEmpty()) {	// 왼쪽에 현재 높이보다 더 높은 탑이 있으면
				answer[i] = stack.peek()+1;	// 그 탑의 번호를 배열에 넣어줌
			}
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}
}