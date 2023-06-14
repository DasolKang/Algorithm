import sys

input=sys.stdin.readline

def get_prime(num):
    is_prime=[1]*(num+1)
    for i in range(2, int(num**0.5)):
        if (is_prime[i]==1):
            for j in range(i+i, num+1, i):
                is_prime[j]=0
    prime=[]
    for i in range(2, num+1):
        if (is_prime[i]==1):
            prime.append(i)
    return prime

N=int(input())
prime=get_prime(N)
prime_num=len(prime)
answer=0
for start in range(prime_num):
    cur_number=0
    for i in range(start, prime_num):
        cur_number+=prime[i]
        if (cur_number==N): answer+=1
        elif (cur_number>N): break
print(answer)