import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 그래프가 주어질 때 해당 그래프의 최소 스패닝 트리를 구하라.
 * 2. strategy: 풀이전략
 * 크루스칼을 이용하여 최소 가중치를 가지며, 사이클을 이루지 않는 간선을 선택
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge other) {
			return Integer.compare(this.weight, other.weight);
		}
	}

	private static int V, E, parents[];
	private static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case < T + 1; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}

			make();
			long answer = 0, count = 0;
			Arrays.sort(edgeList);
			for (Edge e : edgeList) {
				if (union(e.from, e.to)) {
					answer += e.weight;
					if (++count == V - 1) {
						break;
					}
				}
			}
			sb.append("#").append(test_case).append(" ");
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB)
			return false;
		if (parentA < parentB) {
			parents[parentB] = parentA;
		} else {
			parents[parentA] = parentB;
		}
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parents[i] = i;
		}
	}

}