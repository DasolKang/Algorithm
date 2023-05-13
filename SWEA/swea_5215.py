import sys, copy

input=sys.stdin.readline
T=int(input())

def solution(index, yummy, calories):
    global N, L, answer
    if (calories>L): return
    answer=max(answer, yummy)
    for i in range(index, N):
        if (calories+ingredients[i][1]<=L):
            solution(i+1, yummy+ingredients[i][0], calories+ingredients[i][1])


for test_case in range(1, T+1):
    N, L = map(int, input().split())
    ingredients = [list(map(int, input().split())) for _ in range(N)]
    answer=0
    solution(0, 0, 0)
    print("#{} {}".format(test_case, answer))