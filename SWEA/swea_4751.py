T=int(input())

for _ in range(T):
    input_str = input()
    str_size=len(input_str)
    size=5*str_size-(str_size-1)
    answer=[["."]*size for _ in range(5)]
    for i in range(2):
        jump=4
        if (i==1): jump=2
        for j in range(jump//2, size, jump):
            answer[i][j]="#"
            answer[4-i][j]="#"
    index=0
    for i in range(0, size, 4):
        answer[2][i]="#"
    for i in range(2, size, 4):
        answer[2][i]=input_str[index]
        index+=1
    for i in range(5):
        print("".join(answer[i]))