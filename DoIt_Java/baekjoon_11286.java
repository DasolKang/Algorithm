package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_11286 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs=Math.abs(o1);
            int second_abs=Math.abs(o2);
            if (first_abs==second_abs) {
                return o1>o2?1:-1;
            }
            return first_abs-second_abs; //양수면 o1우선 음수면 o2 우선
        });

        for (int i=0;i<N;i++) {
            int command = Integer.parseInt(br.readLine());
            if (command==0) {
                if (pQueue.isEmpty()) System.out.println(0);
                else System.out.println(pQueue.poll());
            } else pQueue.add(command);
        }

    }
}
