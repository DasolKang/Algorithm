import java.util.*;

class Solution {
    
    int index1, index2, index3, total[];
    Boolean impossible = false;
    
    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        if (impossible) return -1;
        int answer = 0;
        long sum1 = getSum(index1, index2);
        long sum2 = getSum(index2, index3);

        while (answer < 2 * (queue1.length + queue2.length)) {
            if (sum1 == sum2) {
                // 두 큐의 합이 같아질 경우
                return answer;
            }
            
            if (index1>=total.length || index2>=total.length || index3>=total.length) {
                break;
            }

            if (sum1 > sum2) {
                // queue1의 합이 queue2보다 클 때 queue1 -> queue2
                sum1-=total[index1];
                sum2+=total[index1];
                total[index3++] = total[index1++];
            } else {
                // queue2의 합이 queue1보다 클 때 queue2 -> queue1
                sum1+=total[index2];
                sum2-=total[index2];
                index2++;
            }
            
            answer++;
        }
        
        return -1;  // 작업 횟수가 최대치를 넘으면 -1 반환
    }
    
    public Long getSum(int idx1, int idx2) {
        long result = 0;
        for (int i=idx1;i<idx2;i++) {
            result+=total[i];
        }
        return result;
    }
    
    public void init(int[] queue1, int[] queue2) {
        total = new int[2*(queue1.length+queue2.length)];
        long sum = 0;
        for (int i=0;i<queue1.length;i++) {
            total[i] = queue1[i];
            sum+=queue1[i];
        }
        
        for (int i=0;i<queue2.length;i++) {
            total[queue1.length+i] = queue2[i];
            sum+=queue2[i];
        }
        
        if (sum%2!=0) impossible=true;
        index2 = queue1.length;
        index3 = queue1.length + queue2.length;
    }
}