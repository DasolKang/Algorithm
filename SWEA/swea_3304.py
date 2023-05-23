import sys

input=sys.stdin.readline

T=int(input())
for test_case in range(1, T+1):
    str1, str2 = map(str, input().split())
    size1, size2 = len(str1), len(str2)

    # dp[i][j]
    # 첫 문자열 i인덱스까지와 두번째 문자열 j인덱스까지의 공통부분수열 길이
    dp=[[0]*(size2+1) for _ in range(size1+1)]
    for i in range(size1):
        for j in range(size2):
            if str1[i]==str2[j]:
                dp[i+1][j+1]=dp[i][j]+1
            else:
                dp[i+1][j+1]=max(dp[i][j+1], dp[i+1][j])

    answer=dp[size1][size2]
    print(*dp, sep="\n")
    print("#{} {}".format(test_case, answer))

