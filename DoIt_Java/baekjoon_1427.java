package DoIt_Java;

import java.util.*;
import java.io.*;

public class baekjoon_1427 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        int size=inputString.length();
        int[] array = new int[size];
        for (int i=0;i<size;i++) {
            array[i]=Integer.parseInt(inputString.substring(i, i+1));
        }

        for (int i=0;i<size-1;i++) {
            int maxi=array[i];
            int changeIndex=i;
            for (int j=i+1;j<size;j++) {
                //최댓값찾기
                if (array[j]>maxi) {
                    maxi=array[j];
                    changeIndex=j;
                }
            }
            if (changeIndex!=i) {
                int temp=array[i];
                array[i]=array[changeIndex];
                array[changeIndex]=temp;
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<size;i++) {
            buffer.append(array[i]);
        }
        System.out.println(buffer.toString());
    }

}
