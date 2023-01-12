# n명의 선수로 이루어진 러시아 팀의 출전순서를 안다
# 실력 레이팅이 큰 선수가 반드시 승리한다
# 우리팀 선수의 순서를 잘 배치하여 최대 승수를 구하라
# 레이팅이 같을 경우 우리 선수가 승리한다

import sys

input=sys.stdin.readline

C=int(input())
for _ in range(C):
    N=int(input())
    russia=list(map(int,input().split()))
    korea=list(map(int, input().split()))
    korea.sort()

    result=0
    for r in russia:
        if (r>max(korea)):
            del(korea[0])
        else:
            for k in korea:
                if (k>=r):
                    result+=1
                    korea.remove(k)
                    break
    print(result)