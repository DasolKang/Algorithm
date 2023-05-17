import sys

input=sys.stdin.readline

T=int(input())
for test_case in range(1, T+1):
    N=int(input())
    input_arr = list(map(int, input().split()))
    input_arr.insert(0, 0)

    dp=[1]*(N+1) #dp[i] : i번인덱스까지의 최장 부분수열의 길이
    for i in range(1, N+1):
        for j in range(i):
            if (input_arr[j]<input_arr[i]):
                dp[i]=max(dp[i], dp[j]+1)

    print("#{} {}".format(test_case, max(dp[N])-1))