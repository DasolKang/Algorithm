import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		int ansSize=0;
		List<Integer> answer=new ArrayList<>();
		for (int i=1;i<=N;i++) {
			List<Integer> temp = getNumList(N, i);
			if (temp.size()>ansSize) {
				ansSize=temp.size();
				answer = temp;
			}
		}
		System.out.println(ansSize);
		for (Integer num:answer) {
			System.out.print(num+" ");
		}
	}
	
	public static List<Integer> getNumList(int i, int j) {
		List<Integer> result  = new ArrayList<>();
		result.add(i); result.add(j);
		int start=i, second=j;
		while (start-second>=0) {
			result.add(start-second);
			int temp=start;
			start=second;
			second=temp-second;
			if (second<0) break;
		}
		return result;
	}
}