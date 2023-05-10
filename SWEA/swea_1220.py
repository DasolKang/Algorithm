T=10

def get_deadlock_num(array):
    global N
    count, i=0, 0
    while (i<N):
        if (array[i]==1):
            for j in range(i+1, N):
                i = j
                if (array[j]==2):
                    count+=1
                    break
        i+=1
    return count


for test_case in range(1, T+1):
    N=int(input())
    # 1은 N극 2는 S극
    board=[list(map(int, input().split())) for _ in range(N)]
    answer=0
    for i in range(N):
        column=[b[i] for b in board]
        answer+=get_deadlock_num(column)
    print("#{} {}".format(test_case, answer))