from collections import deque
import sys

#input=sys.stdin.readline
N,M=map(int, input().split())
board=[list(input().strip()) for _ in range(N)]
visit=[[[[False] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]

def move(x, y, dx, dy):
    cnt=0
    while board[x + dx][y + dy]!='#' and board[x][y]!='O':
        x+=dx
        y+=dy
        cnt+=1
    return x,y,cnt

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(rx, ry, bx, by):
    queue = deque()
    queue.append((rx, ry, bx, by,1))
    visit[rx][ry][bx][by]=True
    while queue:
        rx,ry,bx,by,count=queue.popleft()
        if count > 10:
            break
        for i in range(4):
            nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = move(bx, by, dx[i], dy[i])
            if board[nbx][nby] != 'O':
                if board[nrx][nry] == 'O':
                    return count
                if nrx == nbx and nry == nby:
                    if rcnt > bcnt:
                        nrx -= dx[i]
                        nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]
                if not visit[nrx][nry][nbx][nby]:
                    visit[nrx][nry][nbx][nby] = True
                    queue.append((nrx, nry, nbx, nby,count+1))
    return -1


for i in range(N):
    for j in range(M):
        if board[i][j]=='R':
            rx,ry = i,j
        if board[i][j]=='B':
            bx,by = i,j

print(bfs(rx,ry,bx,by))