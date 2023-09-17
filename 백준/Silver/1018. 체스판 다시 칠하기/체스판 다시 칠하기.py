import sys

N,M = map(int,input().split())

inputBoard = []
repaint=[]

for i in range(N):
    inputBoard.append(sys.stdin.readline())
    
for i in range(N-7):
    for j in range(M-7):
        bstartCnt=0; wstartCnt=0
        for w in range(i,i+8):
            for c in range(j, j+8):
                if((w+c)%2==0):
                    if(inputBoard[w][c]!='W'):
                        wstartCnt+=1
                    else:
                        bstartCnt+=1
                else:
                    if(inputBoard[w][c]!='B'):
                        wstartCnt+=1
                    else:
                        bstartCnt+=1
        repaint.append(wstartCnt)
        repaint.append(bstartCnt)
                        
print(min(repaint))
