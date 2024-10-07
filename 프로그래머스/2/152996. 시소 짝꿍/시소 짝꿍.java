import java.util.*;

class Solution {
    
    public long solution(int[] weights) {
        long answer = 0L;
        Arrays.sort(weights);
        Map<Double, Long> map = new HashMap<>();

        for (int w : weights) {
            if (map.containsKey(w*1.0)) answer+=map.get(w*1.0);
            if (map.containsKey(w*2.0/3.0)) answer+=map.get(w*2.0/3.0); 
            if (map.containsKey(w*1.0/2.0)) answer+=map.get(w*1.0/2.0); 
            if (map.containsKey(w*3.0/4.0)) answer+=map.get(w*3.0/4.0);
            map.put(w*1.0, map.getOrDefault((w*1.0), 0L)+1);
        }
        
        return answer;
    }
}