import java.util.*;
import java.io.*;

public class Main {

	static int N, M, answer[];
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		answer = new int[M];
		permutation(0, new boolean[N+1]);

	}
	
	public static void permutation(int index, boolean[] visited) {
		if (index == M) {
			for (int i=0;i<M;i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
			return ;
		}
		for (int i=1;i<=N;i++) {
			if (! visited[i]) {
				answer[index]=i;
				visited[i]=true;
				permutation(index+1, visited);
				visited[i]=false;
			}
		}
	}
}