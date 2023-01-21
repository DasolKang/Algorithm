import sys

MAXIMUM=1e10
sys.setrecursionlimit(10**6)
input=sys.stdin.readline
N=int(input())

dp=[0 for _ in range(N+6)]
for i in range(6):
    if (i==3 or i==5): dp[i]=1
    else: dp[i]=MAXIMUM

def sugar(N: int):
    if (dp[N] or N<=5): return dp[N]
    else:
        dp[N]=min(sugar(N-3)+1, sugar(N-5)+1)
        return dp[N]

sugar(N)
if (dp[N]>=MAXIMUM): print(-1)
else: print(dp[N])