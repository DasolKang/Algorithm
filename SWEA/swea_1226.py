import sys
from collections import deque

input=sys.stdin.readline

def find_start_point(board):
    for i in range(16):
        for j in range(16):
            if (board[i][j]==2):
                return [i, j]

def in_range(x, y):
    return 0<=x<16 and 0<=y<16

dxs, dys=[0, 1, 0, -1], [1, 0, -1, 0]
for _ in range(1):
    test_case=int(input())
    board=[list(map(int, input().strip())) for _ in range(16)]
    visited=[[False]*16 for _ in range(16)]
    queue=deque()
    x, y=find_start_point(board)
    queue.append([x, y])
    visited[x][y]=True
    flag=False
    while queue:
        x, y=queue.popleft()
        if (board[x][y]==3):
            flag=True
            break
        for i in range(4):
            nx, ny=x+dxs[i], y+dys[i]
            if (in_range(nx, ny) and board[nx][ny]!=1 and not visited[nx][ny]):
                visited[nx][ny]=True
                queue.append([nx, ny])
    if (flag): print("#{} {}".format(test_case, 1))
    else: print("#{} {}".format(test_case, 0))
    

