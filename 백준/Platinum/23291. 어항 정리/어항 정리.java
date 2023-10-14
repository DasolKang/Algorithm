import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static int[][] board;
    private static int curIndex, height;
    private static final int[] dxs={-1, 0, 1, 0};
    private static final int[] dys={0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        int answer = 0;
        while (keepGoing()){
            answer++;
            addFish();
            buildBoard();
            controlFishNum();
            makeLine();
            buildMidBoard();
            controlFishNum();
            makeLine();
        }
        System.out.println(answer);
    }

    private static void buildBoard() {
        // 가장 왼쪽 어항 바로 오른쪽에 올리기
        curIndex=1;
        height=0;
        board[1][1]=board[0][0];
        board[0][0]=0;

        while (true) {
            // 2개 이상 쌓여있는 어항 확인
            int lastIndex=0;
            for (int i=curIndex;i<N;i++) {
                if (board[1][i]!=0) {
                    lastIndex=i;
                } else break;
            }

            // 2개 이상 쌓인 어항들 공중부양 후 쌓기
            // curIndex~lastIndex까지 lastIndex+1 위부터 쌓기
            // 1. 쌓을 수 있는지 확인
            height = 0;
            for (int i=0;i<N;i++) {
                if (board[i][curIndex]!=0) height++;
                else break;
            }
        
            // 남은 칸의 수가 높이보다 작다면 작을 수 없음
            if ((N-1)-lastIndex<height) break;

            // 2. 쌓을 수 있다면 쌓기
            // int buildIndex = lastIndex+height;
            // System.out.println("쌓는 인덱스 >> "+buildIndex);
            for (int buildIndex=lastIndex+height, i=height-1;
            buildIndex>lastIndex&& i>=0;buildIndex--, i--) {
                for (int temp = 1;temp<=lastIndex-curIndex+1;temp++) {
                    board[temp][buildIndex]=board[i][lastIndex-temp+1];
                    board[i][lastIndex-temp+1]=0;
                }
            }

            curIndex=lastIndex+1;
        }
    }

    private static void buildMidBoard() {
        curIndex=N/2;
        for (int j=curIndex, tempIndex=curIndex-1;j<N&&tempIndex>=0;j++, tempIndex--) {
            board[1][j]=board[0][tempIndex];
            board[0][tempIndex]=0;
        }
        height=2;

        curIndex+=N/4;
        int tempIndex=curIndex-1;
        for (int j=curIndex;j<N;j++) {
            for (int i=height;i<height+2;i++) {
                board[i][j]=board[4-i-1][tempIndex];
                board[4-i-1][tempIndex]=0;
            }
            tempIndex--;
        }
        height=4;
    }

    private static void makeLine() {
        // 어항을 일렬로 놓는 작업
        // 2개 이상 쌓여있는 어항 확인
        int lastIndex=0;
        for (int i=curIndex;i<N;i++) {
            if (board[1][i]!=0) {
                lastIndex=i;
            } else break;
        }

        int tempIndex=0;
        for (int j=curIndex;j<=lastIndex;j++) {
            for (int i=0;i<height;i++) {
                if (board[i][j]==0) break;
                board[0][tempIndex++]=board[i][j];
                board[i][j]=0;
            }
        }
    }

    private static void controlFishNum() {
        // 인접한 두 어항에 대해 물고기 수 차이 구하기
        // 차이를 5로 나눈 몫인 d
        boolean[][] visited = new boolean[N][N];
        int[][] newBoard = new int[N][N];
        for (int j=curIndex;j<N;j++) {
            for (int i=0;i<height;i++) {
                if (board[i][j]==0) continue;
                visited[i][j]=true;
                for (int d=0;d<4;d++) {
                    int nx = i+dxs[d];
                    int ny = j+dys[d];
                    if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny]!=0) {
                        int diff = Math.abs(board[nx][ny]-board[i][j]);
                        diff/=5;
                        if (diff==0) continue;
                        if (board[nx][ny]>board[i][j]) {
                            newBoard[nx][ny]-=diff;
                            newBoard[i][j]+=diff;
                        } else {
                            newBoard[nx][ny]+=diff;
                            newBoard[i][j]-=diff;
                        }
                    }
                }
            }
        }

        for (int j=curIndex;j<N;j++) {
            for (int i=0;i<height;i++) {
                board[i][j]+=(newBoard[i][j]);
            }
        }
    }

    private static void addFish() {
        List<Integer> index= new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        for (int i=0;i<N;i++) {
            if (board[0][i]<minValue) {
                minValue = board[0][i];
                index=new ArrayList<>();
                index.add(i);
            } else if (board[0][i]==minValue) {
                index.add(i);
            }
        }

        for (int i:index) {
            board[0][i]++;
        }
    }

    private static boolean keepGoing() {
        int maxValue=0, minValue=Integer.MAX_VALUE;
        for (int i=0;i<N;i++) {
            if (board[0][i]>maxValue) maxValue=board[0][i];
            if (board[0][i]<minValue) minValue=board[0][i];
        }
        if (maxValue-minValue<=K) return false;
        return true;
    }

    private static boolean inRange(int x, int y) {
        return 0<=x && x<N && 0<=y && y<N;
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            board[0][i]=Integer.parseInt(st.nextToken());
        }
        curIndex=0;
        height=1;
    }
}