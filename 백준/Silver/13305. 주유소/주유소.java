import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] distance = new int[N - 1], price = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0, answer = 0;
		while (start < N - 1) {
			int dist = 0;
			for (end = start + 1; end < N; end++) {
				dist += distance[end - 1];
				if (price[start] > price[end]) {
					break;
				}
			}
			answer += (price[start] * dist);
			start = end;
		}
		System.out.println(answer);
	}

}