import sys

input=sys.stdin.readline
board=[list(map(int,input().split())) for _ in range(5)]
mc=[list(map(int,input().split())) for _ in range(5)]

def deleteNum(num: int):
    for i in range(5):
        for j in range(5):
            if board[i][j]==num: 
                board[i][j]=-1
                return

def isBingo():
    bingo=0
    # 가로줄에 대해
    for b in board:
        if (sum(b)==-5): bingo+=1

    # 세로줄에 대해
    for j in range(5):
        temp=0
        for i in range(5):
            temp+=board[i][j]
        if (temp==-5): bingo+=1

    # 대각선
    temp=0
    for i in range(5):
        temp+=board[i][i]
    if (temp==-5): bingo+=1

    temp=0
    for i in range(5):
        temp+=board[i][5-i-1]
    if (temp==-5): bingo+=1

    return bingo

result=0
count=0
for i in range(5):
    for j in range(5):
        count+=1
        deleteNum(mc[i][j])
        print("지운 수 >> ", mc[i][j])
        print(board)
        if (isBingo()>=3): 
            result=count
            break
    if (result!=0): break

print(result)

