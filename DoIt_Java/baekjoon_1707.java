package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_1707 {
    
    static int[] parentInfo;
    static boolean[] visited;
    static ArrayList<Integer>[] edgeInfo;
    static boolean flag;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for (int testCase=0;testCase<T;testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int V=Integer.parseInt(tokenizer.nextToken());
            int E=Integer.parseInt(tokenizer.nextToken());
            parentInfo=new int[V+1];
            edgeInfo = new ArrayList[V+1];
            visited=new boolean[V+1];
            flag=true;
            for (int i=0;i<=V;i++) {
                edgeInfo[i]=new ArrayList<Integer>();
            }

            //엣지 데이터 저장
            for (int i=0;i<E;i++) {
                tokenizer = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                edgeInfo[start].add(end);
                edgeInfo[end].add(start);
            }

            //모든 노드에 대해 DFS 실행
            for (int i=1;i<=V;i++) {
                if (flag) DFS(i);
                else break;
            }

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
        

    }

    private static void DFS(int node) {
        visited[node]=true;
        for (int nextNode : edgeInfo[node]) {
            if (!visited[nextNode]) {
                parentInfo[nextNode]=(parentInfo[node]+1)%2;
                DFS(nextNode);
            } else if (parentInfo[nextNode]==parentInfo[node]) {
                flag=false;
            }
        }
    }

}
