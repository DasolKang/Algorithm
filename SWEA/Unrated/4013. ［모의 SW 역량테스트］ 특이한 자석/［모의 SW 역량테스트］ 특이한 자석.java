import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	자석을 시계, 반시계 방향으로 회전할 때 맞닿은 자석의 극이 다를 때 반대방향으로 회전한다
 *  모든 자석을 K번 돌렸을 때의 점수를 계산하고자 한다.
 *  - 1번이 N극일 때 0점, S극일 때 1점
 *  - 2번이 S극일 때 2점
 *  - 3번이 S극일 때 4점
 *  - 4번이 S극일 때 8점
 * 2. strategy: 풀이전략
 *  입력으로 들어온 자석의 인덱스와 방향에 맞춰 회전
 *  -> 왼쪽 자석과 맞닿은 극이 다를 때 왼쪽 자석을 방향의 반대로 회전
 *  -> 오른쪽 자석과 맞닿은 극이 다를 때 오른쪽 자석을 방향의 반대로 회전
 * 3. note: 주의할 사항(특이사항)
 */

public class Solution {

	private static int K;
	private static ArrayList<Integer>[] info;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			for (int i = 0; i < K; i++) {
				visited = new boolean[5];
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				visited[index] = true;
				turn(index, dir);
			}
			sb.append("#").append(test_case).append(" ");
			sb.append(getScore()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void turn(int index, int turnDir) {
		// 현재 톱니 바퀴의 왼쪽 바퀴 돌리기
		if (index - 1 > 0 && !visited[index - 1] && 
				info[index].get(6) != info[index - 1].get(2)) {
			visited[index] = true;
			turn(index - 1, -(turnDir));
		}

		// 현재 톱니 바퀴의 오른쪽 바퀴 돌리기
		if (index + 1 <= 4 && !visited[index + 1] && 
				info[index].get(2) != info[index + 1].get(6)) {
			visited[index] = true;
			turn(index + 1, -(turnDir));
		}

		ArrayList<Integer> temp = info[index];
		if (turnDir == -1) {
			int last = temp.remove(0);
			temp.add(last);
		} else {
			int first = temp.remove(temp.size() - 1);
			temp.add(0, first);
		}
	}

	private static int getScore() {
		int result = 0;
		for (int i = 1; i <= 4; i++) {
			if (info[i].get(0) == 1)
				result += Math.pow(2, i - 1);
		}
		return result;
	}

	private static void init(BufferedReader br) throws IOException {
		K = Integer.parseInt(br.readLine());
		info = new ArrayList[5];
		for (int i = 1; i <= 4; i++) {
			info[i] = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				info[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}

}