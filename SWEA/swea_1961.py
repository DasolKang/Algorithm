import sys

input=sys.stdin.readline
T=int(input())

def turn_right(arr: list) -> list:
    global N
    turn_result=[]
    for i in range(N):
        temp=[]
        for j in range(N-1, -1, -1):
            temp.append(arr[j][i])
        turn_result.append(temp)
    return turn_result

for test_case in range(1, T+1):
    N=int(input())
    array=[list(map(int, input().split())) for _ in range(N)]
    print("#", test_case, sep="")
    turn_arr=list(array)
    answer=[[0]*3 for _ in range(N)]
    for i in range(3):
        turn_arr=turn_right(turn_arr)
        for j in range(N):
            answer[j][i]=int("".join(str(n) for n in turn_arr[j]))
    print("#", test_case, sep="")
    for i in range(N):
        print(*answer[i])
    