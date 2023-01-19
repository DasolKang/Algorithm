import sys

input=sys.stdin.readline
N=int(input())
array=list(map(int,input().split()))
result=0
start=0
cur=array[0]; nextIs=0; isChange=False
while (start<N):
    left=0; right=0; aha=0
    for end in range(start, N):
        if (not isChange and array[end]!=cur): 
            isChange=True
            nextIs=end
        if (array[end]==1): left+=1
        elif (array[end]==2): right+=1
        aha=abs(left-right)
        if (aha<1): break
        if (result<aha): result=aha
    if (not isChange): break
    start=nextIs
    cur=array[nextIs]
    isChange=False
print(result)
