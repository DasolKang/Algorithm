import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int[][] train = new int[N][20];
		for (int i=0;i<M;i++) {
			String[] command = br.readLine().split(" ");
			if (command[0].equals("1")) {
				int t = Integer.parseInt(command[1])-1;
				int seat = Integer.parseInt(command[2])-1;
				train[t][seat]=1;
			} else if (command[0].equals("2")) {
				int t = Integer.parseInt(command[1])-1;
				int seat = Integer.parseInt(command[2])-1;
				train[t][seat]=0;
			} else if (command[0].equals("3")) {
				int t = Integer.parseInt(command[1])-1;
				if (train[t][19]==1) train[t][19]=0;
				for (int j=18;j>=0;j--) {
					if (train[t][j]==1) {
						train[t][j]=0;
						train[t][j+1]=1;
					}
				}
			} else if (command[0].equals("4")) {
				int t = Integer.parseInt(command[1])-1;
				if (train[t][0]==1) train[t][0]=0;
				for (int j=1;j<20;j++) {
					if (train[t][j]==1) {
						train[t][j-1]=1;
						train[t][j]=0;
					}
				}
			}
		}
		
		int answer = 0;
		List<String> isPassed = new ArrayList<>();
		for (int i=0;i<N;i++) {
			String trainStr = Arrays.toString(train[i]);
			if (! isPassed.contains(trainStr)) {
				answer++;
				isPassed.add(trainStr);
			}
		}
		System.out.println(answer);
	}
}