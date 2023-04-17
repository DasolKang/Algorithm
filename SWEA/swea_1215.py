import sys

input=sys.stdin.readline
T=10

def is_palindrome(string):
    size=len(string)
    for i in range(size//2):
        if (string[i]!=string[size-i-1]): return False
    return True

def in_range(x, y):
    return 0<=x<8 and 0<=y<8

def poss_string(N, x, y):
    global answer
    startX, startY=x, y
    dxs, dys=[0, 1], [1, 0]
    for i in range(2):
        temp=board[x][y]
        is_complete=True
        for j in range(N-1):
            nx, ny = x+dxs[i], y+dys[i]
            if (not in_range(nx, ny)): 
                is_complete=False
                break
            temp+=board[nx][ny]
            x, y=nx, ny
        x, y=startX, startY
        if (is_complete and is_palindrome(temp)): 
            answer+=1


for test_case in range(1, T+1):
    N=int(input())
    board=[list(input().strip()) for _ in range(8)]
    
    answer=0
    for i in range(8):
        for j in range(8):
            poss_string(N, i, j)
    print("#{} {}".format(test_case, answer))




