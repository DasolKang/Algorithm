package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_12891 {
    
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(tokenizer.nextToken());
        int M=Integer.parseInt(tokenizer.nextToken());
        
        char[] A = br.readLine().toCharArray();

        tokenizer=new StringTokenizer(br.readLine());
        checkArr = new int[4];
        checkSecret=0; //4개 중 몇개가 비밀번호 요건 만족?
        for (int i=0;i<4;i++) {
            checkArr[i]=Integer.parseInt(tokenizer.nextToken());
            if (checkArr[i]==0) checkSecret++;
        }

        myArr = new int[4];
        for (int i=0;i<M;i++) {
            // 처음 부분 문자열 상태 세팅
            addCharacter(A[i]);
        }

        int answer=0;
        if (checkSecret==4) answer++;

        //슬라이딩 윈도우
        for (int end=M;end<N;end++) {
            int start=end-M;
            addCharacter(A[end]);
            removeCharacter(A[start]);
            if (checkSecret==4) answer++;
        }

        System.out.println(answer);
        br.close();
    }

    private static void addCharacter(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0]==checkArr[0]) checkSecret++;
            case 'C':
                myArr[1]++;
                if (myArr[1]==checkArr[1]) checkSecret++;
            case 'G':
                myArr[2]++;
                if (myArr[2]==checkArr[2]) checkSecret++;
            case 'T':
                myArr[3]++;
                if (myArr[3]==checkArr[3]) checkSecret++;
        }
    }

    private static void removeCharacter(char c) {
        switch (c) {
            case 'A':
                myArr[0]--;
                if (myArr[0]==checkArr[0]) checkSecret--;
            case 'C':
                myArr[1]--;
                if (myArr[1]==checkArr[1]) checkSecret--;
            case 'G':
                myArr[2]--;
                if (myArr[2]==checkArr[2]) checkSecret--;
            case 'T':
                myArr[3]--;
                if (myArr[3]==checkArr[3]) checkSecret--;
        }
    }
}
