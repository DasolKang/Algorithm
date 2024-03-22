import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }
        boolean[] checkConnect = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            checkConnect[find(i)] = true;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (checkConnect[i]) answer++;
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) return false;
        if (parentX < parentY) {
            parents[parentY] = parentX;
        } else {
            parents[parentX] = parentY;
        }
        return true;
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
}