package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_2252 {
    
    static ArrayList<Integer>[] connectInfo;
    static int[] inputNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        connectInfo = new ArrayList[N+1];
        for (int i=1;i<N+1;i++) {
            connectInfo[i]=new ArrayList<>();
        }
        inputNum=new int[N+1];

        for (int i=0;i<M;i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(tokenizer.nextToken());
            int next = Integer.parseInt(tokenizer.nextToken());
            inputNum[next]++;
            connectInfo[pre].add(next);
        }

        StringBuffer buffer = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;i<=N;i++) {
            if (inputNum[i]==0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            buffer.append(now+" ");
            for (int next : connectInfo[now]) {
                inputNum[next]--;
                if (inputNum[next]==0) queue.add(next);
            }
        }
        System.out.println(buffer.toString());
    }
}
