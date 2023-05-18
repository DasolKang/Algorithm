
T=int(input())

def get_bus_line(bus: list):
    result=[0]*(5001)
    for start, end in bus:
        for i in range(start, end+1):
            result[i]+=1
    return result

for test_case in range(1, T+1):
    N=int(input())
    bus=[list(map(int,input().split())) for _ in range(N)]
    P=int(input())
    station=[int(input()) for _ in range(P)]

    answer=[]
    bus_info=get_bus_line(bus)
    for s in station:
        answer.append(bus_info[s])
    print("#{} {}".format(test_case, " ".join(map(str, answer))))