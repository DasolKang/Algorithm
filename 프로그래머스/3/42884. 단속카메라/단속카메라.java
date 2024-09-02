import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {return o1[1]-o2[1];});
        int answer = 1;
        int lastCamera = routes[0][1];
        for (int i=1;i<routes.length;i++) {
            if (routes[i][0] <= lastCamera && lastCamera <= routes[i][1]) {
                // 저번 카메라로 해당 차량 찍을 수 있다면
                continue;
            }
            answer++;
            lastCamera = routes[i][1];
        }
        return answer;
    }
}