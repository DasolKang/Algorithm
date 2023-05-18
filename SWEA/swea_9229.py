
T=int(input())

def solution(index, snack_num, cur_weight):
    global N, M, answer
    if (snack_num==2):
        answer=max(answer, cur_weight)
        return
    for i in range(index, N):
        if (cur_weight+snack[i]<=M):
            solution(index+1, snack_num+1, cur_weight+snack[i])

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    snack = list(map(int, input().split()))
    answer=-1
    solution(0, 0, 0)
    print("#{} {}".format(test_case, answer))