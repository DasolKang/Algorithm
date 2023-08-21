import java.util.*;
import java.io.*;

public class Main {

	private static final int A = 300; // A 버튼은 5분
	private static final int B = 60; // B 버튼은 1분
	private static final int C = 10; // C 버튼은 10초
	private static int T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 요리 시간이 초로 주어진다
		
		// 버튼 조작을 최소로 하기 위해서는 가능한 시간이 큰 버튼을 많이 눌러야 한다.
		int[] answer = getButton();
		if (answer[0]==-1) {
			// 3개의 버튼으로 요리를 완료할 수 없다면 -1 출력
			System.out.println(-1);
		} else {
			// 3개의 버튼으로 요리 완료할 수 있을 때 버튼을 누르는 횟수 출력
			for (int i=0;i<3;i++) {
				System.out.print(answer[i]+" ");
			}
		}
		
	}
	
	private static int[] getButton() {
		int[] answer = new int[3]; // 정답 배열 (A버튼, B버튼, C버튼)
		for (int a=T/300;a>=0;a--) {
			// A버튼을 누를 수 있는 최대 횟수는 T/300
			for (int b=(T-300*a)/60;b>=0;b--) {
				// B버튼을 누를 수 있는 최대 횟수는 T-300*a(A버튼을 누른 횟수)
				int rest = T-300*a-60*b; // A버튼과 B버튼 누르고 남은 시간
				if (rest%10==0) {
					// 남은 시간을 C버튼으로 처리할 수 있다면 정답
					answer[0]=a;
					answer[1]=b;
					answer[2]=rest/10;
					return answer; // 최대횟수부터 탐색했으므로 더이상 탐색할 필요 없다.
				} else {
					// 남은 시간을 C버튼으로 처리할 수 없을 때
					answer[0]=-1;
				}
			}
		}
		return answer;
	}

}