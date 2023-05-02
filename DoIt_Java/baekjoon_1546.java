package DoIt_Java;

import java.util.Scanner;

public class baekjoon_1546 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int[] score = new int[N];
        int maxi=0;
        for (int i=0;i<N;i++) {
            score[i]=scanner.nextInt();
            if (score[i]>maxi) maxi=score[i];
        }
        double total=0.0f;
        for (int i=0;i<N;i++) {
            total+=(score[i]*100.0/maxi);
        }
        System.out.println(total/N);
        scanner.close();
    }

    public double solution() {
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        long sum=0;
        long maxi=0;
        for (int i=0;i<N;i++) {
            int temp=scanner.nextInt();
            sum+=temp;
            if (maxi<temp) maxi=temp;
        }
        scanner.close();
        return sum*100.0/maxi/N;
    }
    
}
