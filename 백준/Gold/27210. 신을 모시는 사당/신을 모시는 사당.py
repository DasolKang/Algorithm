import sys

input=sys.stdin.readline

N=int(input())
temple = list(map(int, input().split()))
ahaLeft=[]
ahaRight=[]
for i in temple:
    if (i==1):
        ahaLeft.append(1)
        ahaRight.append(-1)
    elif (i==2):
        ahaLeft.append(-1)
        ahaRight.append(1)

dp1=[0 for _ in range(N)]
dp2=[0 for _ in range(N)]
for i in range(N):
    dp1[i]=max(dp1[i], dp1[i-1]+ahaLeft[i])
    dp2[i]=max(dp2[i], dp2[i-1]+ahaRight[i])

print(max(max(dp1), max(dp2)))
