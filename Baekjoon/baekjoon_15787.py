import sys

input=sys.stdin.readline
N, M=map(int,input().split())
train=[[0]*20 for _ in range(N)]

def command1(i, x):
    train[i][x]=1

def command2(i, x):
    train[i][x]=0

def command3(t):
    curTrain=train[t]
    for i in range(18, -1, -1):
        if curTrain[i]==1:
            curTrain[i]=0
            curTrain[i+1]=1

def command4(t):
    curTrain=train[t]
    for i in range(1, 20):
        if (curTrain[i]==1):
            curTrain[i]=0
            curTrain[i-1]=1


for _ in range(M):
    command=list(map(int,input().split()))
    if (command[0]==1): command1(command[1]-1, command[2]-1)
    elif (command[0]==2): command2(command[1]-1, command[2]-1)
    elif (command[0]==3): command3(command[1]-1)
    elif (command[0]==4): command4(command[1]-1)

passby=[]
result=0
print(*train, sep="\n")
for t in train:
    if t in passby: continue
    passby.append(t)
    result+=1
print(result)