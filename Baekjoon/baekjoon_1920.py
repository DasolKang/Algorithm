import sys

input=sys.stdin.readline

N=int(input())
number=list(map(int, input().split()))
number.sort()

M=int(input())
search=list(map(int, input().split()))
for s in search:
    start, end = 0, N
    flag=False
    while(start<=end):
        mid=(start+end)//2
        if (number[mid]==s):
            flag=True
            break
        if (number[mid]>s):
            end=mid-1
        else:
            start=mid+1
    if (flag):print(1)
    else: print(0)