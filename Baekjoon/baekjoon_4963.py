import sys
from collections import deque

input = sys.stdin.readline

dx=[-1,-1,-1,0,0,1,1,1]
dy=[-1,0,1,-1,1,-1,0,1]

def bfs(x, y):
    global w, h
    queue=deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if (0<=nx<h and 0<=ny<w and board[nx][ny]==1 and not visited[nx][ny]):
                visited[nx][ny]=True
                queue.append([nx, ny])
    
while True:
    w, h = map(int, input().split())
    if (w==0 and h==0): break
    result=0
    board=[list(map(int, input().split())) for _ in range(h)]
    visited=[[0]*w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if (board[i][j]==1 and not visited[i][j]):
                visited[i][j]=True
                bfs(i, j)
                result+=1
    print(result)