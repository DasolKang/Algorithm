import java.util.*;

class Solution {
    
    private final int[] dxs = {-1, 0, 1, 0};
    private final int[] dys = {0, 1, 0, -1};
    private int N, M;
    private char[][] myBoard;
    
    public int solution(String[] board) {
        setBoard(board);
        int answer = -1;
        int[] location = findFirstLocation();
        int[][] visited = new int[N][M];
        for (int i=0;i<N;i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[location[0]][location[1]]=0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(location);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d=0;d<4;d++) {
                int nx = cur[0]+dxs[d], ny=cur[1]+dys[d];
                while (inRange(nx, ny) && myBoard[nx][ny]!='D') {
                    // 범위안에 있고 장애물 만나지 않으면 미끄러짐
                    nx += dxs[d];
                    ny += dys[d];
                } 
                // 가능한 끝까지 미끄러졌을 경우
                nx-=dxs[d];
                ny-=dys[d];
                if (myBoard[nx][ny]=='G') {
                    return visited[cur[0]][cur[1]]+1;
                }
                if (visited[nx][ny]==-1 || visited[nx][ny]>visited[cur[0]][cur[1]]+1) {
                    visited[nx][ny] = visited[cur[0]][cur[1]]+1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return answer;
    }
    
    private boolean inRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
    
    private int[] findFirstLocation() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (myBoard[i][j]=='R') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    private void setBoard(String[] board) {
        N = board.length;
        M = board[0].length();
        myBoard = new char[N][M];
        for (int i=0;i<N;i++) {
            myBoard[i] = board[i].toCharArray();
        }
    }
}