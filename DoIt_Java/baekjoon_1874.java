package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_1874 {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A[] = new int[N];
        for (int i=0;i<N;i++) {
            A[i]=scanner.nextInt();
        }
        scanner.close();

        Stack<Integer> stack = new Stack<>();
        int num=1;
        boolean flag=true;
        StringBuffer bf = new StringBuffer();
        for (int i=0;i<N;i++) {
            int temp=A[i];
            if (temp>=num) {
                while (temp>=num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n=stack.pop();
                if (n>temp) {
                    System.out.println("No");
                    flag=false;
                    break;
                } else bf.append("-\n");
            }
        }
        if (flag) System.out.println(bf.toString());
    }
}
