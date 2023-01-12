# n명의 학생을 둘씩 짝지을 때 둘은 서로 친구여야한다
# n과 친구 쌍인 m이 주어질 때 친구끼리 짝지을 수 있는 경우의 수를 출력하라

import sys

input=sys.stdin.readline
testNum=int(input())

def makePair(student):
    global friend, result
    num=len(student)
    if (num==2):
        if ([student[0], student[1]] in friend): result+=1
    else :
        for i in range(1, num):
            if ([student[0], student[i]] in friend):
                temp1=student[0]; temp2=student[i]
                del(student[0]); del(student[i-1])
                makePair(student)
                student.insert(0, temp1); student.insert(i, temp2)


for _ in range(testNum):
    n, m = map(int,input().split())
    friendTemp = list(map(int,input().split()))
    student=[i for i in range(n)]
    friend=[]
    for i in range(0,len(friendTemp),2):
        friend.append([friendTemp[i], friendTemp[i+1]])
    result=0
    makePair(student)
    print(result)

