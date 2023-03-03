import sys
from collections import deque

input=sys.stdin.readline

def isLast(array: list):
    if (max(array)<10): return True
    else: return False

def getPassword(array: list):
    queue=deque(array)
    flag=False
    while (0 not in queue):
        for i in range(1, 6):
            temp=queue.popleft()
            if (temp-i<0): queue.append(0)
            else: queue.append(temp-i)
            if 0 in queue: 
                flag=True
                break
        if (flag): break
    return list(queue)

while True:
    test_case=int(input())
    array=list(map(int, input().split()))
    result=getPassword(array)
    print("#", test_case, sep="", end=" ")
    print(*result)
    if (isLast(array)): break