import sys

input=sys.stdin.readline

T=int(input())

def dfs(node, distance):
    global answer
    visited[node]=True
    answer=max(answer, distance)
    for next_node in graph[node]:
        if (visited[next_node]==0):
            dfs(next_node, distance+1)
            visited[next_node]=False

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    graph=[[] for _ in range(N+1)]
    for _ in range(M):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)

    answer=0
    for i in range(1, N+1):
        visited=[False]*(N+1)
        visited[i]=True
        dfs(i, 1)

    print("#{} {}".format(test_case, answer))
