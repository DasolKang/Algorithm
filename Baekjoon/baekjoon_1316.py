import sys

input=sys.stdin.readline
N=int(input())
result=0

def checkWord(word: str) -> bool:
    visited=[False]*27
    for i in range(1, len(word)):
        if (word[i-1]!=word[i]):
            if (visited[ord(word[i-1])-97]): return False
            visited[ord(word[i-1])-97]=True
    if (visited[ord(word[-1])-97]): return False
    return True

for _ in range(N):
    word=input().strip()
    if (checkWord(word)): result+=1
print(result)