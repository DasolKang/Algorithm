import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * N개의 섬들을 연결하는 교통시스템을 설계하고자 한다.
 * 해저터널을 건설하기 위해서는 E*L^2의 비용이 발생한다.
 * 환경 부담금을 최소로 지불하여 모든 섬을 연결할 수 있는 교통시스템을 설계하라.
 * 2. strategy: 풀이전략
 * 각 섬을 정점, 환경부담금을 간선의 가중치로 보고 MST를 만든다. 
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static int N;
	private static double tax, answer;
	private static int[] islandX, islandY;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input(br);
			prim();
			sb.append("#").append(test_case).append(" ");
			sb.append(Math.round(answer)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void prim() {
		visited = new boolean[N];
		double[] minCost = new double[N];
		Arrays.fill(minCost, Double.MAX_VALUE);
		minCost[0] = 0;
		answer=0;
		for (int i = 0; i < N; i++) {
			int minIndex = -1;
			Double minValue = Double.MAX_VALUE;
			for (int connect = 0; connect < N; connect++) {
				if (!visited[connect] && minValue > minCost[connect]) {
					minIndex = connect;
					minValue = minCost[connect];
				}
			}
			visited[minIndex] = true;
			answer += minValue;

			for (int connect = 0; connect < N; connect++) {
				if (visited[connect])
					continue;
				double cost = getCost(getDistance(minIndex, connect));
				if (cost < minCost[connect]) {
					minCost[connect] = cost;
				}
			}
		}

	}

	private static double getCost(double distance) {
		return tax * distance * distance;
	}

	private static double getDistance(int index1, int index2) {
		return Math
				.sqrt(Math.pow(islandY[index1] - islandY[index2], 2) + Math.pow(islandX[index1] - islandX[index2], 2));
	}

	private static void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		islandX = new int[N + 1];
		islandY = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			islandX[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			islandY[j] = Integer.parseInt(st.nextToken());
		}
		tax = Double.parseDouble(br.readLine());
	}

}