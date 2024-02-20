import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            boolean isTop = false;
            int stair = N % H;
            if (stair == 0) {
                isTop = true;
                stair = H;
            }
            int room = N / H;
            if (! isTop) room++;
            System.out.print(stair);
            if (room < 10) System.out.print("0");
            System.out.println(room);
        }

    }
}