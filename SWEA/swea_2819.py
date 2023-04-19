import sys

input=sys.stdin.readline
T=int(input())
dxs, dys=[-1, 0, 1, 0], [0, 1, 0, -1]

def in_range(x, y):
    return 0<=x<4 and 0<=y<4

def recursion(x, y, curString, depth):
    global answer
    if (depth==7):
        if (curString not in visited):
            answer+=1
            visited.add(curString)
        return
    for i in range(4):
        nx, ny=x+dxs[i], y+dys[i]
        if (in_range(nx, ny)):
            recursion(nx, ny, curString+str(board[nx][ny]), depth+1)

visited=set()
answer=0
for test_case in range(1, T+1):
    board=[list(map(int, input().split())) for _ in range(4)]
    answer=0
    visited=set()
    for i in range(4):
        for j in range(4):
            recursion(i, j, "", 0)
    print("#{} {}".format(test_case, answer))