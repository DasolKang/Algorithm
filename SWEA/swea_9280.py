from collections import deque

T=int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())
    parking_cost = [int(input()) for _ in range(n)]
    car_weight = [int(input()) for _ in range(m)]

    answer=0
    parking_info=dict()
    poss_parking=[True]*n
    waiting = deque()
    for time in range(2*m):
        car = int(input())
        if (car<0):
            car=-car
            parking_num = parking_info[car]
            answer+=(parking_cost[parking_num]*car_weight[car-1])
            poss_parking[parking_num]=True
            del(parking_info[car])
            if (waiting):
                poss_parking[parking_num]=False
                wait_car = waiting.popleft()
                parking_info[wait_car]=[parking_num]
        else:
            if (True not in poss_parking):
                waiting.append(car)
            else:
                for p in range(n):
                    if poss_parking[p]:
                        poss_parking[p]=False
                        parking_info[car]=[p]
                        break
    print("#{} {}".format(test_case, answer))