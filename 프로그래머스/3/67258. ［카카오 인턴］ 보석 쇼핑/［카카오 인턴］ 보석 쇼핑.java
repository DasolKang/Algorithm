import java.util.*;

class Solution {
    private Set<String> purchase;
    private Map<String, Integer> duplication;
    private int total;
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        init(gems);
        boolean firstAnswer = true;
        int start = 0, end = 0;
        
        while (end < gems.length) {
            duplication.put(gems[end], duplication.get(gems[end])+1);
            purchase.add(gems[end]);
            
            while (purchase.size()==total) {
                if (firstAnswer || end-start<answer[1]-answer[0]) {
                    answer[0] = start+1;
                    answer[1] = end+1;
                    firstAnswer = false;
                }
                   
                duplication.put(gems[start], duplication.get(gems[start])-1);
                if (duplication.get(gems[start])==0) {
                    purchase.remove(gems[start]);
                }
                start++;
            }
            end++;
        }
        
        return answer;
    }
    
    private void init(String[] gems) {
        purchase = new HashSet<>();
        duplication = new HashMap<>();
        total = 0;
        for (String gem : gems) {
            if (!duplication.containsKey(gem)) {
                duplication.put(gem, 0);
                total++;
            }
        }
    }
}