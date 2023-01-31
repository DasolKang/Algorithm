import sys

input=sys.stdin.readline
N=int(input())
drink=list(map(int, input().split()))
drink.sort()
result=drink[-1]
for i in range(N-1):
    print(drink[i]/2)
    result+=(drink[i]/2)
print(result)