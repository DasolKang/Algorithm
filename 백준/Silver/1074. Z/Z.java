import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 2^N * 2^N인 배열을 Z모양으로 탐색하고자 한다.
 * N이 주어질 때 r행 c열을 몇 번째로 방문하는지 출력하라
 * 2. strategy: 풀이전략
 * 분할정복으로 Z모양으로 먼저 탐색하며 r, c 만나면 answer에 저장
 * 3. note: 주의할 사항(특이사항)
 * 배열에 Z에 대한 정보를 모두 저장하고자 하면 메모리 초과
 */

public class Main {

    private static int[][] board;
    private static int count = 0, r, c, answer = -1;
    private static int[] dxs = { 0, 0, 1, 1 };
    private static int[] dys = { 0, 1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        Z(N, size, 0, 0);
        System.out.println(answer);
    }

    private static void Z(int N, int size, int sx, int sy) {
        if (size == 2) {
            int num = count * 4;
            for (int d = 0; d < 4; d++) {
                if (sx + dxs[d] == r && sy + dys[d] == c) {
                    answer = num + d;
                    return;
                }
            }
            return;
        }
        if (answer!=-1) return ;
        int half = size / 2;
        if (inRange(sx, sy, half))
            Z(N-1, half, sx, sy);
        else count+=Math.pow(4, N-2);
        if (inRange(sx, sy + half, half))
            Z(N-1, half, sx, sy + half);
        else count+=Math.pow(4, N-2);
        if (inRange(sx + half, sy, half))
            Z(N-1, half, sx + half, sy);
        else count+=Math.pow(4, N-2);
        if (inRange(sx + half, sy + half, half))
            Z(N-1, half, sx + half, sy + half);
        else count+=Math.pow(4, N-2);
    }

    private static boolean inRange(int sx, int sy, int half) {
        return sx <= r && r < sx + half && sy <= c && c < sy + half;
    }

}