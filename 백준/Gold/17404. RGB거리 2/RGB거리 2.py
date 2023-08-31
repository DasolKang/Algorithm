import sys
input = sys.stdin.readline

n=int(input())
cost=[list(map(int,input().split())) for _ in range(n)]
result, inf=1e9, 1e9

for c in range(3):
    dp=[[0]*3 for _ in range(n)]
    for i in range(3):
        if i==c:
            dp[0][i]=cost[0][i]
        else:
            dp[0][i]=inf
    for i in range(1,n):
        dp[i][0]=cost[i][0]+min(dp[i-1][1], dp[i-1][2])
        dp[i][1]=cost[i][1]+min(dp[i-1][0], dp[i-1][2])
        dp[i][2]=cost[i][2]+min(dp[i-1][0], dp[i-1][1])
    for i in range(3):
        if i!=c:
            result=min(result, dp[-1][i])
print(result)