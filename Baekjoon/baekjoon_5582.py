import sys

input=sys.stdin.readline
string1=input().strip()
string2=input().strip()
n, m=len(string1), len(string2)
dp=[[0]*(m+1) for _ in range(n+1)]
result=0

for i in range(1, n+1):
    for j in range(1, m+1):
        if (string1[i-1]==string2[j-1]):
            dp[i][j]=dp[i-1][j-1]+1
            result=max(result, dp[i][j])

print(*dp, sep="\n")
print(result)
