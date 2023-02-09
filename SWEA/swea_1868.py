import sys

input=sys.stdin.readline
T=int(input())
dx=[-1,-1,-1,0,0,1,1,1]
dy=[-1,0,1,-1,1,-1,0,1]

def getNumberBoard(x: int, y: int):
    global R, C
    for i in range(8):
        nx=x+dx[i]
        ny=y+dy[i]
        if (0<=nx<R and 0<=ny<C):
            if (board[nx][ny]!="*"):
                if (board[nx][ny]=="."): board[nx][ny]=1
                else:
                    board[nx][ny]+=1

def openNumber(x: int, y: int):
    global R, C
    for i in range(8):
        nx=x+dx[i]
        ny=y+dy[i]
        if (0<=nx<R and 0<=ny<C and not visited[nx][ny]): 
            visited[nx][ny]=True
            if (board[nx][ny]==0):
                openNumber(nx, ny)

def countClick():
    global R, C
    count=0
    for i in range(R):
        for j in range(C):
            if board[i][j]==0 and not visited[i][j]:
                visited[i][j]=True
                count+=1
                openNumber(i, j)
    print(*board, sep="\n")
    for temp in visited:
        count+=temp.count(False)
    print(*visited, sep="\n")
    return count  



for test_case in range(1, T+1):
    R=int(input())
    board=[list(input().strip()) for _ in range(R)]
    C=len(board[0])
    visited=[[False]*C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if (board[i][j]=="."): board[i][j]=0
            if (board[i][j]=='*'):
                visited[i][j]=True
                getNumberBoard(i, j)
    print("#{} {}".format(test_case, countClick()))