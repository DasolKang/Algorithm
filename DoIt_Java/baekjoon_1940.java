package DoIt_Java;

import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class baekjoon_1940 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] numArray=new int[N];
        for (int i=0;i<N;i++) {
            numArray[i]=Integer.parseInt(tokenizer.nextToken());
        }
        
        Arrays.sort(numArray);
        int start=0; int end=N-1;
        int temp=0;
        int answer=0;
        while (start<end) {
            temp=numArray[start]+numArray[end];
            if (temp==M) {
                answer+=1;
                start++;
                end--;
            } else if (temp>M) end--;
            else start++;
        }
        System.out.println(answer);
    }
}
