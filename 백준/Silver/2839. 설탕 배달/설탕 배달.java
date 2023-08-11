import java.util.*;
import java.io.*;

/*
 * 1. summary: 문제 해석
 * 설탕을 Nkg 배달할 때, 봉지를 최소로 들고자한다.
 * 설탕은 3kg 봉지와 5kg 봉지가 있다.
 * 정확하게 Nkg의 설탕을 배달하고자할 때 최소 봉지 수를 구하라
 * 2. strategy: 풀이전략
 * 봉지의 개수를 최소로 하기 위해서는 5kg 봉지를 최대로 드는 것이 유리
 * 5kg의 봉지를 들고난 후 남은 설탕의 무게가 3의 배수가 되도록 구한다.
 * 3. note: 주의할 사항(특이사항)
 * 3kg, 5kg 봉지로 Nkg의 설탕을 배달할 수 없는 경우 -1 출력
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = -1;
		if (N % 5 == 0) {
			answer = (int) N / 5;
		} else {
			for (int i = (int) N / 5; i >= 0; i--) {
				if ((N - 5 * i) % 3 == 0) {
					answer = (int) ((N - 5 * i) / 3) + i;
					break;
				}
			}
		}
		System.out.println(answer);
	}

}