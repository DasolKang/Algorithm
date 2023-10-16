import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static int[][] info, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);

        for (int i=1;i<=N;i++) {
            //i번째 물건까지
            for (int j=1;j<=K;j++) {
                // jkg까지 들었을 때의 최대 가치
                if (j>=info[i][0]) {
                    // 물건 들 수 있을 때
                    dp[i][j]=Math.max(dp[i-1][j], info[i][1]+dp[i-1][j-info[i][0]]);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        info = new int[N+1][2];
        dp = new int[N+1][K+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            info[i][0]=w;
            info[i][1]=v;
        }
    }
}