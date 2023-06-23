import sys

input=sys.stdin.readline
N, M=map(int, input().split())
lecture=list(map(int, input().split()))

def is_poss(bluelay_size):
    global N, M
    temp=0
    lay_num=1
    for i in range(N):
        if (lecture[i]>bluelay_size):
            return False
        if (temp+lecture[i]>bluelay_size):
            temp=lecture[i]
            lay_num+=1
        else: temp+=lecture[i]
    if (lay_num<=M): return True
    elif (lay_num>M): return False

start, end=1, 1000000000
answer=1000000000
while (start<=end):
    lay_size=(start+end)//2
    check=is_poss(lay_size)
    if (check):
        answer=min(answer, lay_size)
        end=lay_size-1
    else:
        start=lay_size+1
print(answer)