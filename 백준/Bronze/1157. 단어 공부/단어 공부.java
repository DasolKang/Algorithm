import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.toUpperCase();
        int[] count = new int[26];
        int max = 0;
        char result = '?';
        for (char c : input.toCharArray()) {
            int curAlpha = ((int) c)-65;
            count[curAlpha]++;
            if (count[curAlpha] == max) {
                result = '?';
            } else if (count[curAlpha] > max) {
                max = count[curAlpha];
                result = c;
            }
        }
        System.out.println(result);
    }
}