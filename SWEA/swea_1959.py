import sys

input=sys.stdin.readline
T=int(input())
for test_case in range(1, T+1):
    N, M=map(int, input().split())
    A=list(map(int, input().split()))
    B=list(map(int, input().split()))
    if (len(A)>len(B)): A,B=B,A
    min_size=len(A)

    answer=0
    for i in range(len(B)-min_size+1):
        result=0
        for j in range(min_size):
            result+=(A[j]*B[i+j])
        answer=max(answer, result)
    print("#{} {}".format(test_case, answer))