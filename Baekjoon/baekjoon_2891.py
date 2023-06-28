import sys

input=sys.stdin.readline
N, S, R=map(int, input().split())
kayak=[1]*(N+1)
kayak[0]=0
break_kayak=list(map(int, input().split()))
for bk in break_kayak:
    kayak[bk]=0
more_kayak=list(map(int, input().split()))
for mk in more_kayak:
    kayak[mk]+=1

for i in range(1, N+1):
    if (kayak[i]==0):
        if (kayak[i-1]>1):
            kayak[i]=1
            kayak[i-1]-=1
        elif (i!=N and kayak[i+1]>1):
            kayak[i]=1
            kayak[i+1]-=1

answer=0
for i in range(1, N+1):
    if (kayak[i]==0): answer+=1
print(answer)