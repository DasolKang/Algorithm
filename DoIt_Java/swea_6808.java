package DoIt_Java;

import java.util.*;
import java.io.*;


public class swea_6808 {

    static int kyuWin, minWin;
    static int[] kyuyoung= new int[9]; 
    static int[] minyoung= new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        for (int i=0;i<T;i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j=0;j<9;j++) {
                kyuyoung[j]=Integer.parseInt(tokenizer.nextToken());
            }
            kyuWin=0;
            minWin=0;
            getPartnerCard();
            solution(new int[9], 0, new boolean[9]);
            System.out.println("#"+(i+1)+" "+kyuWin+" "+minWin);
        }
    }

    static void solution(int[] curArr, int index, boolean[] visit) {
        if (index==9) {
            getGameScore(kyuyoung, curArr);
            return ;
        }

        for (int i=0; i<9; i++) {
            if (!visit[i]) {
                visit[i]=true;
                curArr[index]=minyoung[i];
                solution(curArr, index+1, visit);
                visit[i]=false;
            }
        }
    }


    static void getGameScore (int[] kyu, int[] min) {
        
        int kyu_score=0, min_score=0; 
        for (int i=0;i<9;i++) {
            if (kyu[i]>min[i]) {
                kyu_score+=(kyu[i]+min[i]);
            } else if (min[i]>kyu[i]) {
                min_score+=(kyu[i]+min[i]);
            }
        }
        if (kyu_score>min_score) kyuWin++;
        else if (min_score>kyu_score) minWin++;
        return ;
    }


    static void getPartnerCard () {
        boolean[] check = new boolean[19];
        for (int i=0;i<9;i++) {
            check[kyuyoung[i]]=true;
        }
        int[] partner = new int[9];
        int index=0;
        for (int i=1;i<19;i++) {
            if (!check[i]) {
                partner[index++]=i;
            }
        }
        minyoung = partner;
        return ;
    }

    static void printArr(int[] array) {
        System.out.print("[");
        for(int i=0;i<9;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }

}