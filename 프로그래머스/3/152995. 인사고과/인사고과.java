import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wonho = scores[0];
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        int last = 0;
        for (int[] score : scores) {
            if (wonho[0]+wonho[1] >= score[0]+score[1]) continue;
            if (wonho[0]<score[0] && wonho[1]<score[1]) return -1;
            if (last <= score[1]) {
                last = score[1];
                answer++;
            }
        }
        
        return answer;
    }
}