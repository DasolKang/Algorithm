import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> belt = new ArrayDeque<>();
        for (int i=1;i<=order.length;i++) {
            belt.add(i);
        }
        Stack<Integer> sub = new Stack<>();
        
        for (int o : order) {
            if (sub.size()>0 && sub.peek().intValue()==o) {
                answer++;
                sub.pop();
                continue;
            }
            if (belt.size()>0) {
                int curBox=belt.poll();
                while (belt.size()!=0 && curBox!=o) {
                    sub.add(curBox);
                    curBox = belt.poll();
                }
                if (curBox == o) {
                    answer++;
                    continue;
                }
            }

            if (sub.peek()==o) {
                answer++;
                sub.pop();
            } else {
                break;
            }
        }
        return answer;
    }
}