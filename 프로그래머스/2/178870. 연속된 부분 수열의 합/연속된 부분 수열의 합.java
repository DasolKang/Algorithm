class Solution {
    
    int[] prefixSum, answer;
    
    public int[] solution(int[] sequence, int k) {
        getPrefixSum(sequence);
        answer = new int[]{-1, -1};
        for (int i = 0; i < sequence.length; i++) {
            if (prefixSum[i] == k) {
                answer[0] = 0;
                answer[1] = i;
            } else if (prefixSum[i] > k) {
                int index = getNumber(prefixSum[i] - k);
                if (index != -1 && (answer[0]==-1 || answer[1] - answer[0] > i - index - 1)) {
                    // 존재하고 길이가 더 짧을 때
                    answer[0] = index + 1;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
    
    private int getNumber(int number) {
        int start = 0, end = prefixSum.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (prefixSum[mid] == number)
                return mid;
            if (prefixSum[mid] > number) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private void getPrefixSum(int[] sequence) {
        prefixSum = new int[sequence.length];
        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            prefixSum[i] = sum;
        }
    }
}