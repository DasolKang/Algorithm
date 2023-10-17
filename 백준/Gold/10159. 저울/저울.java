import java.util.*;
import java.io.*;

public class Main {

	private static int N, M, bigger[][], smaller[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		connect(bigger);
		connect(smaller);
		check();
	}

	private static void check() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int result = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				if (bigger[i][j] == 0 && smaller[i][j] == 0) result++;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void connect(int[][] info) {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k) continue;
				for (int j = 1; j <= N; j++) {
					if (i == j || j == k) continue;
					if (info[i][k] == 1 && info[k][j] == 1)
						info[i][j] = 1;
				}
			}
		}
	}

	private static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		bigger = new int[N + 1][N + 1];
		smaller = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bigger[b][a] = 1;
			smaller[a][b] = 1;
		}
	}

}