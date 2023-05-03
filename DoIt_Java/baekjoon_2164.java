package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_2164 {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        scanner.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;i<=N;i++) {
            queue.add(i);
        }

        System.out.println(queue);
        while (queue.size()>1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
