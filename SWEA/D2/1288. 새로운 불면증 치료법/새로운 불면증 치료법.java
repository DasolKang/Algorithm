import java.util.*;
import java.io.*;

class Solution {

    private static final int isAnswer=(1<<10)-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            int bit = 0;
            for (int i=1;;i++) {
                answer++;
                bit = bit | getBit(N*i);
                if (bit == isAnswer) break;
            }
            sb.append("#").append(test_case)
                .append(" ").append(answer*N).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int getBit(int N) {
        int bit = 0;
        while (N>0) {
            bit = bit | (1<< (N%10));
            N/=10;
        }
        return bit;
    }
}