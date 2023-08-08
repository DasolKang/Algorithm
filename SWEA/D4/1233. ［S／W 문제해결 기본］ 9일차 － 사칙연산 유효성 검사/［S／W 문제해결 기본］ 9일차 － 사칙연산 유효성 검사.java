import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 정점의 연산자를 왼쪽 서브 트리의 결과와 오른쪽 서브 트리의 결과에 적용한다.
 * 연산자와 양의 정수로만 구성된 임의의 이진트리가 주어질 때 식의 유효성을 검사하라.
 * 2. strategy: 풀이전략
 * 식이 유효하기 위해서는
 * 1. 자식이 있는 노드는 연산자여야 한다.
 * 2. 리프노드에 연산자가 존재해서는 안된다.
 * 3. 자식은 항상 2개의 노드여야 한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	static final Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			boolean isPoss = true;
			for (int i = 0; i < N; i++) {
				String[] nodeInfo = br.readLine().split(" ");
				int size = nodeInfo.length;
				if (size == 4) {
					// 자식 2개인 노드가 숫자라면 유효하지 않음
					if (!op.contains(nodeInfo[1])) {
						isPoss = false;
					}
				} else if (size == 2) {
					// 리프노드가 연산자라면 유효하지 않음
					if (op.contains(nodeInfo[1])) {
						isPoss = false;
					}
				} else {
					// 자식이 2개 아니거나 리프노드 아니면
					isPoss = false;
				}
			}
			System.out.println("#" + test_case + " " + (isPoss ? 1 : 0));
		}
	}
}