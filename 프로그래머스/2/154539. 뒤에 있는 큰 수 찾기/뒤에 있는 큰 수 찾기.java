class Solution {
    public int[] solution(int[] numbers) {
        int[] dp = new int[numbers.length];
        int[] answer = new int[numbers.length];
        answer[numbers.length - 1] = -1;
        dp[numbers.length - 1] = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i + 1] > numbers[i]) {
                dp[i] = i + 1;
                answer[i] = numbers[i + 1];
            } else {
                int j = dp[i + 1];
                while (j != -1) {
                    if (numbers[j] > numbers[i]) {
                        break;
                    } else {
                        j = dp[j];
                    }
                }
                answer[i] = (j == -1) ? -1 : numbers[j];
                dp[i] = (j == -1) ? -1 : j;
            }
        }
        return answer;
    }
}