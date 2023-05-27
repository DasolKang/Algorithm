import sys

sys.setrecursionlimit(10000)
input=sys.stdin.readline

def is_palindrome(start, end):
    if dp[start][end]!=-1: return dp[start][end]
    if (start==end):
        dp[start][end]=1
        return dp[start][end]
    if (number[start]!=number[end]):
        dp[start][end]=0
        return dp[start][end]
    if (start+1==end):
        dp[start][end]=1
        return dp[start][end]
    if (is_palindrome(start+1, end-1)):
        dp[start][end]=1
        return dp[start][end]

N=int(input())
number=list(map(str, input().split()))
M=int(input())
dp=[[-1]*2001 for _ in range(2001)]
for _ in range(M):
    start, end = map(int, input().split())
    start-=1; end-=1
    if (is_palindrome(start, end)): print(1)
    else: print(0)