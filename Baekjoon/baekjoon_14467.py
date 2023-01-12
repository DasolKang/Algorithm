import sys

input=sys.stdin.readline
N=int(input())
cow=[0]*11
cowLocate=dict()
for _ in range(N):
    num, locate=map(int, input().split())
    if (num in cowLocate):
        if (cowLocate[num]!=locate):
            cow[num]+=1
            cowLocate[num]=locate
    else:
        cowLocate[num]=locate
print(sum(cow))