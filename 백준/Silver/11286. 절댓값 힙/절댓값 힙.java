import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Abs> queue = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(queue.poll().val).append("\n");
				}
			} else {
				queue.offer(new Abs(Math.abs(x), x));
			}
		}
		
		System.out.println(sb);
	}

}

class Abs implements Comparable<Abs>{
	int absVal;
	int val;
	public Abs(int absVal, int val) {
		this.absVal = absVal;
		this.val = val;
	}
	
	@Override
	public int compareTo(Abs o) {
		if (o.absVal == this.absVal) {
			return this.val - o.val;
		}
		return this.absVal - o.absVal;
	}
	
}