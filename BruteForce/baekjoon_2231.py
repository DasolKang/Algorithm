import sys

sys.setrecursionlimit(10**9)
input=sys.stdin.readline
n=int(input())

def getSum(num: int):
    res=num
    while (num>0):
        res+=(num%10)
        num//=10
    return res
    
result=0
numberLen=len(str(n))
startNum=n-9*numberLen
for i in range(startNum, n):
    if (getSum(i)==n):
        result=i
        break

print(result)
