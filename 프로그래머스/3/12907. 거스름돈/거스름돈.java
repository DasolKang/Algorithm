class Solution {
    public int solution(int n, int[] money) {
        // dp[i] : i 금액을 만들 수 있는 경우의 수
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for (int m : money) {
            for (int i=m;i<=n;i++) {
                dp[i] += dp[i-m];
            }
        }
        return dp[n];
    }
}