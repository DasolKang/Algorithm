import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		for (int i=0;i<N+1;i++) graph[i]=new ArrayList<>();
		
		int[] indegree = new int[N+1];
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			indegree[B]++;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i=1;i<N+1;i++) { 
			if (indegree[i]==0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(" ");
			for (int nextNode : graph[node]) {
				indegree[nextNode]--;
				if (indegree[nextNode]==0) queue.offer(nextNode);
			}
		}
		System.out.println(sb.toString());
	}
}