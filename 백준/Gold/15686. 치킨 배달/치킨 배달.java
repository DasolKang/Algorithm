import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 크기가 N*N인 도시에 집, 치킨집이 있다.
 * 도시의 치킨거리는 모든 집의 치킨거리(치킨집까지의 거리)의 합니다.
 * M개를 제외한 치킨집을 폐업시킬 때, 얻을 수 있는 도시의 치킨거리의 최소를 구하라
 * 2. strategy: 풀이전략
 * 장사를 이어나갈 치킨집 M개를 조합으로 뽑은 후
 * 각 조합에 대한 도시의 치킨거리를 구하여 최솟값을 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int N, M, city[][];
	private static List<int[]> chickenStore;
	private static int answer, storeNum, aliveStore[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];

		storeNum = 0;
		chickenStore = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 2) {
					chickenStore.add(new int[] { i, j });
					storeNum++;
				}
			}
		}

		aliveStore = new int[M];
		answer = Integer.MAX_VALUE;
		getAliveStore(0, 0);
		System.out.println(answer);
	}

	private static void getAliveStore(int start, int index) {
		if (index == M) {
			getCityDistance();
			return;
		}

		for (int i = start; i < storeNum; i++) {
			aliveStore[index] = i;
			getAliveStore(i + 1, index + 1);
		}
	}

	private static void getCityDistance() {
		int cityDistance = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (city[i][j] == 1) {
					cityDistance += getChickenDistance(i, j);
				}
			}
		}
		answer = Math.min(answer, cityDistance);
	}

	private static int getChickenDistance(int x, int y) {
		int minDist = Integer.MAX_VALUE;
		for (int i : aliveStore) {
			minDist = Math.min(minDist, Math.abs(chickenStore.get(i)[0] - x) + Math.abs(chickenStore.get(i)[1] - y));
		}
		return minDist;
	}

}