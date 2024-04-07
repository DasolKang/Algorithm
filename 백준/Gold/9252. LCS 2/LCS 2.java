import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String seq1 = br.readLine();
        String seq2 = br.readLine();

        int[][] arr = calculateLCS(seq1, seq2);

        StringBuilder answer = retrieveLCS(seq1, arr);

        System.out.println(arr[seq2.length()][seq1.length()]);

        if (arr[seq2.length()][seq1.length()] != 0) {
            System.out.println(answer.reverse());
        }
    }

    public static int[][] calculateLCS(String seq1, String seq2) {
        int n = seq1.length();
        int m = seq2.length();
        int[][] arr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (seq1.charAt(j - 1) == seq2.charAt(i - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }

        return arr;
    }

    // LCS를 역추적하여 문자열을 반환하는 메서드
    public static StringBuilder retrieveLCS(String S, int[][] arr) {
        StringBuilder answer = new StringBuilder();
        int x = arr.length - 1;
        int y = arr[0].length - 1;

        while (true) {
            int now = arr[x][y];
            if (now == 0) {
                break;
            }
            if (arr[x - 1][y - 1] == now - 1 && arr[x][y - 1] == now - 1 && arr[x - 1][y] == now - 1) {
                x--;
                y--;
                answer.append(S.charAt(y));
            } else {
                if (now == arr[x - 1][y]) {
                    x--;
                } else {
                    y--;
                }
            }
        }

        return answer;
    }
}