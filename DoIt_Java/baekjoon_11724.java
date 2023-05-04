package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_11724 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        visited=new boolean[N+1];
        A = new ArrayList[N+1];
        
        for (int i=1;i<=N;i++) {
            A[i]=new ArrayList<Integer>();
        }

        for (int i=0;i<M;i++) {
            tokenizer=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            A[x].add(y); A[y].add(x);
        }
        
        int answer=0;
        for (int i=1;i<=N;i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int index) {
        if (visited[index]) return ;
        visited[index]=true;
        for (int next : A[index]) {
            if (!visited[next]) {
                DFS(next);
            }
        }

    }
}
