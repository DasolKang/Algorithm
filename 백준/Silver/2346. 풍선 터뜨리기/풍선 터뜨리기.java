import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		Deque<int[]> balloon = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int jump = Integer.parseInt(tokenizer.nextToken());
			balloon.addLast(new int[]{i+1, jump});
		}
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			int[] temp = balloon.pollFirst();
			sb.append(temp[0]).append(" ");
			if (balloon.isEmpty()) break;
			if (temp[1]>0) {
				for (int i=temp[1];i>1;i--) {
					balloon.addLast(balloon.pollFirst());
				}
			} else {
				for (int i=temp[1];i<0;i++) {
					balloon.addFirst(balloon.pollLast());
				}
			}
		}
		System.out.println(sb.toString());
	}

}