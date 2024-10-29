import java.util.*; 

class Solution {
    
    private int N, M;
    private int[][] board;
    private boolean[][] visited;
    private int[] dxs = {-1, 0, 1, 0}, dys = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        init(maps);
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (board[i][j]>0 && !visited[i][j]) {
                    System.out.println(i+" "+j);
                    visited[i][j] = true;
                    result.add(bfs(i, j));
                }
            }
        }
        if (result.size()==0) return new int[]{-1};
        result.sort((a, b)->a-b);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        int result = board[i][j];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0;d<4;d++) {
                int nx = cur[0]+dxs[d];
                int ny = cur[1]+dys[d];
                if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny]>0) {
                    visited[nx][ny] = true;
                    result+=board[nx][ny];
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return result;
    }
    
    private boolean inRange(int x, int y) {
        return 0<=x && x<N && 0<=y && y<M;
    }
    
    
    private void init(String[] maps) {
        N = maps.length; M = maps[0].length();
        board = new int[N][M];
        
        for (int i=0;i<N;i++) {
            String temp = maps[i];
            for (int j=0;j<M;j++) {
                char cur = temp.charAt(j);
                if (cur=='X') board[i][j] = -1;
                else board[i][j] = (int) cur - '0';
            }
        }
        visited = new boolean[N][M];
    }
}