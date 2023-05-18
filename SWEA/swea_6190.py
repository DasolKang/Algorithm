T=int(input())

def is_simple_increase(num: int) -> bool:
    num_list=list(map(int, str(num)))
    for i in range(1, len(num_list)):
        if (num_list[i]<num_list[i-1]): return False
    return True

for test_case in range(1, T+1):
    N=int(input())
    answer=-1
    number=list(map(int, input().split()))
    for i in range(N-1):
        for j in range(i+1, N):
            cur_number=number[i]*number[j]
            if (is_simple_increase(cur_number) and cur_number>answer):
                answer=cur_number
    print("#{} {}".format(test_case, answer))