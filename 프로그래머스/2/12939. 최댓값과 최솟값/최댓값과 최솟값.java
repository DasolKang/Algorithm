class Solution {
    public String solution(String s) {
        String[] temp = s.split(" ");
        int maxi = Integer.MAX_VALUE * (-1), mini = Integer.MAX_VALUE;
        int[] numbers = new int[temp.length];
        for (int i=0;i<temp.length;i++) {
            numbers[i] = Integer.valueOf(temp[i]);
            if (numbers[i]>maxi) maxi = numbers[i];
            if (numbers[i]<mini) mini = numbers[i];
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(mini).append(" ").append(maxi);
        return sb.toString();
    }
    
}