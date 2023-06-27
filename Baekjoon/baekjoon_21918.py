import sys

input=sys.stdin.readline

def command1(i, x):
    bulb[i-1]=x

def command2(l, r):
    for i in range(l-1, r):
        bulb[i]=(bulb[i]+1)%2

def command3(l, r):
    for i in range(l-1, r):
        bulb[i]=0

def command4(l, r):
    for i in range(l-1, r):
        bulb[i]=1

N, M=map(int, input().split())
bulb=list(map(int, input().split()))
for _ in range(M):
    input_=list(map(int, input().split()))
    if (input_[0]==1):
        command1(input_[1], input_[2])
    elif (input_[0]==2):
        command2(input_[1], input_[2])
    elif (input_[0]==3):
        command3(input_[1], input_[2])
    elif (input_[0]==4):
        command4(input_[1], input_[2])
print(*bulb)