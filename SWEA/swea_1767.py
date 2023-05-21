import sys, copy

input=sys.stdin.readline

T=int(input())

def in_range(x, y):
    global N
    return 0<=x<N and 0<=y<N

def dfs(node_index: int, wire: int, poss_num: int, visit: list):
    global answer, node_num, max_possible
    if (node_index==node_num):
        if (poss_num>max_possible):
            max_possible=poss_num
            answer=wire
        elif (poss_num==max_possible):
            answer=min(answer, wire)
        return
    if (poss_num+node_num-node_index<max_possible): return
    x, y = node[node_index][0], node[node_index][1]
    for d in range(4):
        wire_length=0
        impossible=False
        nx, ny = x, y
        new_visited=copy.deepcopy(visit)
        while (True):
            nx, ny = nx+dxs[d], ny+dys[d]
            if (not in_range(nx, ny)): break
            if (board[nx][ny]==1 or new_visited[nx][ny]):
                impossible=True
                break
            new_visited[nx][ny]=True
            wire_length+=1
        if (not impossible):
            dfs(node_index+1, wire+wire_length, poss_num+1, new_visited)
    dfs(node_index+1, wire, poss_num, copy.deepcopy(visit))

dxs, dys=[-1, 1, 0, 0], [0, 0, -1, 1]
for test_case in range(1, T+1):
    N=int(input())
    board=[list(map(int, input().split())) for _ in range(N)]
    visited=[[False]*N for _ in range(N)]
    node=[]
    node_num=0
    for i in range(1, N-1):
        for j in range(1, N-1):
            if board[i][j]==1:
                node_num+=1
                visited[i][j]=True
                node.append([i,j])
    answer=1e10
    max_possible=0
    dfs(0, 0, 0, visited)
    print("#{} {}".format(test_case, answer))

