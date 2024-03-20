import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    private final static int[] dxs = {-1, 0, 1, 0};
    private final static int[] dys = {0, 1, 0, -1};
    private static int N, M, board[][], targetX, targetY, visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(targetX, targetY));
        visited[targetX][targetY] = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dxs[d];
                int ny = cur.y + dys[d];
                if (inRange(nx, ny) && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                    visited[i][j] = 0;
                } else if (board[i][j] == 0) {
                    visited[i][j] = 0;
                }
            }
        }
    }
}