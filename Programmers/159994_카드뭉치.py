import sys

input=sys.stdin.readline
example=[["i", "drink", "water"], ["want", "to"], ["i", "want", "to", "drink", "water"]]
example2=[ ["i", "drink", "coke"], ["want", "to"], ["i", "want", "to", "coke"] ]

def solution(cards1, cards2, goal):
    index1=-1; index2=-1
    for word in goal:
        if word in cards1:
            curIndex1=cards1.index(word)
            if index1!=-1 and curIndex1!=index1+1:
                return "No"
            else: index1=curIndex1
            print("1", word, index1, curIndex1)
        elif word in cards2:
            curIndex2=cards2.index(word)
            if index2!=-1 and curIndex2!=index2+1:
                return "No"
            else: index2=curIndex2
            print("2", word, index2, curIndex2)
        else: return "No"
    return "Yes"
            
print(solution(example2[0], example2[1], example2[2]))
