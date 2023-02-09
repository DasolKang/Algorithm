import sys

input=sys.stdin.readline

def getGoodView(i: int) -> int:
    global N
    if (i<2): maxi=max(building[i+1], building[i+2])
    elif (i>=N-2): maxi=max(building[i-2], building[i-1])
    else: maxi=max(building[i-2], building[i-1], building[i+1], building[i+2])
    
    if maxi<=building[i]: return building[i]-maxi
    else: return 0


for test_case in range(1, 11):
    N=int(input())
    building=list(map(int, input().split()))
    result=0
    for i in range(N):
        result+=getGoodView(i)
    print("#{} {}".format(test_case, result))
