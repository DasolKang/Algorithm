import java.util.*;
import java.io.*;

public class Solution {

	private static int n, m, parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			make();
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < m; i++) {
				String[] command = br.readLine().split(" ");
				if (command[0].equals("0")) {
					union(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				} else if (command[0].equals("1")) {
					int parentA = find(Integer.parseInt(command[1]));
					int parentB = find(Integer.parseInt(command[2]));
					if (parentA==parentB) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB)
			return false;
		if (parentA < parentB)
			parents[parentB] = parentA;
		else
			parents[parentA] = parentB;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[n+1];
		for (int i = 0; i < n+1; i++)
			parents[i] = i;
	}

}