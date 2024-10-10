import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int no, weight;
        
        Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.weight-other.weight;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Node>[] roadInfo = init(n, roads);
        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[destination] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(destination, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.weight < minDist[cur.no]) {
                minDist[cur.no] = cur.weight;
            }
            
            for (Node nextNode : roadInfo[cur.no]) {
                if (minDist[nextNode.no] > cur.weight+nextNode.weight)
                    pq.add(new Node(nextNode.no, nextNode.weight+cur.weight));
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i=0;i<sources.length;i++) {
            if (minDist[sources[i]]==Integer.MAX_VALUE) answer[i]=-1;
            else answer[i] = minDist[sources[i]];
        }
        
        return answer;
    }
    
    private List<Node>[] init(int n, int[][] roads) {
        List<Node>[] result = new ArrayList[n+1];
        for (int i=0;i<=n;i++) {
            result[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            Node node1 = new Node(road[1], 1);
            Node node2 = new Node(road[0], 1);
            result[road[0]].add(node1);
            result[road[1]].add(node2);
        }
        return result;
    }
}