import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	사람 네트워크에서 가장 영향력 있는 사람을 알기위해
 * 	한 사용자가 다른 사람에게 얼마나 가까운가를 측정하고자 한다.
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int MAX_VALUE = 100000;
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] network = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					network[i][j] = Integer.parseInt(st.nextToken());
					if (network[i][j] == 0)
						network[i][j] = MAX_VALUE;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j == k)
							continue;
						if (network[i][j] > network[i][k] + network[k][j]) {
							network[i][j] = network[i][k] + network[k][j];
						}
					}
				}
			}
			
			int minValue = MAX_VALUE;
			int[] cc = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i==j) continue;
					cc[i] += network[i][j];
				}
				if (cc[i] < minValue) {
					minValue = cc[i];
				}
			}
			System.out.println("#"+t+" "+minValue);
		}
	}

}