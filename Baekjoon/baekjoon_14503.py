import sys

input=sys.stdin.readline
N, M=map(int, input().split())
r, c, d=map(int, input().split())
board=[list(map(int, input().split())) for _ in range(N)]

def in_range(x, y):
    global N, M
    return 0<=x<N and 0<=y<M

def get_next_direction(x, y, d):
    for i in range(1, 5):
        nx, ny=x+dxs[(d-i+8)%4], y+dys[(d-i+8)%4] #반시계
        if (in_range(nx, ny) and board[nx][ny]==0 and not visited[nx][ny]):
            return [nx, ny, (d-i+4)%4]
    return False


dxs, dys=[-1, 0, 1, 0], [0, 1, 0, -1] #북 동 남 서
answer=0
visited=[[False]*M for _ in range(N)]
def dfs(x, y, d):
    global answer
    if (board[x][y]==0 and not visited[x][y]):
        visited[x][y]=True
        answer+=1
    is_poss_move=get_next_direction(x, y, d)
    if (not is_poss_move):
        back=(d+2)%4
        nx, ny=x+dxs[back], y+dys[back]
        if (in_range(nx, ny) and board[nx][ny]==0):
            dfs(nx, ny, d)
        return
    nx, ny=is_poss_move[0], is_poss_move[1]
    dfs(nx, ny, is_poss_move[2])
    return
    
dfs(r, c, d)
print(answer)