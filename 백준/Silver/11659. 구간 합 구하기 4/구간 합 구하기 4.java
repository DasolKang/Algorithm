import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 	  수 N개가 주어졌을 때 i번~j번째 수의 합을 구하라
 * 2. strategy: 풀이전략
 *    0번 인덱스부터 본인의 인덱스까지의 합을 구한 후
 *    i~j의 합이 [0~j]의 합 - [0~i-1]의 합으로 구할 수 있다는 점을 이용 
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int[] number = new int[N];
		tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int[] prefixSum = getPrefixSum(number);
		for (int t = 0; t < M; t++) {
			tokenizer = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(tokenizer.nextToken());
			int j = Integer.parseInt(tokenizer.nextToken());
			System.out.println(prefixSum[j]-prefixSum[i-1]);
		}

	}

	static int[] getPrefixSum(int[] array) {
		int sum = 0;
		int[] result = new int[array.length+1];
		for (int i = 1; i <= array.length; i++) {
			sum += array[i-1];
			result[i] = sum;
		}
		return result;
	}

}