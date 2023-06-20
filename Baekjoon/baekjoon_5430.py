import sys
from collections import deque

input=sys.stdin.readline

def input_(str_input):
    str_input=str_input[1:-2]
    if (str_input):
        return deque(list(map(int, str_input.split(","))))
    else:
        return deque()

T=int(input())
for _ in range(T):
    p=input().strip()
    n=int(input())
    array=input_(input())
    p=p.replace("RR", "")
    flag, isReverse=False, False
    for command in p:
        if (command=="D"):
            if (not array):
                flag=True
                break
            if (isReverse): array.pop()
            else: array.popleft()
        elif (command=="R"):
            isReverse=not isReverse
    if (flag): print("error")
    else:
        if (isReverse): 
            array.reverse()
        print("[", end="")
        print(*array, sep=",", end="")
        print("]")
