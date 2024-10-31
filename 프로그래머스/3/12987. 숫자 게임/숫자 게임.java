import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        Arrays.sort(A); Arrays.sort(B);
        int answer = 0;
        int start = 0, end=N-1;
        for (int i=N-1;i>=0;i--) {
            if (A[i]<B[end]) {
                answer++;
                end--;
            } else {
                start++;
            }
        }
        
        return answer;
    }

}