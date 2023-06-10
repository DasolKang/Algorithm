import sys

input=sys.stdin.readline

N, M=map(int, input().split())
board, dp=[[0]*(M+1) for _ in range(N+1)], [[0]*(M+1) for _ in range(N+1)]

for i in range(1, N+1):
    temp=list(map(int, input().split()))
    for j in range(1, M+1):
        board[i][j]=temp[j-1]
        dp[i][j]=board[i][j]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]

print(dp)
K=int(input())
for _ in range(K):
    i, j, x, y = map(int, input().split())
    print(dp[x][y]-dp[x][j-1]-dp[i-1][y]+dp[i-1][j-1])

