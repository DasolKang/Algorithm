# 학생 30명 중 과제를 제출하지 않은 학생의 출석번호를 구하라

import sys

input=sys.stdin.readline
student=[i for i in range(1, 31)]
for _ in range(28):
    homework=int(input())
    student.remove(homework)
print(*student, sep="\n")