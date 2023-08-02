import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());
			Deque<int[]> queue = new LinkedList<>();
			int[] priority = new int[N];
			tokenizer = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int inputPriority = Integer.parseInt(tokenizer.nextToken());
				priority[i] = inputPriority;
				int[] temp = new int[2];
				temp[0]=inputPriority;
 				if (i != M) {
					temp[1] = 0;
				} else {
					temp[1] = 1;
				}
				queue.addLast(temp);
			}
			
			int answer = 0;
			while (!queue.isEmpty()) {
				int[] print = queue.peek();
				int[] maxPriority = getMaxPriority(priority);
				if (print[0]<maxPriority[0]) {
					queue.addLast(queue.pollFirst());
				} else if (print[1]==1){
					answer++;
					break;
				} else {
					answer++;
					queue.pollFirst();
					priority[maxPriority[1]]=0;
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] getMaxPriority(int[] array) {
		int[] result = new int[2];
		int max = 0;
		for (int i=0;i<array.length;i++) {
			if (array[i]>max) {
				max=array[i];
				result[0]=array[i];
				result[1]=i;
			}
		}
		return result;
	}

}