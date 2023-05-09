import copy

T=int(input())

def change_last_two(num : list) -> int:
    num[-1], num[-2]=num[-2], num[-1]
    return int("".join(num))

def exists_duplicate(num_arr : list) -> bool:
    return len(set(num_arr))!=len(num_arr)

def solution(cur_number: list, left_count: int, info):
    global answer, best_answer, size
    temp_string = "".join(cur_number)
    if (temp_string==best_answer):
        # 최적의 답에 도달했을 때
        if (left_count%2==0 or exists_duplicate(cur_number)) :
            # 남은 교환 횟수가 짝수이거나 중복 숫자 있을 때
            answer = int(temp_string)
            print("최적 답", info)
        else:
            # 남은 횟수 홀수이면서 중복 없을 때
            answer = change_last_two(cur_number)
            print("최적 답 교환", info)
    elif (left_count==0) :
        # 교환 횟수가 남지 않았을 때 정답 갱신
        answer=max(answer, int(temp_string))
        print("교환 횟수 소모", info)
    else:
        # 뽑기
        for i in range(size-1):
            for j in range(i+1, size):
                if (cur_number[i]<cur_number[j]):
                    # 뒷자리 수가 클 때만 교환 
                    temp=copy.deepcopy(cur_number)
                    temp[i], temp[j]=temp[j], temp[i]
                    next_string="".join(temp)
                    if (next_string not in visited or visited[next_string]<left_count-1):
                        # 방문한적 없거나 더 적은 교환 횟수 남았을 때 방문 했었다면 다시 방문
                        visited[next_string]=left_count-1
                        info.append(next_string)
                        solution(temp, left_count-1, info)
                        info.pop()
                    


for test_case in range(1, T+1):
    number, count = map(int, input().split())
    num_array = list(str(number))
    best_answer = "".join(sorted(num_array, reverse=True))
    size = len(num_array)
    visited = dict()
    visited["".join(num_array)]=count
    answer=number
    solution(num_array, count, ["".join(num_array)])
    print(f"#{test_case} {answer}")