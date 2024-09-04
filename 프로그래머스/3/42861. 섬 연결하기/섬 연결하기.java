import java.util.*;

class Solution {

    static class Node implements Comparable<Node>{
        int no, weight;
        
        public Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public int solution(int n, int[][] costs) {
        // 시작 정점은 0
        List<Node>[] graph = getGraphInfo(n, costs);
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        int[] minValue = new int[n];
        Arrays.fill(minValue, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        
        pQueue.add(new Node(0, 0));
        int answer = 0;
        while (!pQueue.isEmpty()) {
            Node curNode = pQueue.poll();
            
            if (visited[curNode.no]) continue;
            
            visited[curNode.no] = true;
            answer += curNode.weight;
            
            for (Node next : graph[curNode.no]) {
                if (!visited[next.no]) {
                    pQueue.add(next);
                }
            }
        }
        return answer;
    }
    
    private List<Node>[] getGraphInfo(int n, int[][] costs) {
        List<Node>[] result = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            result[i] = new ArrayList<>();
        }
        
        for (int[] c : costs) {
            result[c[0]].add(new Node(c[1], c[2]));
            result[c[1]].add(new Node(c[0], c[2]));
        }
        return result;
    }
}