import sys

input=sys.stdin.readline
N, M=map(int, input().split())
tree=list(map(int, input().split()))
mini=0; maxi=max(tree)
result=0

def cutTree(H):
    getTree=0
    for t in tree:
        if (t>H):
            getTree+=(t-H)
    return getTree

while (mini<maxi):
    H=(mini+maxi)//2
    getTree=cutTree(H)
    print("최솟값 >> ", mini, "  최댓값 >> ", maxi)
    print("자를 높이 >> ", H)
    print("얻은 나무 >> ", getTree, "  얻어야할 나무 >> ", M)
    if (getTree==M): 
        result=H
        break
    if (getTree>M):
        result=H
        mini=H+1
    else:
        maxi=H
print(result)