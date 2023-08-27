import java.util.*;
import java.io.*;

public class Main {

    private static int N, C, house[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        int max=0, min=Integer.MAX_VALUE;
        for (int i=0;i<N;i++) {
            house[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int answer = -1;
        int start=1, end = house[N-1]-house[0];
        while (start<=end) {
            int mid = (start+end)/2;
            int wifi = install(mid);
            if (wifi>=C) {
                // 너무 좁은 간격으로 설치
                start=mid+1;
                answer=mid;
            } else {
                // 너무 넓은 간격으로 설치
                end = mid-1;
            }
        }
        System.out.println(start-1);
    }  

    private static int install(int distance) {
        int result=1, cur=0;
        for (int i=1;i<N;i++) {
            if (house[i]>=house[cur]+distance) {
                cur=i;
                result++;
            }
        }
        return result;
    }
}