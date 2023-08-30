import sys 

# input=sys.stdin.readline
directions = {0: [0, 2], 1: [1, 2], 2: [0, 1, 2]} # 가로(0) / 세로(1) / 대각선(2) 
cos = {0: [0, 1], 1: [1, 0], 2: [1, 1]} # (y, x) 
n = int(input()) 
house = [] 
for _ in range(n): 
    house.append([int(x) for x in input().split()]) 

def check(y, x, d): 
    for direction in directions[d]: 
        dy, dx = cos[direction] 
        ny = y + dy 
        nx = x + dx 
        if 0 <= ny < n and 0 <= nx < n and not house[ny][nx]: 
            if direction != 2:
                dp[ny][nx][direction] += dp[y][x][d] 
            else:
                if not house[ny-1][nx] and not house[ny][nx-1]: 
                    dp[ny][nx][direction] += dp[y][x][d] 
                    
dp = [[[0 for _ in range(3)] for _ in range(n)] for _ in range(n)] 
dp[0][1][0] = 1 
for y in range(n): 
    for x in range(n): 
        for d in range(3):
            if dp[y][x][d] and not house[y][x]: 
                check(y, x, d) 
                
print(sum(dp[n-1][n-1]))