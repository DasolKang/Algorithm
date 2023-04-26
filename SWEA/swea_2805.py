import sys

input=sys.stdin.readline
T=int(input())

for test_case in range(1, T+1):
    N=int(input())
    board=[list(map(int, input().strip())) for _ in range(N)]
    start_index=N//2
    answer=sum(board[start_index])
    cur_size=1
    for i in range(start_index-1, -1, -1):
        temp=sum(board[i])
        for j in range(cur_size):
            temp-=board[i][j]
            temp-=board[i][N-j-1]
        answer+=temp
        cur_size+=1
    cur_size=1
    for i in range(start_index+1, N):
        temp=sum(board[i])
        for j in range(cur_size):
            temp-=board[i][j]
            temp-=board[i][N-j-1]
        answer+=temp
        cur_size+=1
    print("#{} {}".format(test_case, answer))
