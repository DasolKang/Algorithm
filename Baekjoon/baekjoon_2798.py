import sys

input=sys.stdin.readline
N, M = map(int, input().split())
card = list(map(int, input().split()))
result=[]

def solution(selectNum: int, index: int, total: int):
    global card, result, M
    if (total > M): return
    if (selectNum==3):
        result.append(total)
        return
    for i in range(index, N):
        total+=card[i]
        solution(selectNum+1, index+1, total)
        total-=card[i]

solution(0, 0, 0)
print(max(result))