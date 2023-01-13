# 수식에 포함된 괄호의 짝이 맞는지 확인
# ( -> ) [ -> ] { -> }
# 괄호가 모두 닫혀있을 때 '짝이 맞는다'라고 표현
# 한 괄호쌍이 다른 괄호쌍과 교차해 있으면 안된다 - [(]) : 짝 안맞음 

import sys

input=sys.stdin.readline
C=int(input())

for _ in range(C):
    bracket=list(input().strip())
    stack=[]
    isMatch=True
    for b in bracket:
        if (b=='(' or b=='[' or b=='{'):
            stack.append(b)
        else:
            if stack:
                top = stack[-1]
                if (b==')'):
                    if (top=='('):
                        stack.pop()
                    else:
                        isMatch=False
                        break
                elif (b==']'):
                    if (top=='['):
                        stack.pop()
                    else:
                        isMatch=False
                        break
                elif (b=='}'):
                    if (top=='{'):
                        stack.pop()
                    else:
                        isMatch=False
                        break
            else:
                isMatch=False
                break
    if stack: isMatch=False
    if (isMatch): print("YES")
    else: print("NO")
