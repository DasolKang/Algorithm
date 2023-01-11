# 두 문자열을 하나의 문자열로 합치는 함수를 만들고자한다
# 함수는 두 문자열의 길이의 합만큼 비용이 발생한다
# n개의 문자열들을 하나로 합칠 때 필요한 최소비용을 구하라

import sys
import heapq

input=sys.stdin.readline
C=int(input())

# 알고리즘 접근방식은 옳으나 코드 에러..
for _ in range(C):
    n=int(input())
    strLength=list(map(int,input().split()))
    strLength.sort()
    result=0

    while strLength:
        size = len(strLength)
        print("size >> ", size, " result >> ", result,"  strLength >> ", strLength)
        if (size==1): break 
        temp=[]
        for i in range(1, size, 2):
            strcat=strLength[i]+strLength[i-1]
            temp.append(strcat)
            result+=strcat
        if (size!=1 and size%2!=0): temp.append(strLength[-1])
        temp.sort()
        strLength=list(temp) 
    print(result)


#우선순위 큐 이용
for _ in range(C):
    n=int(input())
    strLength=list(map(int,input().split()))
    pQueue=[]
    for s in strLength:
        heapq.heappush(pQueue, s)
    result=0
    while len(pQueue)>1:
        temp = heapq.heappop(pQueue)+heapq.heappop(pQueue)
        heapq.heappush(pQueue, temp)
        result+=temp
    print(result)
