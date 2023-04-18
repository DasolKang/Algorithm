import sys

input=sys.stdin.readline
T=10

for test_case in range(1, T+1):
    dump=int(input())
    number=list(map(int, input().split()))
    for d in range(dump):
        maxi, mini=max(number), min(number)
        if (maxi<=mini+1): break
        max_index, min_index=number.index(maxi), number.index(mini)
        number[max_index]-=1
        number[min_index]+=1
    print("#{} {}".format(test_case, max(number)-min(number)))
