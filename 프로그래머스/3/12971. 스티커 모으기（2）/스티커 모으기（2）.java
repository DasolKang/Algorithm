class Solution {
    public int solution(int sticker[]) {
        if (sticker.length==1) return sticker[0];
        
        int[][] dp1 = new int[2][sticker.length]; // 첫번째 스티커 뜯
        int[][] dp2 = new int[2][sticker.length]; // 첫번째 스티커 안뜯
        
        dp1[0][0] = sticker[0];
        for (int i=1;i<sticker.length;i++) {
            dp1[0][i] = dp1[1][i-1] + sticker[i];
            dp1[1][i] = Math.max(dp1[0][i-1], dp1[1][i-1]);
            dp2[0][i] = dp2[1][i-1] + sticker[i];
            dp2[1][i] = Math.max(dp2[0][i-1], dp2[1][i-1]);
        }
        
        int answer = Math.max(dp1[1][sticker.length-1], dp2[0][sticker.length-1]);
        answer = Math.max(answer, dp2[1][sticker.length-1]);
        return answer;
    }
}