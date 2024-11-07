import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] array = new int[elements.length*2];
        for (int i=0;i<elements.length*2;i++) {
            array[i] = elements[i%(elements.length)];
        }
        Set<Integer> already = new HashSet<>();
        int answer = 0;
        for (int i=0;i<elements.length;i++) {
            int sum = 0;
            for (int j=i;j<elements.length+i;j++) {
                sum+=array[j];
                if (!already.contains(sum)) {
                    answer++;
                    already.add(sum);
                }
            }
        }
        return answer;
    }
}