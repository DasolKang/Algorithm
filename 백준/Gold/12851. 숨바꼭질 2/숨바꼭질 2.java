import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int minTime = Integer.MAX_VALUE;
        int answer = 0;
        int[] visited = new int[100001];
        visited[N]=1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                // 동생을 찾았을 때
                if (visited[cur]-1<minTime) {
                    // 더 최적의 경로 찾았을 때
                    minTime = visited[cur]-1;
                    answer = 1;
                } else if (visited[cur]-1==minTime){
                    answer++;
                }
                continue ;
            }
            if (minTime!=Integer.MAX_VALUE && visited[cur]>minTime) {
                continue;
            }
            int[] jump = {-1, 1, cur};
            for (int step : jump) {
                int next = cur+step;
                if ((next>=0 && next<=100000 && (visited[next]==0 || visited[next]>=visited[cur]+1))) {
                    visited[next]=visited[cur]+1;
                    queue.add(next);
                }
            }
        }
        System.out.println(minTime);
        System.out.println(answer);
    }
}