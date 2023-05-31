import sys

input=sys.stdin.readline

def is_same_rank(gold, silver, bronze):
    if (gold==front_info[0] and silver==front_info[1] and bronze==front_info[2]):
        return True
    return False

def update_info(gold, silver, bronze):
    global front_info
    front_info[0]=gold
    front_info[1]=silver
    front_info[2]=bronze

N, K=map(int, input().split())
country=[list(map(int, input().split())) for _ in range(N)]
country.sort(key=lambda x:(-x[1], -x[2], -x[3]))
front_info=[0, 0, 0]
same_rank=0
rank=0
answer=[0]*(N+1)
for c in country:
    if is_same_rank(c[1], c[2], c[3]):
        same_rank+=1
        answer[c[0]]=rank
    else:
        if (same_rank>0): 
            rank+=same_rank
            same_rank=0
        update_info(c[1], c[2], c[3])
        rank+=1
        answer[c[0]]=rank
    if (c[0]==K):
        print(answer)
        print(answer[K])
        break


# 9 8
# 1 2 1 0
# 2 1 1 0
# 3 1 1 1
# 4 1 1 0
# 5 0 3 2
# 6 0 3 1
# 7 0 1 2
# 8 0 0 1
# 9 0 1 2