import sys

input=sys.stdin.readline
T=int(input().rstrip())

for test_case in range(1, T+1):
    alphabet=input().strip()
    result=0
    for i in range(len((alphabet))):
        if (ord(alphabet[i])==i+97): result+=1
        else: break
    print("#{} {}".format(test_case, result))