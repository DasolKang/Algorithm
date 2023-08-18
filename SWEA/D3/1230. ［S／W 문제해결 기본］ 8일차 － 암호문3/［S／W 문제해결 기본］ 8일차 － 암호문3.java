import java.util.*;
import java.util.LinkedList;
import java.io.*;

public class Solution {

	private static List<Integer> password;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			password = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String command = st.nextToken();
				if (command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int[] s = new int[y];
					for (int i = 0; i < y; i++) {
						s[i] = Integer.parseInt(st.nextToken());
					}
					insert(x, y, s);
				} else if (command.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					delete(x, y);
				} else if (command.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					int[] s = new int[y];
					for (int i = 0; i < y; i++) {
						s[i] = Integer.parseInt(st.nextToken());
					}
					add(y, s);
				}
			}

			ListIterator<Integer> iter = password.listIterator();
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void insert(int x, int y, int[] s) {
		for (int i = y - 1; i >= 0; i--) {
			password.add(x, s[i]);
		}
	}

	private static void delete(int x, int y) {
		for (int i = 0; i < y; i++) {
			password.remove(x + 1);
		}
	}

	private static void add(int y, int[] s) {
		for (int i : s) {
			password.add(i);
		}
	}
}