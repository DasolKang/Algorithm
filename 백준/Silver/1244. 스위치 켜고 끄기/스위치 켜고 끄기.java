import java.util.*;
import java.io.*;
/*
 * 1. summary: 문제 해석
 * 		남학생 : 자신의 번호의 배수 번호들의 스위치 상태 변경
 * 		여학생 : 자신의 번호 기준 좌우대칭&같은 상태인 스위치 상태 변경
 * 
 * 2. strategy: 풀이전략
 * 3. note: 주의할 사항(특이사항)
 * 		스위치 정보는 한 줄에 20개씩 출력한다
 * 		21번째 스위치는 두번째줄에 출력
 */

public class Main {

	static int[] switches;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer= new StringTokenizer(br.readLine());
		switches = new int[N];
		for (int i=0;i<N;i++) {
			switches[i]= Integer.parseInt(tokenizer.nextToken());
		}
		
		int studentNum = Integer.parseInt(br.readLine());
		for (int i=0;i<studentNum;i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(tokenizer.nextToken());
			int switchNum = Integer.parseInt(tokenizer.nextToken());
			pushSwitch(N, gender, switchNum);
		}
		
		for(int i=1;i<N+1;i++) {
			System.out.print(switches[i-1]+" ");
			if (i%20==0) System.out.println();
		}
		
	}
	
	static void pushSwitch(int N, int gender, int switchNum) {
		if (gender==1) {
			// 남학생 -> 자신 + 자신의 배수 스위치 상태 변경
			for (int i=switchNum-1;i<N;i+=switchNum) {
				switches[i]=(switches[i]+1)%2;
			}
		} else if (gender==2) {
			// 여학생 -> 자신 기준 좌우대칭&값이 같은 스위치 상태 변경
			switchNum--;
			switches[switchNum] = (switches[switchNum]+1)%2;
			for (int i=1;i<=switchNum;i++) {
				if (isPoss(switchNum, i, N)) {
					switches[switchNum-i] = (switches[switchNum-i]+1)%2;
					switches[switchNum+i] = (switches[switchNum+i]+1)%2;
				} else break;
			}
		}
	}
	
	static boolean isPoss(int switchNum, int i, int N) {
		return switchNum-i>=0 && switchNum+i<N && switches[switchNum-i]==switches[switchNum+i];
	}

}