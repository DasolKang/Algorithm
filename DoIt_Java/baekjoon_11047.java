package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        
        int[] coins = new int[N];
        for (int i=0;i<N;i++) {
            coins[i]=Integer.parseInt(br.readLine());
        }

        int answer=0;
        for (int i=N-1;i>=0;i--) {
            int curCost=coins[i];
            if (curCost>K) continue;
            answer+=(K/curCost);
            K%=curCost;
        }
        System.out.println(answer);
    }
    
}
