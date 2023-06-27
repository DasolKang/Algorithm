import sys, math

input=sys.stdin.readline

C=int(input())
for _ in range(C):
    input_=list(map(int, input().split()))
    average=sum(input_[1:])
    average/=input_[0]
    good=0
    for i in range(1, input_[0]+1):
        if (input_[i]>average): good+=1
    answer=good/input_[0]
    answer=math.floor(answer*100000+0.5)
    print("{:.3f}%".format(answer/1000))
