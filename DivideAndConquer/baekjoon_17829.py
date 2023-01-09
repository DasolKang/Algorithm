import sys

input=sys.stdin.readline
N=int(input())
board = [list(map(int, input().split())) for _ in range(N)]


def solution(startX, endX, startY, endY):
    if (endX-startX==2):
        return getSecondMaxNum(startX, startY)
    
    temp=[]
    midX=(startX+endX)//2; midY=(startY+endY)//2
    temp.append(solution(startX, midX, startY, midY))
    temp.append(solution(midX, endX, startY, midY))
    temp.append(solution(startX, midX, midY, endY))
    temp.append(solution(midX, endX, midY, endY))

    temp.sort()
    print("좌표 [",startX,", ",endX,"], [",startY,", ",endY,"]")
    print("두번째 큰값 >> ", temp[-2])
    return temp[-2]

    
def getSecondMaxNum(startX: int, startY: int):
    num=[]
    num.append(board[startX][startY])
    num.append(board[startX][startY+1])
    num.append(board[startX+1][startY])
    num.append(board[startX+1][startY+1])
    num.sort()
    return num[-2]

print(solution(0,N,0,N))