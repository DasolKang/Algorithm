package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_1920 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArray = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            numArray[i]=Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(numArray);
        
        boolean flag=false;
        int M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            int findNum = Integer.parseInt(tokenizer.nextToken());
            int start=0, end=N-1;
            flag = false;
            while (start<=end) {
                int mid=(start+end)/2;
                if (numArray[mid]==findNum) {
                    flag=true;
                    break;
                }
                if (numArray[mid]>findNum) end=mid-1;
                else start=mid+1;
            }
            if (flag) System.out.println(1);
            else System.out.println(0);
        }
    }
}
