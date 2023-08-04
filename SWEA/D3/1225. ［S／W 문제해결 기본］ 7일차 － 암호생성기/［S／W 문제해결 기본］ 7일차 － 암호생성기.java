import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 *  8개의 숫자에 대해 조건에 맞게 사이클을 돌려 암호를 생성한다.
 *  1. 첫번째 숫자는 1, 두번째 숫자는 2, 5까지의 숫자를 감소한 후 맨 뒤로 보낸다.
 *  2. 암호의 각 자릿수는 모두 한 자리수이다.
 *  3. 사이클은 한 숫자가 0이하일 때 종료된다.
 * 2. strategy: 풀이전략
 *  8개의 숫자를 큐에 두고 앞에서부터 꺼내며 값을 감소시키고 다시 큐에 추가한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(tokenizer.nextToken()));
			}
			Queue<Integer> password = getPassword(queue);
			sb.append("#").append(test_case).append(" ");
			while (!queue.isEmpty())
				sb.append(queue.poll()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static Queue<Integer> getPassword(Queue<Integer> queue) {
		int reduce = 1;
		while (true) {
			int temp = queue.poll() - reduce;
			if (temp <= 0) {
				queue.add(0);
				break;
			}
			queue.add(temp);
			reduce = (reduce + 1 < 6) ? reduce + 1 : 1;
		}
		return queue;
	}

}