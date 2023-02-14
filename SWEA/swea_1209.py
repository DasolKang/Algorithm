import sys

input=sys.stdin.readline

for test_case in range(1, 11):
    testNumber=int(input())
    board=[list(map(int, input().split())) for _ in range(100)]
    result=-1
    up, down=0,0
    for i in range(100):
        row, col=0,0
        for j in range(100):
            row+=board[i][j]
            col+=board[j][i]
            if (i==j):
                down+=board[i][j]
                up+=board[100-i-1][j]
        result=max(result, max(row, col))
    result=max(result, max(up, down))
    print("#{} {}".format(test_case, result))
