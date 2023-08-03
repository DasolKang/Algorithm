import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] prime = getPrime(N);
		int[] prefixSum = getPrimePrefixSum(prime);
		int start = 0, end = 1;
		int answer = 0;
		while (end < prime.length + 1 && start < prime.length + 1 && start < end) {
			int sum = prefixSum[end] - prefixSum[start];
			if (sum == N) {
				answer++;
				end++;
			} else if (sum < N)
				end++;
			else if (sum > N)
				start++;
		}
		System.out.println(answer);
	}

	static int[] getPrime(int N) {
		List<Integer> prime = new ArrayList<>();
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= Math.pow(N, 0.5); i++) {
			for (int j = i + i; j <= N; j += i) {
				isPrime[j] = false;
			}
		}
		for (int i = 2; i <= N; i++) {
			if (isPrime[i])
				prime.add(i);
		}
		return prime.stream().mapToInt(i -> i).toArray();
	}

	static int[] getPrimePrefixSum(int[] array) {
		int size = array.length;
		int[] result = new int[size + 1];
		for (int i = 1; i <= size; i++) {
			result[i] = array[i - 1] + result[i - 1];
		}
		return result;
	}

}