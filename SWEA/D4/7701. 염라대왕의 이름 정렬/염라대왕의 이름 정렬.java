import java.util.*;
import java.io.*;

public class Solution {
	static class Name implements Comparable<Name> {
		int len;
		String name;

		Name(String name, int len) {
			this.len = len;
			this.name = name;
		}

		public int compareTo(Name o) {
			if (this.len == o.len) {
				return this.name.compareTo(o.name);
			}
			return this.len - o.len;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			Set<String> set = new HashSet<>();
			PriorityQueue<Name> pQueue = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String temp = iter.next();
				pQueue.add(new Name(temp, temp.length()));
			}
			sb.append("#").append(test_case).append("\n");
			while (!pQueue.isEmpty()) {
				sb.append(pQueue.poll().name).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}