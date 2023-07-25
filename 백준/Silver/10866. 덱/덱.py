import sys
from collections import deque

queue = deque()
N = int(sys.stdin.readline().rstrip())
for _ in range(N):
    order = sys.stdin.readline().rstrip().split()
    command = order[0]
    if(command == "push_back"):
        queue.append(int(order[1]))
    elif(command == "push_front"):
        queue.insert(0, int(order[1]))
    elif(command == "pop_front"):
        if(queue): 
            print(queue.popleft())
        else:
            print(-1)
    elif(command == "pop_back"):
        if(queue): 
            print(queue.pop())
        else:
            print(-1)
    elif(command == "size"):
        print(len(queue))
    elif(command == "empty"):
        if(not queue): print(1)
        else: print(0)
    elif(command == "front"):
        if(queue):
            print(queue[0])
        else: print(-1)
    elif(command == "back"):
        if(queue):
            print(queue[-1])
        else: print(-1)