# 도시락을 데우는 데 전자레인지가 하나밖에 없다
# 한 번의 하나의 도시락만 데울 수 있다 (i번째 mi시간)
# 도시락이 데워지면 사람들은 바로 먹기 시작한다. (ei시간)
# 데우는 순서를 알맞게 정하여 점심 먹는데 걸리는 최소 시간을 구하라 
# 한 사람이 먹을 때 도시락을 데울 수 있다

import sys

input=sys.stdin.readline
C=int(input())
for _ in range(C):
    N=int(input())
    heatTime=list(map(int,input().split()))
    eatTime=list(map(int,input().split()))
    lunch=[]
    for i in range(N):
        temp=[heatTime[i], eatTime[i]]
        lunch.append(temp)
    
    lunch.sort(key=lambda x : (-x[1],x[0]))
    result=lunch[0][0]
    for i in range(1, N):
        result+=lunch[i][0]
        lunch[i][0]+=lunch[i-1][0]
    print(lunch)
    for i in range(N):
        eatTime=lunch[i][0]+lunch[i][1]
        if (eatTime>result):
            result+=(eatTime-result)
    print(result)



