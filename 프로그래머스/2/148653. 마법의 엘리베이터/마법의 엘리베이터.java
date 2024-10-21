import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{storey, 0});
        
        while (!queue.isEmpty()) {
            int[] curInfo = queue.poll();
            
            if (curInfo[0]<10) {
                answer = Math.min(answer, curInfo[1]+curInfo[0]);
                answer = Math.min(answer, curInfo[1]+(10-curInfo[0])+1);
                continue;
            } 
            
            int units = curInfo[0]%10;
            if (units==0) {
                queue.add(new int[]{curInfo[0]/10, curInfo[1]});
            } else {
                queue.add(new int[]{curInfo[0]/10, curInfo[1]+units});
                queue.add(new int[]{curInfo[0]/10+1, curInfo[1]+(10-units)});
            }
        }
        return answer;
    }
}