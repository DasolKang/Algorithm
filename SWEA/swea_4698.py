
T=int(input())

def get_prime():
    dp=[True]*1000001
    dp[1]=False
    for i in range(2, 1001):
        for j in range(i+i, 1000001, i):
            dp[j]=False

    result=set()
    for i in range(2, 1000001):
        if (dp[i]): result.add(i)
    return result

def is_contain(total_num, sub_num):
    return str(sub_num) in str(total_num)


prime = get_prime()
for test_case in range(1, T+1):
    D, A, B=map(int, input().split())
    answer=0
    for p in prime:
        if (A<=p<=B):
            if (is_contain(p, D)): answer+=1
    print("#{} {}".format(test_case, answer))