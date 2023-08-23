import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 비상연락망과 연락 시작 당번이 주어질 때, 나중에 연락을 받는 사람 중 번호가 큰 사람을 구하라.
 * 2. strategy: 풀이전략
 * BFS를 이용하여 동시에 연락을 받는 사람들에 대해 visited에 저장하고
 * visited의 수가 큰 사람(나중에 연락받은 사람) 중 번호가 큰 사람을 구한다.
 * 3. note: 주의할 사항(특이사항)
 */


public class Solution {

	private static int N, cur;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			input(br);
			int answer = getLast(cur);
			sb.append("#").append(test_case).append(" ");
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getLast(int start) {
		int[] visited = new int[101]; // 연락 받은 시간
		int result = 0, last = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = 1;
		while (!queue.isEmpty()) {
			int curNode = queue.poll();
			for (int nextNode : graph[curNode]) {
				if (visited[nextNode] == 0) { // 연락 받은 적 없는 사람일 때
					visited[nextNode] = visited[curNode] + 1;
					queue.offer(nextNode);
					if (visited[nextNode] > last) { // 연락을 나중에 받은 상황일 때
						last = visited[nextNode];
						result = nextNode;
					} else if (visited[nextNode] == last && nextNode > result) { 
						// 같은 시간에 연락 받았으나, 현재의 번호가 클 때
						result = nextNode;
					}
				}
			}
		}
		return result;
	}

	private static void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		cur = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		graph = new ArrayList[101];
		for (int i = 0; i <= 100; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < N / 2; i++) {
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
		}
	}

}