N, M, x, y, K = map(int, input().split()) 
maps = [list(map(int, input().split())) for _ in range(N)] 
op = list(map(int, input().split())) 
dice = [0]*7

def move(op): 
    if op == 1: #동쪽
        dice[1], dice[3], dice[4], dice[6] = dice[3], dice[6], dice[1], dice[4] 
    elif op == 2: #서쪽
        dice[1], dice[3], dice[4], dice[6] = dice[4], dice[1], dice[6], dice[3] 
    elif op == 3: #북쪽
        dice[1], dice[2], dice[5], dice[6] = dice[2], dice[6], dice[1], dice[5] 
    elif op == 4: #남쪽
        dice[1], dice[2], dice[5], dice[6] = dice[5], dice[1], dice[6], dice[2] 
        
def direction(op): 
    if op == 1: 
        return (0, 1) 
    elif op == 2: 
        return (0, -1) 
    elif op == 3: 
        return (-1, 0) 
    elif op == 4: 
        return (1, 0) 
    
for i in op:  
    moveX, moveY = direction(i) 
    if 0 <= x+moveX < N and 0 <= y+moveY < M: 
        x += moveX 
        y += moveY 
        move(i)
        if maps[x][y] != 0: 
            dice[1] = maps[x][y] 
            maps[x][y] = 0 
        else:
            maps[x][y] = dice[1] 
        print(dice[6])