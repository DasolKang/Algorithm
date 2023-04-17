import sys
from collections import deque

input=sys.stdin.readline
T=int(input())
dxs, dys=[-1, 0, 1, 0], [0, 1, 0, -1]

def in_range(N, x, y):
    return 0<=x<N and 0<=y<N

for test_case in range(1, T+1):
    N=int(input())
    board=[list(map(int, input().strip())) for _ in range(N)]
    queue=deque()
    queue.append([0, 0])
    visited=[[-1]*N for _ in range(N)]
    visited[0][0]=0
    while queue:
        x, y=queue.popleft()
        for i in range(4):
            nx, ny=x+dxs[i], y+dys[i]
            if (in_range(N, nx, ny) and (visited[nx][ny]==-1 or visited[nx][ny]>visited[x][y]+board[nx][ny])):
                visited[nx][ny]=visited[x][y]+board[nx][ny]
                queue.append([nx, ny])
    print("#{} {}".format(test_case, visited[N-1][N-1]))