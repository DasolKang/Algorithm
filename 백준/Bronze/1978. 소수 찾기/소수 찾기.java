import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int[] number = new int[N];
		boolean[] isPrime = getPrime();
		int answer = 0;
		for (int i=0;i<N;i++) {
			if (isPrime[Integer.parseInt(tokenizer.nextToken())]) answer+=1;
		}
		System.out.println(answer);
	}
	
	static boolean[] getPrime() {
		boolean[] result = new boolean[1001];
		Arrays.fill(result, true);
		result[0]=false; result[1]=false;
		for (int i=2;i<(int)Math.pow(1001, 0.5);i++) {
			for (int j=i*2;j<1001;j+=i) {
				result[j]=false;
			}
		}
		return result;
	}
}
