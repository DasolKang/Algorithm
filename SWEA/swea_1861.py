import sys

input=sys.stdin.readline
T=int(input())
dxs, dys=[-1, 0, 1, 0], [0, 1, 0, -1]

def in_range(x, y):
    global N
    return 0<=x<N and 0<=y<N

def recursion(x, y, nx, ny, move_num):
    global answer
    if (move_num>answer[1] 
        or (move_num==answer[1] and board[x][y]<answer[0])): 
        answer=[board[x][y], move_num]
        print(answer)
    for i in range(4):
        nnx, nny=nx+dxs[i], ny+dys[i]
        if (in_range(nnx, nny) and board[nnx][nny]==board[nx][ny]+1):
            recursion(x, y, nnx, nny, move_num+1)

N=0
answer=[0, 0]
for test_case in range(1, T+1):
    N=int(input())
    board=[list(map(int, input().split())) for _ in range(N)]
    answer=[0, 0]
    for i in range(N):
        for j in range(N):
            recursion(i, j, i, j, 1)
    print("#{} {} {}".format(test_case, answer[0], answer[1]))