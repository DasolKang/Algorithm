import sys

input=sys.stdin.readline
S=[0]*21

M=int(input())
for _ in range(M):
    temp=list(map(str, input().split()))
    if (temp[0]=="add"):
        S[int(temp[1])]=1
    elif (temp[0]=="remove"):
        S[int(temp[1])]=0
    elif (temp[0]=="check"):
        print(S[int(temp[1])])
    elif (temp[0]=="toggle"):
        S[int(temp[1])]=(S[int(temp[1])]+1)%2
    elif (temp[0]=="all"):
        S=[1]*21
    elif (temp[0]=="empty"):
        S=[0]*21
