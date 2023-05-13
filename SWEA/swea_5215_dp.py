import sys

input=sys.stdin.readline

T=int(input())
for test_case in range(1, T+1):
    N, limit = map(int, input().split())
    ingredient = [list(map(int, input().split())) for _ in range(N)]
    ingredient.insert(0, [])
    # dp[i][j] -> i번째 재료까지 j칼로리로 얻을 수 있는 최대 맛
    dp=[[0]*(limit+1) for _ in range(N+1)]

    for i in range(1, N+1):
        for j in range(1, limit+1):
            if (j>=ingredient[i][1]):
                dp[i][j]=max(dp[i-1][j], dp[i-1][j-ingredient[i][1]]+ingredient[i][0])
            else:
                dp[i][j]=dp[i-1][j]

    print("#{} {}".format(test_case, dp[N][limit]))

