import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N개의 탑에는 레이저 송신기와 수신기가 설치되어 있다.
 * 탑은 왼쪽으로 레이저를 발사한다. 자신보다 높이가 낮은 탑은 레이저를 수신할 수 없다.
 * 탑의 개수 N과 각 탑들의 높이가 주어질 때 각 탑의 레이저를 수신하는 탑을 구하라
 * 2. strategy: 풀이전략
 * Stack을 이용하여 
 * 1) Stack에 값이 존재하고 stack.top 높이가 본인보다 작다면 -> stack.pop();
 * 2) Stack에 값이 존재(tack.top의 높이가 본인보다 큼)하면 -> 해당 탑이 수신
 * 3) Stack에 값이 존재하지 않는다면 (본인보다 높이 높은 탑 X) -> 0
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int[] height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && height[stack.peek()]<height[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			} else {
				sb.append(stack.peek()+1).append(" ");
			}
			stack.add(i);
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

}