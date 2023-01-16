# 시간초과

import sys

input=sys.stdin.readline

dx=[-1,1,0,0]
dy=[0,0,-1,1]

R, C = map(int, input().split())
cities=[list(map(lambda x: ord(x)-65, input())) for _ in range(R)]
visited=[False for _ in range(26)]
result=0

def travel(x: int, y: int, count: int):
    global result, R, C
    result=max(result, count)

    visited[cities[x][y]]=True
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if (0<=nx<R and 0<=ny<C and not visited[cities[nx][ny]]):
            travel(nx, ny, count+1)
    
    visited[cities[x][y]]=False

travel(0, 0, 1)
print(result)
    
