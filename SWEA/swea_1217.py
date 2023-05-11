import sys

input=sys.stdin.readline
T=10

def solution(count):
    global N
    if (count==1): return N
    return N*solution(count-1)

for _ in range(T):
    test_case = int(input())
    N, M = map(int, input().split())
    answer=solution(M)
    print("#{} {}".format(test_case, answer))
