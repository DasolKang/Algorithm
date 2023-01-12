# H*W의 크기의 격자 중 흰 칸을 L자 모양의 블록으로 덮고자 한다
# 게임판이 주어질 때 흰 칸을 덮는 경우의 수를 구하라

import sys

input=sys.stdin.readline

def isPoss(white, x, y):
    global H,W
    if (0<=x<H and 0<=y<W and [x, y] in white): return True
    else: return False

def coverBoard(white):
    global result, LTile
    whiteNum=len(white)
    if (whiteNum==0): result+=1
    elif (whiteNum<3): return
    else :
        for j in range(4):
            x=white[0][0]; y=white[0][1]
            l1x=x+LTile[j][0][0]; l1y=y+LTile[j][0][1]
            l2x=x+LTile[j][1][0]; l2y=y+LTile[j][1][1]
            if (isPoss(white, l1x, l1y) and isPoss(white, l2x, l2y)):
                temp=list(white)
                temp.remove([x, y]); temp.remove([l1x, l1y]); temp.remove([l2x, l2y])
                coverBoard(temp)
                    

C=int(input())
# 중복 없애기 위해 왼쪽 상단부터 채우도록 초기화
LTile = [[[0,1],[1,0]], [[1,0],[1,1]], [[0,1],[1,1]], [[1,0],[1,-1]]]
for _ in range(C):
    H, W = map(int, input().split())
    board=[list(input()) for _ in range(H)]
    white = []
    for i in range(H):
        for j in range(W):
            if (board[i][j]=='.'):
                white.append([i, j])
    result=0
    coverBoard(white)
    print(result)

