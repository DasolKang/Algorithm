import sys

input=sys.stdin.readline
N, M=map(int, input().split())
number=list(map(int, input().split()))
answer=0
temp=0
end_index=0
for start_index in range(N):
    while temp<M and end_index<N:
        temp+=number[end_index]
        end_index+=1
    if (temp==M): answer+=1
    temp-=number[start_index]
print(answer)


#시간초과
# answer=0
# for i in range(N):
#     for j in range(i, N):
#         if (sum(number[i:j+1])==M): 
#             answer+=1
#             break
# print(answer)