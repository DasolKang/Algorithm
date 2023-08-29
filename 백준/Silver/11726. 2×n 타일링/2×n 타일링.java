import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        dp[0]=1; dp[1]=1;
        for (int i=2;i<=n;i++) {
            dp[i]=(dp[i-2]+dp[i-1])%10007;
        }
        System.out.println(dp[n]);
    }
}
