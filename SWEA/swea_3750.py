T=int(input())

answer=[]
for test_case in range(1, T+1):
    N=list(map(int, input().strip()))
    total = sum(N)
    while (total>=10):
        N=list(map(int, str(sum(N))))
        total=sum(N)
    answer.append(total)

for i in range(len(answer)):
    print("#{} {}".format(i+1, answer[i]))