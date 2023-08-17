import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * BC의 충전 범위 C 이내에 있을 시에 성능 P의 충전을 할 수 있다.
 * 모든 사용자들의 시간별 위치가 주어질 때 얻을 수 있는 최대 충전양을 구하라.
 * 한 BC에 두명의 사용자가 접속한 경우 접속한 사용자 수만큼 균등하게 분배한다.
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static BufferedReader br;
	private static int M, A;
	private static int[][] person, AP;
	private static final int[][] move = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input();
			int charge1 = 0, charge2 = 0;
			int x1 = 0, y1 = 0;
			int x2 = 9, y2 = 9;
			for (int i = 0; i < M + 1; i++) {
				int max1 = 0, max2 = 0;
				x1 = x1 + move[person[0][i]][0];
				y1 = y1 + move[person[0][i]][1];
				x2 = x2 + move[person[1][i]][0];
				y2 = y2 + move[person[1][i]][1];

				ArrayList<Integer> poss1 = new ArrayList<>();
				ArrayList<Integer> poss2 = new ArrayList<>();
				boolean flag = false;
				for (int j = 0; j < A; j++) {
					int p1 = getDistance(x1, y1, AP[j][0] - 1, AP[j][1] - 1);
					int p2 = getDistance(x2, y2, AP[j][0] - 1, AP[j][1] - 1);
					if (p1 <= AP[j][2] && p2 <= AP[j][2]) {
						poss1.add(j);
						poss2.add(j);
						flag = true;
						continue;
					}
					if (p1 <= AP[j][2]) {
						poss1.add(j);
						max1 = Math.max(max1, AP[j][3]);
					} else if (p2 <= AP[j][2]) {
						poss2.add(j);
						max2 = Math.max(max2, AP[j][3]);
					}
				}
				if (flag) {
					int[] charge = getMaxCharge(poss1, poss2);
					max1 = charge[0];
					max2 = charge[1];
				}
				charge1 += max1;
				charge2 += max2;
			}
			sb.append("#").append(test_case).append(" ").append(charge1 + charge2).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] getMaxCharge(List<Integer> poss1, List<Integer> poss2) {
		int[] result = new int[2];
		int max = 0;
		for (int i = 0; i < poss1.size(); i++) {
			for (int j = 0; j < poss2.size(); j++) {
				int p1 = AP[poss1.get(i)][3];
				if (poss1.get(i) == poss2.get(j)) {
					if (max < p1) {
						result[0] = p1 / 2;
						result[1] = p1 / 2;
						max = p1;
					}
					continue;
				}
				int p2 = AP[poss2.get(j)][3];
				if (p1 + p2 > max) {
					max = p1 + p2;
					result[0] = p1;
					result[1] = p2;
				}
			}
		}
		return result;
	}

	private static int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		person = new int[2][M + 1];
		AP = new int[A][4];
		person[0][0] = 0;
		person[1][0] = 0;
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				person[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				AP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}