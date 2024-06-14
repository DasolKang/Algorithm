import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, end, array[], lis[];

	public static void main(String[] args) throws IOException {
		init();
		for (int i=0;i<N;i++) {
			if (array[i]>lis[end]) {
				if (i!=0) end++;
				lis[end] = array[i];
			} else {
				int index = getIndex(array[i]);
				lis[index] = array[i];
			}
		}
		System.out.println(end+1);
	}

	private static int getIndex(int num) {
		int left = 0, right = end;
		while (left < right) {
			int mid = (left + right) / 2;
			if (lis[mid]==num) {
				right = mid;
				break;
			}
			if (lis[mid] > num)
				right = mid;
			else
				left = mid + 1;
		}
		return right;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		lis = new int[N];
	}
}