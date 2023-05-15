import sys

input=sys.stdin.readline

T=int(input())

def solution(index, cur_sum):
    global N, K, answer
    if (cur_sum==K): answer+=1
    if (cur_sum>=K): return
    for i in range(index, N):
        solution(i+1, cur_sum+number[i])

for test_case in range(1, T+1):
    N, K = map(int, input().split())
    number = list(map(int, input().split()))
    answer=0
    solution(0, 0)
    print("#{} {}".format(test_case, answer))
