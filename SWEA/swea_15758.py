import sys

input=sys.stdin.readline
T=int(input())

for test_case in range(1, T+1):
    str1, str2=map(str, input().split())
    if (len(str2)>len(str1)): str1, str2=str2, str1
    str1+=str1; str2+=str2
    answer="yes"
    for i in range(len(str1)):
        if (str1[i]!=str2[i%len(str2)]):
            answer="no"
            break
    print("#{} {}".format(test_case, answer))