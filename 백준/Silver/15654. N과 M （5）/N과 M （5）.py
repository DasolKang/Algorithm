import sys

input=sys.stdin.readline
N,M=map(int,input().split())
num=list(map(int,input().split()))
num.sort()
visit=[False]*N
res=[]

def backtracking(depth):
    if depth==M:
        print(' '.join(str(i) for i in res))
    for i in range(N):
        if not visit[i]:
            res.append(num[i])
            visit[i]=True
            backtracking(depth+1)
            res.pop()
            visit[i]=False

backtracking(0)