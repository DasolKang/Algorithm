import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int count = 0;
		int num = 0;
		boolean[] removed = new boolean[n+1];
		removed[0] = true;
		while (count < n) {
			int move = 0;
			while (move < k) {
				num = num + 1 > n ?  1 : num + 1;
				if (!removed[num]) move ++;
			}
			removed[num] = true;
			
			sb.append(num);
			if (count + 1 < n) {
				sb.append(", ");
			}
			count ++;
		}
		sb.append(">");
		System.out.println(sb);
	}

}