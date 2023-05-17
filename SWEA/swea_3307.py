import sys, copy

input=sys.stdin.readline

def solution(index, sequence, length):
    global N, answer
    if (length>answer):
        answer=length
    for i in range(index, N):
        if (array[i]>sequence[-1]):
            temp=copy.deepcopy(sequence)
            temp.append(array[i])
            solution(i+1, temp, length+1)

T=int(input())
for test_case in range(1, T+1):
    N=int(input())
    array = list(map(int, input().split()))
    answer=0
    solution(0, [0], 0)
    print("#{} {}".format(test_case, answer))