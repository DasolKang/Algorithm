import sys

input=sys.stdin.readline
T=int(input())

for test_case in range(1, T+1):
    N=int(input())
    score=list(map(int, input().split()))
    maxi=sum(score)
    dp=[0]*(maxi+1)
    dp[0]=1
    for s in score:
        for i in range(maxi-s, -1, -1):
            if dp[i]==1: dp[i+s]=1
    print("#{} {}".format(test_case, sum(dp)))