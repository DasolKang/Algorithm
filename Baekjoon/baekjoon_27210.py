# 도넛처럼 연결된 행성의 구역의 수를 구해라
# 0에서 왼쪽으로 이동 시 (0, M-1) 위로 이동시 (N-1, 0)
# 0은 비어있는 것이며 1은 숲으로 막혀있는 것이다

import sys
from collections import deque

input=sys.stdin.readline
dx=[-1,1,0,0]
dy=[0,0,-1,1]
N, M=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(N)]
visit=[[False]*M for _ in range(N)]

def bfs(i, j):
    queue=deque()
    queue.append([i,j])
    while (queue):
        x, y = queue.popleft()
        for d in range(4):
            nx = (x+dx[d])%N
            ny = (y+dy[d])%M
            if (board[nx][ny]==0 and not visit[nx][ny]):
                visit[nx][ny]=True
                queue.append([nx,ny])

zero=[]
result=0
for i in range(N):
    for j in range(M):
        if (board[i][j]==0):
            if (not visit[i][j]):
                visit[i][j]=True
                result+=1
                bfs(i, j)

print(result)