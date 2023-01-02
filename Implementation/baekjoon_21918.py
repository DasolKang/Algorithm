# 전구는 켜져있는 상태인 1, 꺼져있는 상태인 0 중 하나를 가진다
# 명령어 1 [i, x] : i번 전구를 x로 변경
# 명령어 2 [l, r] : l번 전구부터 r번 전구까지 상태를 변경
# 명령어 3 [l, r] : l번 전구부터 r번 전구까지 전구를 끈다
# 명령어 4 [l, r] : l번 전구부터 r번 전구까지 전구를 킨다.
# 주어진 명령을 모두 다 수행한 후의 전구의 상태를 출력하라

import sys

input = sys.stdin.readline
bulbNum, commandNum = map(int,input().split())
bulb = list(map(int,input().split()))

def command1(i, x):
    bulb[i-1]=x

def command2(l, r):
    for i in range(l-1, r):
        bulb[i]=int(not bulb[i])

def command3(l, r):
    for i in range(l-1, r):
        bulb[i]=0

def command4(l, r):
    for i in range(l-1, r):
        bulb[i]=1

for _ in range(commandNum):
    command, l, r = map(int,input().split())
    if (command==1): command1(l, r)
    elif (command==2): command2(l, r)
    elif (command==3): command3(l, r)
    elif (command==4): command4(l, r)
print(bulb)


