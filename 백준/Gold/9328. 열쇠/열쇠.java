import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    private final static int[] dxs = {-1, 0, 1, 0}, dys = {0, 1, 0, -1};
    private static int H, W, keys;
    private static char[][] board;
    private static boolean[][] visited;
    private static boolean[][] ansVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            init(br);
            int answer = 0;
            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(0, 0));
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dxs[d];
                    int ny = cur.y + dys[d];
                    if (canGo(nx, ny) && !visited[nx][ny]) {
                        if ((int) board[nx][ny] >= 65 && (int) board[nx][ny] < 91
                                && !check(board[nx][ny])) {
                            // 열 수 없는 문일 때
                            continue;
                        }
                        visited[nx][ny] = true;
                        if (board[nx][ny] == '$' && !ansVisited[nx][ny]) {
                            ansVisited[nx][ny] = true;
                            answer++;
                        } else if ((int) board[nx][ny] >= 97 && (int) board[nx][ny] < 123) {
                            // 열쇠일 때
                            int move = board[nx][ny] - 'a';
                            if ((keys & 1 << move) == 0) {
                                // 처음 방문한 열쇠라면
                                keys = keys ^ (1 << move);
                                visited = new boolean[H + 2][W + 2];
                            }
                        }
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean canGo(int nx, int ny) {
        if (nx < 0 || nx >= H + 2 || ny < 0 || ny >= W + 2) return false;
        return board[nx][ny] != '*';
    }

    private static boolean check(char door) {
        int move = door - 'A';
        return ((keys & 1 << move) != 0);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new char[H + 2][W + 2];
        for (int i = 0; i < H + 2; i++) {
            Arrays.fill(board[i], '.');
        }

        for (int i = 1; i < H + 1; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j < W + 1; j++) {
                board[i][j] = temp[j - 1];
            }
        }

        visited = new boolean[H + 2][W + 2];
        ansVisited = new boolean[H + 2][W + 2];

        keys = 0;
        char[] inputKey = br.readLine().toCharArray();
        for (char k : inputKey) {
            int move = k - 'a';
            keys = keys ^ (1 << move);
        }
    }
}