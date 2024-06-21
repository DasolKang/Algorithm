class Solution {
    
    private static int[] fibo;
    
    public int solution(int n) {
        fibo = new int[100001];
        fibo[1]=1;
        fibo[2]=1;
        return getFibo(n);
    }
    
    private static int getFibo(int n) {
        if (fibo[n]!=0) return fibo[n];
        return fibo[n]=(getFibo(n-1)+getFibo(n-2))%1234567;
    }
}