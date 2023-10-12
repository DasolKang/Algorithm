import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N<2) System.out.println(N);
		else {
			BigInteger fibo[] = new BigInteger[N + 1];
			fibo[0] = BigInteger.ZERO;
			fibo[1] = BigInteger.ONE;
			for (int i = 2; i <= N; i++) {
				fibo[i] = fibo[i - 1].add(fibo[i - 2]);
			}
			System.out.println(fibo[N]);
		}
	}

}