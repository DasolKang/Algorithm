import sys

input=sys.stdin.readline

T=int(input())
for test_case in range(1, T+1):
    bit=list(map(int, input().strip()))
    size = len(bit)
    cur_bit=[0]*size
    answer=0
    for i in range(size):
        if (cur_bit[i]!=bit[i]):
            answer+=1
            for j in range(i, size):
                cur_bit[j]=(cur_bit[j]+1)%2
    print("#{} {}".format(test_case, answer))