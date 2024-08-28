import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, nova[], origin[];

	public static void main(String[] args) throws IOException {
		input();
		Arrays.sort(nova);
		Arrays.sort(origin);
		int novaAns = getAnswer(nova, 100);
		int originAns = getAnswer(origin, 360);
		System.out.println(novaAns + " " + originAns);
	}

	public static int getAnswer(int[] attack, int cooltime) {
		int lastAttack = 0, answer = 0, lastSuccess = 0;
		for (int a : attack) {
			if (lastAttack == 0 || a >= lastAttack + cooltime) {
				// 첫 공격이거나 쿨타임이 지났다면
				lastAttack = a;
				if (lastSuccess == 0 || a >= lastSuccess + 90) {
					// 면역상태 아니라면 공격 성공
					lastSuccess = a;
					answer++;
				}
			}
		}
		return answer;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nova = new int[N];
		origin = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nova[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
	}

}