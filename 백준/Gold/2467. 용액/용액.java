import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] inputArr = new int[N];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			inputArr[i]=Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(inputArr);
		int start=0, end=N-1;
		int ansDiff=Integer.MAX_VALUE;
		int[] answer = new int[2];
		while (start<end) {
			int diff = inputArr[start]+inputArr[end];
			int absDiff = Math.abs(diff);
			if (absDiff<ansDiff) {
				ansDiff = absDiff;
				answer[0]=inputArr[start];
				answer[1]=inputArr[end];
				if (ansDiff==0) break;
			}
			if (diff>0) end--;
			else if (diff<0) start++;
		}
		System.out.println(answer[0]+" "+answer[1]);

	}

}
