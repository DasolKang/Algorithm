import sys

input=sys.stdin.readline
N, X=map(int, input().split())
visitNum=list(map(int, input().split()))
if (max(visitNum)==0): print("SAD")
else:
    dp=[0]*(N+1)
    for i in range(X):
        dp[X]+=visitNum[i]

    for i in range(X+1, N+1):
        dp[i]=dp[i-1]-visitNum[i-X-1]+visitNum[i-1]

    else:
        print(dp)
        print(max(dp))
        print(dp.count(max(dp)))
    