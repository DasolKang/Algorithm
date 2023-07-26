import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
	
		int[] afterShuffle = new int[N];
		int[] D = new int[N];
		tokenizer = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			afterShuffle[i]=Integer.parseInt(tokenizer.nextToken());
		}
		tokenizer = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			D[i]=Integer.parseInt(tokenizer.nextToken());
		}
		
		int[] cards = Arrays.copyOf(afterShuffle, N);
		for (int i=0;i<K;i++) {
			cards = beforeShuffle(N, cards, D);
		}
		
		for (int i=0;i<N;i++) {
			System.out.print(cards[i]+" ");
		}
		
	}
	
	static int[] beforeShuffle(int N, int[] curCard, int[] D) {
		int[] temp = new int[N];
		for (int i=0;i<N;i++) {
			temp[D[i]-1]=curCard[i];
		}
		return temp;
	}
 	
}
