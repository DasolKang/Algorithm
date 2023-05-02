package DoIt_Java;

import java.util.Scanner;

public class baekjoon_11720 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String number = scanner.next();
        scanner.close();
        char[] numberArr=number.toCharArray();
        int answer=0;
        for (int i=0;i<N;i++) {
            answer+=numberArr[i]-'0';
        }
    
        System.out.print(answer);
        
    }
}