import java.util.*;
import java.io.*;

class Solution
{	
    static final int BoxCount = 100;
	static int[] boxes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case=1; test_case<=10;test_case++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			boxes = new int[BoxCount];
			for (int i=0;i<BoxCount;i++) {
				boxes[i]=Integer.parseInt(tokenizer.nextToken());
			}
			flat(dump);
			int[] answer= getMaxMinInfo();
			System.out.println("#"+test_case+" "+(answer[2]-answer[0]));
		}

	}
	
	static void flat(int dumpCount) {
		if (dumpCount==0) return ;
		int[] boxInfo = getMaxMinInfo();
		if (boxInfo[2]-boxInfo[0]<=1) return ;
		boxes[boxInfo[3]]--;
		boxes[boxInfo[1]]++;
		flat(dumpCount-1);
	}
	
	static int[] getMaxMinInfo() {
		int[] info = new int[4];
		info[0]=101;
		for (int i=0;i<boxes.length;i++) {
			if (boxes[i]>info[2]) {
				info[2]=boxes[i];
				info[3]=i;
			}
			if (boxes[i]<info[0]) {
				info[0]=boxes[i];
				info[1]=i;
			}
		}
		return info;
	}
}