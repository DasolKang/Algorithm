# 입력받은 압축된 쿼드트리 상하로 뒤집어서 압축
# 압축 방법 : 전체가 흰색 -> w  전체가 검은색 -> b  섞여있다면 -> 쿼드트리로 분할
# 쿼드트리의 전체 압축결과 출력 전 x 출력

import sys

input=sys.stdin.readline
C=int(input())

def inputToTreeZip(inputList: list):
    result=[]
    if (len(inputList)==0): return
    while(inputList and len(result)<4):
        temp=inputList.pop(0)
        if (temp=='x'):
            result.append(inputToTreeZip(inputList))
        else:
            result.append(temp)
    return result
        
def reverse(tree: list):
    result=[]
    reverseList=[2,3,0,1]
    for i in reverseList:
        if isinstance(tree[i], list):
            result.append(reverse(tree[i]))
        else:
            result.append(tree[i])
    return result

def zipToPrint(tree: list):
    result=""
    for t in tree:
        if isinstance(t, list):
            result+="x"
            result+=zipToPrint(t)
        else:
            result+=t
    return result

for _ in range(C):
    inputList=list(input().strip())
    if (inputList[0]=='x'):
        zipQuad=inputToTreeZip(inputList[1:])
        # print("압축된 리스트 >> ", zipQuad)
        reverseTree=reverse(zipQuad)
        # print(reverseTree)
        print("x"+zipToPrint(reverseTree))

    else:
        print("".join(inputList))
