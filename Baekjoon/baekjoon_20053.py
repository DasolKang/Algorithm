# 주어진 N개의 정수 중 최솟값과 최댓값을 구하라

import sys

input=sys.stdin.readline
testNum=int(input())
for _ in range(testNum):
    N=int(input())
    number=list(map(int,input().split()))
    print(min(number), max(number))