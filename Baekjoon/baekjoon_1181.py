import sys

input=sys.stdin.readline
N=int(input())
alphabet=[input().strip() for _ in range(N)]
alphabet=list(set(alphabet))
alphabet.sort(key=lambda x:[len(x), x])
print(*alphabet, sep="\n")
