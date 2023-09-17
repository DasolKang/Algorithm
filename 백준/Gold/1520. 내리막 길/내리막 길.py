import sys
from collections import deque

sys.setrecursionlimit(10**6)
input=sys.stdin.readline
M,N=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(M)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
visit=[[-1]*N for _ in range(M)]
visit[0][0]=1

def dfs(x,y):
    global board, visit
    cur=board[x][y]
    if x==0 and y==0:
        return 1
    if visit[x][y]==-1:
        visit[x][y]+=1
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<M and 0<=ny<N:
                if board[nx][ny]>cur:
                    visit[x][y]+=dfs(nx,ny)
    return visit[x][y]

print(dfs(M-1,N-1))