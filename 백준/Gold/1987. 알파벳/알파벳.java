import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * R*C 모양의 보드의 각 칸에 대문자 알파벳이 적혀있다.
 * (1, 1)에 놓인 말이 상하좌우로 이동한다.
 * 이미 지나온 알파벳에는 지날 수 없다.
 * 2. strategy: 풀이전략
 * DFS로 시작 위치부터 각 방향을 탐색하며 최대 칸 수를 구한다.
 * 3. note: 주의할 사항(특이사항)
 */

public class Main {

    private static int R, C;
    private static char[][] board;
    private static final int[] dxs = { -1, 0, 1, 0 };
    private static final int[] dys = { 0, 1, 0, -1 };
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[R][C];
        boolean[] alphabet = new boolean[26];
        answer = 0;
        alphabet[(int)board[0][0]-65]=true;
        visited[0][0]=true;
        dfs(0, 0, 1, alphabet, visited);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count, boolean[] alphabet, boolean[][] visited) {
        answer = Math.max(answer, count);
        for (int d=0;d<4;d++) {
            int nx = x+dxs[d];
            int ny = y+dys[d];
            if (inRange(nx, ny) && !visited[nx][ny] && !alphabet[(int)board[nx][ny]-65]) {
                visited[nx][ny]=true;
                alphabet[(int)board[nx][ny]-65]=true;
                dfs(nx, ny, count+1, alphabet, visited);
                visited[nx][ny]=false;
                alphabet[(int)board[nx][ny]-65]=false;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

}