import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			A[i]=Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		tokenizer = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			boolean flag = false;
			int curNum = Integer.parseInt(tokenizer.nextToken());
			int start=0, end=N-1;
			while (start<=end) {
				int mid = (start+end)/2;
				if (A[mid]==curNum) {
					flag=true;
					break;
				}
				else if (A[mid]>curNum) end=mid-1;
				else start=mid+1;
			}
			if (flag) System.out.println(1);
			else System.out.println(0);
		}
	}

}