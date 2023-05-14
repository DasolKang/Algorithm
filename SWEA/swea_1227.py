import sys
from collections import deque

input=sys.stdin.readline

def find_start_index():
    global MAX_SIZE
    for i in range(MAX_SIZE):
        for j in range(MAX_SIZE):
            if (board[i][j]==2):
                return [i, j]

def in_range(x, y):
    global MAX_SIZE
    return 0<=x<MAX_SIZE and 0<=y<MAX_SIZE

dxs, dys = [-1,1,0,0], [0,0,-1,1]
MAX_SIZE=100
for _ in range(10):
    test_case = int(input())
    board=[list(map(int, input().strip())) for _ in range(MAX_SIZE)]

    start_x, start_y = find_start_index()
    queue=deque()
    queue.append([start_x, start_y])
    visited=[[False]*MAX_SIZE for _ in range(MAX_SIZE)]
    visited[start_x][start_y]=True
    isPoss=False
    while (queue):
        x, y = queue.popleft()
        if (board[x][y]==3):
            isPoss=True
            break
        for d in range(4):
            nx, ny = x+dxs[d], y+dys[d]
            if (in_range(nx, ny) and not visited[nx][ny] and board[nx][ny]!=1):
                visited[nx][ny]=True
                queue.append([nx, ny])

    if (isPoss): print("#{} {}".format(test_case, 1))
    else: print("#{} {}".format(test_case, 0))

