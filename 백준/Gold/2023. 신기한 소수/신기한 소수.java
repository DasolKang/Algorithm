import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        getSpecialPrim(0, "");
        System.out.print(sb);
    }

    private static void getSpecialPrim(int index, String curNum) {
        if (index == N) {
            // N자리의 수 다 뽑았을 때
            sb.append(curNum).append("\n");
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (index == 0 && (i == 0 || (i > 3 && i % 2 == 0))) continue;
            if (index != 0 && i % 2 == 0) continue;
            String nextNum = curNum + String.valueOf(i);
            if (isPrime(Integer.parseInt(nextNum))) {
                getSpecialPrim(index+1, nextNum);
            }
        }
    }

    private static boolean isPrime(int N) {
        if (N == 1) return false;
        if (N <= 3) return true;
        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

}