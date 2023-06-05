import sys

input=sys.stdin.readline
N=int(input())
board=[list(input().strip()) for _ in range(N)]

def get_poss_num(array):
    global N
    result=0
    cur_num=0
    for i in range(N):
        if (array[i]=="."):
            cur_num+=1
        else:
            if (cur_num>=2):result+=1
            cur_num=0
    if (cur_num>=2): result+=1
    return result

answer=0
for i in range(N):
    answer+=get_poss_num(board[i])
print(answer, end=" ")

answer=0
for j in range(N):
    temp=[]
    for i in range(N):
        temp.append(board[i][j])
    answer+=get_poss_num(temp)
print(answer)

