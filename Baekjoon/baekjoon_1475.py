import sys

input=sys.stdin.readline
need=list(map(int, input().strip()))
card=dict()

def add_card():
    for i in range(10):
        card[i]=card[i]+1

for i in range(10):
    card[i]=0

answer=0
for n in need:
    if card[n]>0:
        card[n]=card[n]-1
    else:
        if (n==6 and card[9]>0):
            card[9]=card[9]-1
        elif (n==9 and card[6]>0):
            card[6]=card[6]-1
        else:
            answer+=1
            add_card()
            card[n]=card[n]-1
print(answer)