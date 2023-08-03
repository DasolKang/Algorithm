import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int dnaStrLen = Integer.parseInt(input.split(" ")[0]);
		int pwLen = Integer.parseInt(input.split(" ")[1]);
		
		String dnaStr = br.readLine();
		
		Map<Character, Integer> selectedCnt = new HashMap<>();
		String[] minCntInput = br.readLine().split(" ");
		Map<Character, Integer> minCnt = new HashMap<>();
		
		char[] dna = {'A', 'C', 'G', 'T'};
		for (int i = 0; i < 4; i++) {
			minCnt.put(dna[i], Integer.parseInt(minCntInput[i]));
			selectedCnt.put(dna[i], 0);
		}
		
		int subStrCnt = 0;
		int i = 0;
		
		while (i < dnaStrLen) {
			if (i == 0) {
				for (int j = 0; j < pwLen; j++) {
					char curChar = dnaStr.charAt(j);
					selectedCnt.put(curChar, selectedCnt.get(curChar)+1);
				}
				i = pwLen;
			} else {
				char frontChar = dnaStr.charAt(i-pwLen);
				char rearChar = dnaStr.charAt(i);
				selectedCnt.put(frontChar, selectedCnt.get(frontChar)-1);
				selectedCnt.put(rearChar, selectedCnt.get(rearChar)+1);
				i++;
			}
			
			boolean validPW = true;
			for (int j = 0; j < 4; j++) {
				if (selectedCnt.get(dna[j]) < minCnt.get(dna[j])) {
					validPW = false;
					break;
				}
			}
			if (validPW) {
				subStrCnt++;
			}
		}
		
		System.out.println(subStrCnt);
		
	}

}