import sys

input=sys.stdin.readline
T=int(input())

def is_duplicate(num_arr: list) -> bool:
    visited=[False]*10
    for num in num_arr:
        if visited[num]: return True
        visited[num]=True
    return False


def is_sudoku(num_arr: list) -> bool:
    # 각 행에 숫자 한번씩만 존재?
    for i in range(9):
        if (is_duplicate(num_arr[i])): return False

    # 각 열에 숫자 한번씩만 존재?
    for i in range(9):
        col_arr=[]
        for j in range(9):
            col_arr.append(num_arr[j][i])
        if (is_duplicate(col_arr)): return False   

    # 3*3 사각형 내에 숫자 한번씩만 존재?
    poss=[(0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)]
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            square_arr=[]
            for x, y in poss:
                square_arr.append(num_arr[i+x][j+y])
            print(square_arr)
            if (is_duplicate(square_arr)): return False
    return True

for test_case in range(1, T+1):
    sudoku=[list(map(int, input().split())) for _ in range(9)]
    print("#", test_case, sep="", end=" ")
    if is_sudoku(sudoku): print(1)
    else: print(0)