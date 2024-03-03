import java.util.*;
import java.io.*;

public class Main {

    private static long T, A[], B[], sumA[], sumB[];
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        getPrefixSum(A, sumA);
        getPrefixSum(B, sumB);
        long answer = 0;
        for (int i = 0; i < sumA.length; i++) {
            long target = T - sumA[i];
            int upper = getUpper(sumB, target);
            int lower = getLower(sumB, target);

            if (upper-lower>0) {
                answer += (upper-lower);
            }
        }
        System.out.println(answer);
    }

    private static int getUpper(long[] arr, long target) {
        int start = 0, end = arr.length - 1;
        int minIndex = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
                minIndex = mid;
            } else {
                start = mid + 1;
            }
        }
        return minIndex;
    }

    private static int getLower(long[] arr, long target) {
        int start = 0, end = arr.length - 1;
        int minIndex = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                minIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minIndex;
    }

    private static void getPrefixSum(long[] origin, long[] sum) {
        int index = 0;
        for (int i = 0; i < origin.length; i++) {
            long s = origin[i];
            sum[index++] = s;
            for (int j = i + 1; j < origin.length; j++) {
                s += origin[j];
                sum[index++] = s;
            }
        }
        Arrays.sort(sum);
    }

    private static void init(BufferedReader br) throws IOException {
        T = Long.parseLong(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        sumA = new long[N * (N + 1) / 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new long[M];
        sumB = new long[M * (M + 1) / 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }
    }
}