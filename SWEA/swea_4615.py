import sys

input=sys.stdin.readline

def init_board(N: int) -> list:
    result=[[0]*N for _ in range(N)]
    # 1: 흑돌, 2: 백돌
    result[N//2-1][N//2-1]=2
    result[N//2-1][N//2]=1
    result[N//2][N//2-1]=1
    result[N//2][N//2]=2
    return result

def in_range(x: int, y: int) -> bool:
    global N
    return 0<=x<N and 0<=y<N

def change(x: int,  y: int, d: int):
    player=board[x][y]
    nx, ny = x, y
    while (in_range(nx, ny)):
        nx, ny = nx+dxs[d], ny+dys[d]
        if (not in_range(nx, ny) or board[nx][ny]==player or board[nx][ny]==0):
            return
        board[nx][ny]=player

def game(x: int, y: int, player: int):
    for d in range(8):
        nx, ny = x, y
        while (in_range(nx, ny)):
            nx, ny=nx+dxs[d], ny+dys[d]
            if (not in_range(nx, ny) or board[nx][ny]==0): break
            if (board[nx][ny]==player):
                change(nx, ny, (d+4)%8)
                break

T=int(input())
dxs, dys=[-1, -1, -1, 0, 1, 1, 1, 0], [-1, 0, 1, 1, 1, 0, -1, -1]
for test_case in range(1, T+1):
    N, M=map(int, input().split())
    board=init_board(N)

    for _ in range(M):
        y, x, player = map(int, input().split())
        board[x-1][y-1]=player
        game(x-1, y-1, player)
        # print(board)

    answer=[0, 0]
    for i in range(N):
        for j in range(N):
            if (board[i][j]==1): answer[0]+=1
            elif (board[i][j]==2): answer[1]+=1
    print("#{} {} {}".format(test_case, answer[0], answer[1]))
