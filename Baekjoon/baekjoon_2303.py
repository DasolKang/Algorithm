import sys

input=sys.stdin.readline

def choose_card(index, cur_number, choose_num):
    global max_number
    if (choose_num==3):
        if (cur_number%10>max_number):
            max_number=cur_number%10
        return
    for i in range(index, 5):
        choose_card(i+1, cur_number+number[i], choose_num+1)


N=int(input())
answer=-1
winner=-1
for i in range(N):
    number=list(map(int, input().split()))
    max_number=-1
    choose_card(0, 0, 0)
    if (max_number>=answer):
        answer=max_number
        winner=i+1
print(winner)