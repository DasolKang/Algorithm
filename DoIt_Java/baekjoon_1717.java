package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_1717 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        parents = new int[n+1];
        for (int i=1;i<=n;i++) parents[i]=i;

        for (int i=0;i<m;i++) {
            String[] command = br.readLine().split(" ");
            if (Integer.parseInt(command[0])==0) {
                union(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                printArr(parents);
            } else {
                if (isSameGroup(Integer.parseInt(command[1]), Integer.parseInt(command[2]))){
                    System.out.println("YES");
                } else System.out.println("NO");
            }
        }
    }

    private static int find(int node) {
        if (node==parents[node]) return node;
        else {
            return parents[node]=find(parents[node]);
        }
    }

    private static boolean isSameGroup(int x, int y){
        if (find(x)==find(y)) return true;
        return false;
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX>parentY) {
            parents[parentX]=parentY;
        }
        else {
            parents[parentY]=parentX;
        }
    } 

    private static void printArr(int[] arr) {
        System.out.print("{");
        for (int a : arr) {
            System.out.print(" "+a);
        }
        System.out.println(" }");
    }
    
}