
def get_maxi_num(num: list) -> int:
    # 교환 후의 최댓값을 구하는 함수
    size = len(num)
    max_index, max_value= -1, -1
    for i in range(size-1):
        # 각 자리를 탐색하며
        for j in range(size-1, i, -1):
            if (num[j]>num[i] and num[j]>max_value):
                max_index=j
                max_value=num[j]
        if (max_value > num[i]): # 본인보다 뒤에 최댓값이 존재한다면
            num[i], num[max_index]=num[max_index], num[i]
            return int("".join(map(str, num)))
    return int("".join(map(str, num))) # 모든 자릿수에 대해 본인보다 뒤에 최댓값 존재하지 않으면 자기자신이 최댓값

def get_mini_num(num: list) -> int:
    # 교환 후의 최솟값을 구하는 함수
    size = len(num)
    min_index, min_value = -1, 999999999
    for i in range(size-1, 0, -1):
        if (num[i]!=0 and num[i]<min_value):
            min_index=i
            min_value=num[i]

    if (min_value<num[0]):
        num[0], num[min_index]=num[min_index], num[0]
        return int("".join(map(str, num)))

    min_index, min_value = -1, 999999999
    for i in range(1, size-1):
        # 각 자리를 탐색하며
        for j in range(size-1, i, -1):
            if (num[j]<num[i] and num[j]<min_value):
                min_index=j
                min_value=num[j]

        if (min_value < num[i]): # 본인보다 뒤에 최솟값이 존재한다면
            num[i], num[min_index] = num[min_index], num[i]
            return int("".join(map(str, num)))
    return int("".join(map(str, num))) #모든 자릿수에 대해 본인보다 뒤에 최솟값 존재하지 않으면 자기자신이 최솟값

T=int(input())
for test_case in range(1, T+1):
    input_array=list(input())
    number = list(map(int, input_array))
    maxi_num = get_maxi_num(number)
    number = list(map(int, input_array))
    mini_num = get_mini_num(number)
    print("#{} {} {}".format(test_case, mini_num, maxi_num))