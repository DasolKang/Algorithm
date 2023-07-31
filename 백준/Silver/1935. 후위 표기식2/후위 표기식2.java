import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] alphaInfo = new double[65];
		char[] input_= br.readLine().toCharArray();
		for (int i=0;i<N;i++) {
			alphaInfo[i]=Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for (char c : input_) {
			if ((int)c>=65 && (int)c<91) {
				stack.add(alphaInfo[(int)c-65]);
			}
			else {
				if (c=='+') {
					stack.add(stack.pop()+stack.pop());
				} else if (c=='-') {
					double a = stack.pop();
					stack.add(stack.pop()-a);
				} else if (c=='*') {
					stack.add(stack.pop()*stack.pop());
				} else if (c=='/') {
					double a = stack.pop();
					stack.add(stack.pop()/a);
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}