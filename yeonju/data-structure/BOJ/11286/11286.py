import sys
import heapq

# initial setting
input = sys.stdin.readline
def inputInt():
    return int(input())

# 연산의 개수 입력받기
n = inputInt()

# 힙 초기화
heap = []

for i in range(n):
    x = inputInt()
    
    if x != 0:
        heapq.heappush(heap, (abs(x), x))
    else:
        # 절대값의 최솟값 출력
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)