import sys

input=sys.stdin.readline
N=int(input())
number=dict()
input_num=list(map(int, input().split()))
for num in input_num:
    if num in number:
        number[num]=number[num]+1
    else:
        number[num]=1

M=int(input())
check_num=list(map(int, input().split()))
answer=[]
for c_n in check_num:
    if c_n in number:
        answer.append(number[c_n])
    else:
        answer.append(0)
print(*answer)

