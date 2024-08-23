import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int N = topping.length;
        int[] toppingNum1 = new int[N];
        int[] toppingNum2 = new int[N];
        Set<Integer> toppingInfo = new HashSet<>();
        for (int i=0;i<N;i++) {
            toppingInfo.add(topping[i]);
            toppingNum1[i] = toppingInfo.size();
        }
        toppingInfo = new HashSet<>();
        for (int i=N-1;i>=0;i--) {
            toppingInfo.add(topping[i]);
            toppingNum2[i] = toppingInfo.size();
        }
        int result = 0;
        for (int i=0;i<N-1;i++) {
            if (toppingNum1[i] == toppingNum2[i+1]) result++;
        }
        return result;
    }
}