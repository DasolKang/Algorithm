
T=int(input())

def is_possible(index, column):
    for i in range(index):
        if (queen_info[i]==column or abs(index-i)==abs(column-queen_info[i])):
            return False
    return True


def backtracking(index):
    global N, answer
    if (index==N): answer+=1
    for i in range(N):
        if (is_possible(index, i)):
            queen_info[index]=i
            backtracking(index+1)


for test_case in range(1, T+1):
    N=int(input())
    queen_info=[0]*N
    answer=0
    backtracking(0)
    print("#{} {}".format(test_case, answer))