import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[] keyLogger = br.readLine().toCharArray();
			List<Character> password = new LinkedList<>();
			ListIterator iter = password.listIterator();
			for (char c : keyLogger) {
				if (c == '<') {
					if (iter.hasPrevious())
						iter.previous();
				} else if (c == '>') {
					if (iter.hasNext())
						iter.next();
				} else if (c == '-') {
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				} else {
					iter.add(c);
				}
			}
			for (char p : password) {
				sb.append(p);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}