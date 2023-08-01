import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int i=0;i<N;i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			if (num<2) continue;
			if (num==2) {
				answer+=1;
				continue;
			}
			boolean isPrime=true;
			for (int j=2;j<(int)Math.pow(num, 0.5)+1;j++) {
				if (num%j==0) isPrime=false; 
			}
			if (isPrime) answer++;
		}
		System.out.println(answer);
	}
	
}
