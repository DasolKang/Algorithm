import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		
		Deque<Integer> queue = new LinkedList<>();
		for (int i=1; i<=N;i++) {
			queue.add(i);
		}
		
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			for (int i=0;i<K-1;i++) {
				queue.add(queue.pollFirst());
			}
			result.add(queue.pollFirst());
		}
		System.out.print("<");
		for (int i=0;i<N;i++) {
			System.out.print(result.get(i));
			if (i<N-1) System.out.print(", ");
		}
		System.out.print(">");
		
	}
}