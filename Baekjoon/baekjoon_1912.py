import sys

input=sys.stdin.readline
n=int(input())
array=list(map(int, input().split()))
dp=[0 for _ in range(n)]
for i in range(n):
    dp[i]=max(dp[i], dp[i-1]+array[i])

result=max(dp)
if (result==0): print(max(array))
else: print(result)