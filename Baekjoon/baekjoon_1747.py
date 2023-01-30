import sys

input=sys.stdin.readline
N=int(input())

def isPalindrome(string: str):
    # size=len(string)
    # left=string[:size//2]
    # if (size%2==0):
    #     right=string[size:size//2-1:-1]
    # else:
    #     right=string[size:size//2:-1]
    # print("left >> ", left, "  right >> ", right)
    # if (left==right): return True
    # else: return False
    if (string==string[::-1]): return True
    else: return False

def isPrime(N: int):
    if (N==1): return False
    for i in range(2, int(N**0.5)+1):
        if (N%i==0): return False
    return True

while True:
    if isPalindrome(str(N)) and isPrime(N):
        print(N)
        break
    N+=1

