import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 정수 x를 입력받아 배열에 저장하고, 0이 입력되면 
 * 절댓값이 작은 값, 절댓값이 같다면 더 작은 수를 배열에서 제거후 출력
 * 2. strategy: 풀이전략
 * 우선순위 큐의 기준은 절댓값 -> 크기 순으로 저장한 후 차례대로 꺼낸다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int n1 = Math.abs(o1);
				int n2 = Math.abs(o2);
				if (n1 == n2) {
					return o1 - o2;
				}
				return n1 - n2;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(command);
			}
		}
		System.out.println(sb.toString());
	}

}