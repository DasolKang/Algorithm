import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		// 피사노 주기 : 피보나치 수를 K로 나눈 나머지는 항상 주기를 가진다
		// 주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는
		// N%P번째 피보나치 수를 M을 나눈 나머지와 같다
		// 주기는 항상 M*10^(k-1)
		int PISANO = 15 * 100000;
		int MOD = 1000000;
		int[] fibo = new int[PISANO];
		if (N < 2)
			System.out.println(N);
		else {
			fibo[1] = 1;
			for (int i = 2; i < PISANO; i++) {
				fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
			}
			System.out.println(fibo[(int) (N % PISANO)]);
		}
	}

}