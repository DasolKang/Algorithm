package DoIt_Java;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_11659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];
        int sum=0;
        for (int i=0;i<N;i++) {
            A[i]=scanner.nextInt();
            sum+=A[i];
            S[i]=sum;
        }

        for (int i=0;i<M;i++) {
            int start=scanner.nextInt();
            int end=scanner.nextInt();
            start-=1; end-=1;
            if (start==0) System.out.println(S[end]);
            else System.out.println(S[end]-S[start-1]);
        }

        scanner.close();
    }

    public void solution() throws IOException {
        // 받는 데이터 많은 때 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        long[] S = new long[N+1];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            S[i]=S[i-1]+Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            int start=Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            System.out.println(S[end]-S[start-1]);
        }
    }
}
