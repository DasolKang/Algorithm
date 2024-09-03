class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int w=1;w<=Math.sqrt(yellow);w++) {
            if (yellow%w!=0) continue;
            int h = yellow/w;
            if (getBrownNum(w, h) == brown) {
                w+=2; h+=2;
                answer[0] = Math.max(w, h);
                answer[1] = Math.min(w, h);
                break;
            }
        }       
        return answer;
    }
    
    private int getBrownNum(int w, int h) {
        return 2*w+2*h+4;
    }
}