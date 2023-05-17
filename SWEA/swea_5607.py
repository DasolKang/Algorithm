import sys

input=sys.stdin.readline

# def get_factorial(n):
#     global MOD
#     if (n==1 or n==0):
#         factorial[n]=1
#         return factorial[n]
#     if (factorial[n]!=0):
#         return factorial[n]
#     factorial[n]=(n*get_factorial(n-1))%MOD
#     return factorial[n]
# def get_gcd(N, R):
#     for i in range(R, 0, -1):
#         if (N%i==0): return i

def my_pow(x, y):
    global MOD
    if (y==1): return x
    temp=my_pow(x, y//2)
    if (y%2==1):
        return (temp*temp*x)%MOD
    return (temp*temp)%MOD

def get_factorial(n):
    global MOD
    factorial[0]=1; factorial[1]=1
    for i in range(2, n+1):
        if factorial[i]!=0: continue
        factorial[i]=(i*factorial[i-1])%MOD

def combination(n: int, r: int):
    # nCr : n!/(n-r)!r!
    # return factorial[n]//(factorial[n-r]*factorial[r])
    # [{(n!*inverse[n-r])%MOD}*inverse[r]]%MOD
    inverse=(my_pow(factorial[n-r], MOD-2)*my_pow(factorial[r], MOD-2))%MOD
    # print(factorial[n], my_pow(factorial[r], MOD-2), my_pow(factorial[n-r], MOD-2))
    # return (factorial[n]*my_pow(factorial[r], MOD-2))%MOD*my_pow(factorial[n-r], MOD-2)
    return factorial[n]*inverse

T=int(input())
MOD = 1234567891
factorial=[0]*(1000001)
get_factorial(1000000)
for test_case in range(1, T+1):
    N, R = map(int, input().split())
    answer=combination(N, R)%MOD
    print("#{} {}".format(test_case, answer))