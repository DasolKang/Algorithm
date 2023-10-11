import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	마을에 사는 N명의 사람 중 몇 개의 무리가 존재하는지 계산하라
 *  두사람이 서로 아는 관계이거나 몇 사람을 거쳐 알 수 있는 관계라면 하나의 무리이다.
 * 2. strategy: 풀이전략
 * 	유니온 파인드를 이용하여 서로 같은 무리인지 확인
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static int N, M, parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			int answer = getTeamNum();
			sb.append("#").append(test_case).append(" ");
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getTeamNum() {
		int result = 0;
		boolean[] check = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			check[find(i)]=true;
		}
		
		for (int i=1;i<=N;i++) {
			if (check[i]) result++;
		}
		return result;
	}

	private static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	private static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		if (parentX == parentY)
			return false;
		if (parentX < parentY) {
			parents[parentY] = parentX;
		} else {
			parents[parentX] = parentY;
		}
		return true;
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

}