package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_1929 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(), N =scanner.nextInt();

        int[] isPrime = new int[N+1];
        Arrays.fill(isPrime, 1);
        isPrime[0]=1; isPrime[1]=0;
        for (int i=2;i<=Math.sqrt(N);i++) {
            for (int j=2;i*j<N+1;j++) {
                isPrime[i*j]=0;
            }
        }

        for (int i=M;i<=N;i++) {
            if (isPrime[i]==1) System.out.println(i);
        }
        
    }

    
}
