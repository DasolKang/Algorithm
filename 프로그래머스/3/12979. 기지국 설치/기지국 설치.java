class Solution {
    public int solution(int n, int[] stations, int w) {
        int before = 1;
        int answer = 0;
        for (int s:stations) {
            int start = s - w;
            if (start > before) {
                answer += getNeedStation(before, start - 1, w);
            }
            before = s + w +1;
        }
        
        if (before <= n)
            answer+=getNeedStation(before, n, w);
        return answer;
    }
    
    private int getNeedStation(int a, int b, int w) {
        // 필요한 기지국 수를 계산
        int dist = b - a + 1;
        int coverage = 2 * w + 1;

        if (dist <= 0) {
            return 0; // 커버할 구간이 없는 경우
        }

        return (int) Math.ceil((double) dist / coverage); // 필요한 기지국 수 계산
    }
}