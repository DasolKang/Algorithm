import sys, copy

input=sys.stdin.readline
R, C=map(int, input().split())
board=[list(input().strip()) for _ in range(R)]

def countSea(x, y):
    global R, C
    count=0
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if (nx<0 or nx>=R or ny<0 or ny>=C): count+=1
        elif (0<=nx<R and 0<=ny<C and board[nx][ny]=='.'): count+=1
    return count

def printReduceMap():
    global R, C
    minX, maxX, minY, maxY=R, 0, C, 0
    for i in range(R):
        for j in range(C):
            if (newBoard[i][j]=='X'):
                minX=min(minX, i)
                maxX=max(maxX, i)
                minY=min(minY, j)
                maxY=max(maxY, j)
    for i in range(minX, maxX+1):
        for j in range(minY, maxY+1):
            print(newBoard[i][j], end='')
        print()

newBoard=copy.deepcopy(board)
for i in range(R):
    for j in range(C):
        if (board[i][j]=='X' and countSea(i, j)>=3):
            newBoard[i][j]='.'
printReduceMap()