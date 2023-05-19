T=int(input())

def update_answer(num_list):
    global min_answer, max_answer
    temp=int("".join(num_list))
    if (temp>max_answer):
        max_answer=temp
    elif (temp<min_answer):
        min_answer=temp

for test_case in range(1, T+1):
    number=list(input())
    size=len(number)
    min_answer, max_answer = int("".join(number)), int("".join(number))
    for i in range(size-1):
        for j in range(i+1, size):
            if (i==0 and number[j]=='0'): continue
            number[i], number[j]=number[j], number[i]
            update_answer(number)
            number[i], number[j]=number[j], number[i]
    print("#{} {} {}".format(test_case, min_answer, max_answer))