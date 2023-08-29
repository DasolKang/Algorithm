import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * a층의 b호에 살려면 a-1층의 1호부터 b호까지의 사람 수의 합만큼 사람을 데려와야 한다.
 * 양의 정수 k와 n이 주어질 때, k층 n호에 몇 명이 살고 있는지 구하라.
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k + 1][n + 1];
			for (int i = 0; i < k + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (i == 0)
						apart[i][j] = j; // 0층의 i호에는 i명이 거주
					else {
						int p = 0;
						for (int a = 1; a <= j; a++) {
							p += apart[i - 1][a]; // 아랫층의 1~j호까지의 사람수
						}
						apart[i][j] = p;
					}
				}
			}
			System.out.println(apart[k][n]);
		}
	}

}