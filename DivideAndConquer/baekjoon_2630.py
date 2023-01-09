import sys

# sys.setrecursionlimit(10**9)
input = sys.stdin.readline
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
blue=0; white=0

def solution(startX: int, endX: int, startY: int, endY: int):
    # print("시작좌표 [",startX,", ",endX,"], [",startY,", ",endY,"]")
    global blue, white
    paper = isAllSameColor(startX, endX, startY, endY)
    if (paper>0): 
        blue+=1
        # print("파랑좌표 [",startX,", ",endX,"], [",startY,", ",endY,"]")
    elif (paper==0):
        white+=1
        # print("하양좌표 [",startX,", ",endX,"], [",startY,", ",endY,"]")
    else:
        midX=(startX+endX)//2; midY=(startY+endY)//2
        solution(startX, midX, startY, midY)
        solution(midX, endX, startY, midY)
        solution(startX, midX, midY, endY)
        solution(midX, endX, midY, endY)

def isAllSameColor(startX: int, endX: int, startY: int, endY: int):
    color= board[startX][startY]
    for i in range(startX, endX):
        for j in range(startY, endY):
            if (color!=board[i][j]): return -1

    if (color==1): return 1
    else: return 0

solution(0,N,0,N)
print(white); print(blue)