import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] dxs = {-1,0,1,0};
        int[] dys = {0,-1,0,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] board = new int[N][M];
        for (int i=0;i<N;i++) {
            String inputString = br.readLine();
            for (int j=0;j<M;j++) {
                board[i][j]=Integer.parseInt(inputString.substring(j, j+1));
            }
        }

        int[][] visited=new int[N][M];
        visited[0][0]=1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp=queue.poll();
            int x=temp[0], y=temp[1];
            for (int d=0;d<4;d++) {
                int nx = x+dxs[d], ny=y+dys[d];
                if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if (visited[nx][ny]!=0) continue;
                if (board[nx][ny]==0) continue;
                visited[nx][ny]=visited[x][y]+1;
                queue.add(new int[]{nx, ny});
            }
        }
        System.out.println(visited[N-1][M-1]);

    }
    
}