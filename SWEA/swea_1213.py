T=10

def check_str(index, search_str):
    global total_str, size
    return search_str=="".join(total_str[index:index+size])

for _ in range(1, T+1):
    test_case = int(input())
    search_str=input()
    total_str=input()
    index=0; size=len(search_str)
    answer=0
    while (index<len(total_str)):
        if (check_str(index, search_str)):
            answer+=1
            index+=size
        else: index+=1
    print(f"#{test_case} {answer}")
