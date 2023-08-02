import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		boolean[] isPrime = getPrime(N);
		StringBuilder sb = new StringBuilder();
		for (int i=M;i<=N;i++) {
			if (isPrime[i]) sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean[] getPrime(int N) {
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0]=false;
		prime[1]=false;
		for (int i=2;i<=(int)Math.pow(N+1, 0.5);i++) {
			for (int j=i+i;j<N+1;j+=i) {
				prime[j]=false;
			}
		}
		return prime;
	}

}
