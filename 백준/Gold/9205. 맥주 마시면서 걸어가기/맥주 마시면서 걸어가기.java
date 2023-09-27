import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	맥주가 20개 들어있는 한 박스를 들고 50미터에 한 병씩 마시고자 한다.
 * 	한 박스에 20개 이상의 맥주를 넣을 수 없으며 편의점에서 추가 맥주를 살 수 있다.
 * 	편의점, 집, 페스티벌 장소가 주어질 때, 행복하게 도착할 수 있는지 구하라.
 * 2. strategy: 풀이전략
 * 	50미터마다 맥주를 한 명씩 마시므로 가득찬 상자로 최대 1000미터 이동 가능
 * 	집에서 행복하게 갈 수 있는 편의점으로 계속 이동 중 축제 장소 도착 -> happy
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	private static int n, homeX, homeY, festivalX, festivalY;
	private static int[][] store;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			init(br);
			String result = "sad";
			boolean[] visited = new boolean[n + 1];
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] { homeX, homeY });
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				int x = temp[0], y = temp[1];
				if (x == festivalX && y == festivalY) result = "happy";
				for (int i = 0; i < n + 1; i++) {
					if (visited[i]) continue;
					int nx = store[i][0], ny = store[i][1];
					if (getDistance(x, y, nx, ny) <= 1000) {
						queue.offer(new int[] { nx, ny });
						visited[i] = true;
					}
				}
			}
			System.out.println(result);
		}

	}

	private static int getDistance(int x, int y, int nx, int ny) {
		return Math.abs(nx - x) + Math.abs(ny - y);
	}

	private static void init(BufferedReader br) throws IOException {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		homeX = Integer.parseInt(st.nextToken());
		homeY = Integer.parseInt(st.nextToken());
		store = new int[n + 1][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			store[i] = new int[] { tempX, tempY };
		}
		st = new StringTokenizer(br.readLine());
		festivalX = Integer.parseInt(st.nextToken());
		festivalY = Integer.parseInt(st.nextToken());
		store[n] = new int[] { festivalX, festivalY };
	}

}