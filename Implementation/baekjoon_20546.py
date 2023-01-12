import sys

input = sys.stdin.readline
C = int(input())
stock = list(map(int, input().split()))

# 준현이의 경우 : 살수 있다면 최대한 많이 & 팔지 않음
junCost=C
bnp=[0]*14
for i in range(14):
    curStock=stock[i]
    if (curStock <= junCost):
        bnp[i]+=(junCost//curStock)
        junCost%=curStock

# 성민이의 경우 : 3일 이상 상승 시 구매, 하락 시 매수
sungCost=C
timing=[0]*14
isDown=0; isUp=0
for i in range(1, 14):
    # print("성민이 매수 현황 >> ", timing)
    if (stock[i]>stock[i-1]):
        isUp+=1
        isDown=0
    elif (stock[i]<stock[i-1]):
        isDown+=1
        isUp=0
    
    if (isUp>=3):
        sungCost+=(sum(timing)*stock[i])
        timing=[0]*14
        isUp=0
    elif (isDown>=3):
        timing[i]+=(sungCost//stock[i])
        sungCost%=stock[i]
        isDown=0

# print("준성이 매수 현황 >> ", bnp)

jun=junCost+sum(bnp)*stock[-1]
sung=sungCost+sum(timing)*stock[-1]
# print("준성이 이익 >> ", jun,"  성민이 이익 >> ", sung)
if (jun==sung): print("SAMESAME")
elif (jun>sung): print("BNP")
else: print("TIMING")

