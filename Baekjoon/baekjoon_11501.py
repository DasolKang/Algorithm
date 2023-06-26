import sys

input=sys.stdin.readline

def get_maxi_benefit(stock_info):
    global N
    maxi_cost, buy_cost, buy_day=0, 0, 0
    benefit=0
    for day in range(N-1, -1, -1):
        if (stock_info[day]>=maxi_cost):
            benefit+=(maxi_cost*buy_day-buy_cost)
            maxi_cost=stock_info[day]
            buy_day=0
            buy_cost=0
        else:
            buy_cost+=stock_info[day]
            buy_day+=1
    benefit+=(maxi_cost*buy_day-buy_cost)
    return benefit

T=int(input())
for _ in range(T):
    N=int(input())
    stock=list(map(int, input().split()))
    print(get_maxi_benefit(stock))
