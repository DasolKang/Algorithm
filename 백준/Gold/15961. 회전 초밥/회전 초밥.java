import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0, eatNum = 0;
		int eat[] = new int[d + 1];
		for (int i = 0; i < k; i++) {
			eat[sushi[i]]++;
			if (eat[sushi[i]] == 1)
				eatNum++;
		}
		int start = 0, end = k;
		while (start < N) {
			end %= N;
			eat[sushi[start]]--;
			if (eat[sushi[start]] == 0)
				eatNum--;
			eat[sushi[end]]++;
			if (eat[sushi[end]] == 1) {
				eatNum++;
			}
			start++;
			end++;
			if (eat[c] == 0)
				answer = Math.max(answer, eatNum + 1);
			else
				answer = Math.max(answer, eatNum);
		}
		System.out.println(answer);
	}
}