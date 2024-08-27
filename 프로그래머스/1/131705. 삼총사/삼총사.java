import java.util.*;

class Solution {
    
    private int answer, student[], result[];
    
    public int solution(int[] number) {
        student = number;
        result = new int[3];
        combination(0, 0);
        return answer;
    }
    
    private void combination(int index, int num) {
        if (index > student.length) return ;
        if (num == 3) {
            int sum = 0;
            for (int i=0;i<3;i++) {
                sum+=result[i];
            }
            if (sum==0) answer++;
            return ;
        }
        for (int i=index;i<student.length;i++) {
            result[num] = student[i];
            combination(i+1, num+1);
        }
    }
    
}