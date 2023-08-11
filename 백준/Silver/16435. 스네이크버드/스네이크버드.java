import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 스네이크버드의 처음 길이가 L이며 과일을 먹을 때마다 길이가 1씩 늘어난다.
 * 과일이 지상으로부터 일정 높이를 두고 떨어져있을 때,
 * 과일을 먹어 늘릴 수 있는 최대 길이를 구하라.
 * 2. strategy: 풀이전략
 * 과일을 높이에 따라 정렬한 후 먹을 수 먹을 수 있을만큼 먹는다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] fruit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fruit);
		for (int i = 0; i < N; i++) {
			if (fruit[i] <= L) {
				L++;
			} else
				break;
		}

		System.out.println(L);
	}

}