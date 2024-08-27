import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> gomgom = new HashSet<>();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			String inputCommand = br.readLine();
			if (inputCommand.equals("ENTER")) {
				// 누군가 입장했을 시
				gomgom = new HashSet<>();
			} else {
				if (!gomgom.contains(inputCommand)) {
					gomgom.add(inputCommand);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}