import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] result = new int[n];
        Arrays.fill(result, s/n);
        int num = s%n;
        if (num==s) return new int[]{-1};
        if (num!=0) {
            int index = n-1;
            while (num>0) {
                result[index--]++;
                num--;
            }
        }
        return result;
    }
}