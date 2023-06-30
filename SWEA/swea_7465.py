import sys

input=sys.stdin.readline

def find_parent(x):
    if (parent[x]==x): return x
    parent[x]=find_parent(parent[x])
    return parent[x]

def union(x, y):
    x_parent=find_parent(x)
    y_parent=find_parent(y)
    if (x_parent<y_parent): parent[y_parent]=x_parent
    else: parent[x_parent]=y_parent

T=int(input())
for test_case in range(1, T+1):
    N, M=map(int, input().split())
    parent=[i for i in range(N+1)]
    for _ in range(M):
        a, b=map(int, input().split())
        union(a, b)
    answer=0
    for i in range(1, N+1):
        if (parent[i]==i): answer+=1
    print(parent)
    print("#{} {}".format(test_case, answer))