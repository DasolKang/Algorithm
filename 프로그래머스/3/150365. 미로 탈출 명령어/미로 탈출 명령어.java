import java.util.*;

class Solution {
    
    private int[] dxs = {1, 0, 0, -1}, dys = {0, -1, 1, 0};
    private String[] dir = {"d", "l", "r", "u"};
    private int N, M, R, C;
    private boolean already = false;
    private String answer;
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;

        // k로 도착 가능 여부를 먼저 확인
        if (!canArrival(x, y, k)) return "impossible";
        
        answer = "impossible";  // 초기값을 "impossible"로 설정
        dfs(x, y, "", k);
        return answer;
    }
    
    private void dfs(int x, int y, String track, int k) {
        // 목표 지점에 도착하고 k가 0이라면 성공적인 경로
        if (x == R && y == C && k == 0) {
            answer = track;
            already = true;
            return;
        }
        if (k <= 0 || already) return;  // 더 이상 탐색할 수 없는 경우 종료
        
        for (int d = 0; d < 4; d++) {
            if (already) return;  // 이미 경로를 찾았으면 종료
            
            int nx = x + dxs[d], ny = y + dys[d];
            
            // 좌표가 범위를 벗어나지 않고, 이동 가능하다면 다음 단계로
            if (inRange(nx, ny) && canArrival(nx, ny, k - 1)) {
                dfs(nx, ny, track + dir[d], k - 1);
            }
        }
    }
    
    // 남은 이동 횟수로 목표 지점에 도착 가능한지 판단
    private boolean canArrival(int x, int y, int k) {
        int dist = getDistance(x, y, R, C);
        return dist <= k && (k - dist) % 2 == 0;
    }
    
    // 맨해튼 거리 계산
    private int getDistance(int x, int y, int tx, int ty) {
        return Math.abs(tx - x) + Math.abs(ty - y);
    }
    
    // 좌표가 격자 범위 내에 있는지 확인
    private boolean inRange(int x, int y) {
        return 0 < x && x <= N && 0 < y && y <= M;
    }
}
