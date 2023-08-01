import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int swcnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] state = new int[swcnt+1];
		for (int i = 1; i <= swcnt; i++) {
			state[i] = Integer.parseInt(st.nextToken());
		}
		
		int stcnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < stcnt; i++) {
			st = new StringTokenizer(br.readLine());
			int stud = Integer.parseInt(st.nextToken());	// 학생 성별
			int num = Integer.parseInt(st.nextToken());
			switch (stud) {
				case 1:
					for (int j = num; j <= swcnt; j+=num) {
						state[j] = ~state[j] + 2;
					}
					break;
				case 2:
					int ln = num - 1, rn = num + 1;
					state[num] = ~state[num] + 2;
					while (ln > 0 && rn <= swcnt && state[ln] == state[rn]) {
						state[ln] = ~state[ln] + 2;
						state[rn] = ~state[rn] + 2;
						ln --;
						rn ++;
					}
					break;
			}
		}
		
		int idx = 1;
		while (idx <= swcnt) {
			if (idx > 1 && idx % 20 == 1) {
				System.out.println();
			}
			System.out.print(state[idx] + " ");
			idx++;
		}
				
	}

}
