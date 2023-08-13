import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case=1;test_case<=T;test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int compare = (1<<N)-1;
            sb.append("#").append(test_case).append(" ");
            if ((M & compare)==compare) 
                sb.append("ON");
            else sb.append("OFF");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}