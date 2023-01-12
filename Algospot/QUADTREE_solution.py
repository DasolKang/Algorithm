import sys

input=sys.stdin.readline
C=int(input())

def reverseQuad(quadTree: list):
    global index
    head=quadTree[index]
    index+=1

    if (head=='b' or head=='w'):
        return head
    upperLeft=reverseQuad(quadTree)
    upperRight=reverseQuad(quadTree)
    lowerLeft=reverseQuad(quadTree)
    lowerRight=reverseQuad(quadTree)

    return "x"+lowerLeft+lowerRight+upperLeft+upperRight

for _ in range(C):
    index=0
    quadTree=input()
    print(reverseQuad(quadTree))