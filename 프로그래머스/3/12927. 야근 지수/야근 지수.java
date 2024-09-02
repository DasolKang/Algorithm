import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int w: works) {
            maxHeap.add(w);
        }
        
        for (int i=0;i<n;i++) {
            int maxValue = maxHeap.poll();
            maxValue--;
            maxHeap.add(maxValue);
        }
        
        long answer = 0L;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            if (work>0)
                answer+=work*work;
        }
        return answer;
    }
}