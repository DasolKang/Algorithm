import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] isPrime = getPrime();
		boolean flag = true;
		while (true) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0)
				break;
			for (int i=3;i<=(int)number/2;i++) {
				if (isPrime[i] && isPrime[number-i]) {
					sb.append(number+" = "+i+ " + "+(number-i)+"\n");
					flag=false;
					break;
				}
			}
			if (flag) sb.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(sb.toString());
	}

	static boolean[] getPrime() {
		boolean[] isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);
		for (int i = 2; i < Math.pow(1000001, 0.5); i++) {
			for (int j = i + i; j < 1000001; j += i) {
				isPrime[j] = false;
			}
		}
		return isPrime;
	}

}