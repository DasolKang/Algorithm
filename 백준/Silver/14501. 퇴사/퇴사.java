import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] counseling = new int[N+2][2];
        int[] maxCost = new int[N+2];
        for (int i=1;i<=N;i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            counseling[i][0]=Integer.parseInt(tokenizer.nextToken());
            counseling[i][1]=Integer.parseInt(tokenizer.nextToken());
        }   

        for (int day=N;day>0;day--) {
            int finishDay = day+counseling[day][0];
            if (finishDay<=N+1) {
                maxCost[day]= Math.max(maxCost[day+1], counseling[day][1]+maxCost[finishDay]);
            } else {
                maxCost[day]=maxCost[day+1];
            }
        }
        System.out.println(maxCost[1]);
    }
}