import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder answer = new StringBuilder();
        boolean isTag = false;
        StringBuilder temp = new StringBuilder();
        for (char c : input.toCharArray()) {
            // 태그 일 때 는 그대로
            if (c!='>' && isTag) answer.append(c);
            else if (c=='<') {
                if (temp.length()!=0) {
                    answer.append(temp);
                    temp = new StringBuilder();
                }
                answer.append("<");
                isTag = true;
            }
            else if (c=='>') {
                answer.append(">");
                isTag = false;
            }

            else if (!isTag && c!=' ') {
                // 태그 아닐 때,
                temp.insert(0, c);
            }
            else if (!isTag && c==' ') {
                answer.append(temp).append(" ");
                temp = new StringBuilder();
            }
        }
        if (temp.length()!=0) answer.append(temp);
        System.out.println(answer);
    }
}