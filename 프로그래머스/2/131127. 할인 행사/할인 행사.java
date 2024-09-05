import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> product = init(want, number, discount);
        for (int i=10;i<discount.length;i++) {
            if (check(product)) answer++;
            if (product.containsKey(discount[i-10])) {
                product.put(discount[i-10], product.get(discount[i-10])+1);
            }
            if (product.containsKey(discount[i])) {
                product.put(discount[i], product.get(discount[i])-1);
            }
        }
        if (check(product)) answer++;
        return answer;
    }
    
    private boolean check(Map<String, Integer> product) {
        for (String key : product.keySet()) {
            if (product.get(key)>0) return false;   
        }
        return true;
    }
    
    private Map<String, Integer> init(String[] want, int[] number, String[] discount) {
        Map<String, Integer> result = new HashMap<>();
        for (int i=0;i<want.length;i++) {
            result.put(want[i], number[i]);
        }
        for (int i=0;i<10;i++) {
            if (!result.containsKey(discount[i])) continue;
            result.put(discount[i], result.get(discount[i])-1);
        }
        return result;
    }
}