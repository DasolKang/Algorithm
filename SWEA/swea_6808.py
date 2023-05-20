from itertools import permutations as permut

T=int(input())

def get_partner_card(kyuyoung):
    check = [False]*19
    for i in range(9):
        check[kyuyoung[i]]=True
    result=[]
    for i in range(1, 19):
        if (not check[i]):
            result.append(i)
    return result

def get_game_score(min_card):
    global kyu_win, min_win
    kyu_score, min_score=0, 0
    for i in range(9):
        if (kyuyoung[i]>min_card[i]):
            kyu_score+=(kyuyoung[i]+min_card[i])
        elif (min_card[i]>kyuyoung[i]):
            min_score+=(kyuyoung[i]+min_card[i])
    if (kyu_score>min_score): kyu_win+=1
    elif (min_score>kyu_score): min_win+=1


for test_case in range(1, T+1):
    kyuyoung = list(map(int, input().split()))
    minyoung = get_partner_card(kyuyoung)
    all_case = permut(minyoung, 9)
    kyu_win, min_win = 0, 0
    for poss in all_case:
        get_game_score(poss)
    print("#{} {} {}".format(test_case, kyu_win, min_win))



