import sys

input = sys.stdin.readline

dx=[0,0,1]
dy=[-1,1,0]

def amIBuy(i: int) -> bool:
    global size
    curX, curY = 0, i
    while (curX<size-1):
        for d in range(3):
            nx=curX+dx[d]
            ny=curY+dy[d]
            if (0<=nx<size and 0<=ny<size and board[nx][ny]!=0 and not visited[nx][ny]):
                print("다음 >> [",nx,", ", ny,"]")
                visited[nx][ny]=True
                curX, curY=nx, ny
                break
    print("x가 ", i,"일 때 마지막 >> ", board[curX][curY])
    if (board[curX][curY]==2): return True
    else: return False


for test_case in range(1, 11):
    N=int(input())
    board=[]
    board.append(list(map(int, input().split())))
    size=len(board[0])
    for _ in range(size-1):
        board.append(list(map(int, input().split())))

    for i in range(size):
        visited=[[False]*size for _ in range(size)]
        if (board[0][i]==1 and amIBuy(i)):
            visited[0][i]=True
            print("#{} {}".format(N, i))
            break
