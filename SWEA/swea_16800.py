import sys

input=sys.stdin.readline

tc=int(input())
for test_case in range(1, tc+1):
    N=int(input())
    
    def can_divide(num):
        for i in range(int(num**0.5)+1, 1, -1):
            if (num%i==0): return i
        return 0
    
    temp=can_divide(N)
    if (temp):
        num1, num2=temp, N//temp
        answer=(num1-1)+(num2-1)
    else:
        answer=N-1
    print("#{} {}".format(test_case, answer))