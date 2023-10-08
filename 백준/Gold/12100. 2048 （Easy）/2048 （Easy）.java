import java.util.*;
import java.io.*;

public class Main {

    private static int[] move;
    private static int N, board[][]; 
    private static int answer;
    private static boolean check = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        combination(0);
        System.out.println(answer);
    }

    private static void combination(int index) {
        if (index==5) {
            // 5번의 이동이 모두 뽑혔다면 게임시작
            game();
            return;
        }

        for (int i=0;i<4;i++) {
            move[index]=i;
            combination(index+1);
        }
    }

    private static void game() {
        int[][] curBoard = copy();
        for (int i=0;i<5;i++) {
            moveBlock(curBoard, move[i]);
        }
        
    }

    private static void moveBlock(int[][] curBoard, int moveIndex) {
        if (moveIndex==0) {
            // 위로 이동
            for (int j=0;j<N;j++) {
                //합치기
                int startIndex=0;
                for (int i=1;i<N;i++) {
                    if (curBoard[i][j]==0) continue;
                    if (curBoard[i][j]==curBoard[startIndex][j]) {
                        curBoard[startIndex][j]*=2;
                        answer=Math.max(answer, curBoard[startIndex][j]);
                        curBoard[i][j]=0;
                        startIndex=i;
                    }
                    startIndex=i;
                }
                //위로 올리기
                int i=0;
                while (i<N-1){
                    if (curBoard[i][j]!=0) i++;
                    else {
                        int change = i+1;
                        while (change<N-1 && curBoard[change][j]==0) {
                            change++;
                        }
                        curBoard[i][j]=curBoard[change][j];
                        curBoard[change][j]=0;
                        i++;
                    }
                }
            }
        } else if (moveIndex==1) {
            // 오른쪽으로 이동
            for (int i=0;i<N;i++) {
                //합치기
                int startIndex=N-1;
                for (int j=N-2;j>=0;j--) {
                    if (curBoard[i][j]==0) continue;
                    if (curBoard[i][j]==curBoard[i][startIndex]) {
                        curBoard[i][startIndex]*=2;
                        answer=Math.max(answer, curBoard[i][startIndex]);
                        curBoard[i][j]=0;
                    } 
                    startIndex=j;
                }
                //오른쪽으로 옮기기
                int j=N-1;
                while (j>0){
                    if (curBoard[i][j]!=0) j--;
                    else {
                        int change = j-1;
                        while (change>0 && curBoard[i][change]==0) {
                            change--;
                        }
                        curBoard[i][j]=curBoard[i][change];
                        curBoard[i][change]=0;
                        j--;
                    }
                }
            }
        } else if (moveIndex==2) {
            // 아래로 이동
            for (int j=0;j<N;j++) {
                //합치기
                int startIndex=N-1;
                for (int i=N-2;i>=0;i--) {
                    if (curBoard[i][j]==0) continue;
                    if (curBoard[i][j]==curBoard[startIndex][j]) {
                        curBoard[startIndex][j]*=2;
                        answer=Math.max(answer, curBoard[startIndex][j]);
                        curBoard[i][j]=0;
                    } 
                    startIndex=i;
                }
                
                //아래로 내리기
                int i=N-1;
                while (i>0){
                    if (curBoard[i][j]!=0) i--;
                    else {
                        int change = i-1;
                        while (change>0 && curBoard[change][j]==0) {
                            change--;
                        }
                        curBoard[i][j]=curBoard[change][j];
                        curBoard[change][j]=0;
                        i--;
                    }
                }
            }
        } else if (moveIndex==3) {
            // 왼쪽으로 이동
            for (int i=0;i<N;i++) {
                //합치기
                int startIndex=0;
                for (int j=1;j<N;j++) {
                    if (curBoard[i][j]==0) continue;
                    if (curBoard[i][j]==curBoard[i][startIndex]) {
                        curBoard[i][startIndex]*=2;
                        answer=Math.max(answer, curBoard[i][startIndex]);
                        curBoard[i][j]=0;
                        startIndex=j;
                    } 
                    startIndex=j;
                }
                //왼쪽으로 옮기기
                int j=0;
                while (j<N-1){
                    if (curBoard[i][j]!=0) j++;
                    else {
                        int change = j+1;
                        while (change<N-1 && curBoard[i][change]==0) {
                            change++;
                        }
                        curBoard[i][j]=curBoard[i][change];
                        curBoard[i][change]=0;
                        j++;
                    }
                }

            }
        }


    }

    private static int[][] copy() {
        int[][] newBoard = new int[N][N];
        for (int i=0;i<N;i++) {
            newBoard[i]=board[i].clone();
        }
        return newBoard;
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        answer=0;
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                answer = Math.max(answer, board[i][j]);
            }
        }
        move = new int[5];
    }

}