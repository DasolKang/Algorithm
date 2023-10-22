import heapq

N=int(input())
card=[]
for _ in range(N):
    heapq.heappush(card, int(input()))
res=0

while(len(card)!=1):
    n1=heapq.heappop(card)
    n2=heapq.heappop(card)
    mixCard=n1+n2
    res+=mixCard
    heapq.heappush(card, mixCard)
    
print(res)