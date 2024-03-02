import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1000000000;
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[10][N + 1][1 << 10]; // dp[i][j][k] : 길이가 j이고 마지막 숫자가 i이며 0~9까지의 숫자가 모두 등장하는 계단 수의 개수
        for (int i = 1; i <= 9; i++) {
            dp[i][1][1 << i] = 1; // 길이가 1이고 i로 끝나는 계단 수의 개수는 1
        }
        
        for (int j = 2; j <= N; j++) {
            for (int i = 0; i <= 9; i++) {
                for (int k = 0; k < (1 << 10); k++) {
                    if (i - 1 >= 0) {
                        dp[i][j][k | (1 << i)] += dp[i - 1][j - 1][k];
                        dp[i][j][k | (1 << i)] %= MOD;
                    }
                    if (i + 1 <= 9) {
                        dp[i][j][k | (1 << i)] += dp[i + 1][j - 1][k];
                        dp[i][j][k | (1 << i)] %= MOD;
                    }
                }
            }
        }
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[i][N][(1 << 10) - 1]; // 길이가 N이면서 0부터 9까지의 숫자가 모두 등장하는 계단 수의 개수를 모두 더함
            answer %= MOD;
        }
        System.out.println(answer);
    }
}