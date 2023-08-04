import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			if (queue.size() > 1) {
				queue.offer(queue.poll());
			}
		}
		
		System.out.println(queue.poll());
	}

}