import java.util.*;

class Solution {
    
    private int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        permutation(k, 0, dungeons, new boolean[dungeons.length]);
        return answer;
    }
    
    private void permutation(int k, int cnt, int[][] dungeons, boolean[] visited) {
        answer = Math.max(answer, cnt);
        if (k==0) return ;
        
        for (int i=0;i<dungeons.length;i++) {
            if (visited[i]) continue;
            if (k>=dungeons[i][0]) {
                visited[i] = true;
                permutation(k-dungeons[i][1], cnt+1, dungeons, visited);
            }
            visited[i] = false;
        }
    }
    
}