import sys
import heapq

input = sys.stdin.readline

def read_int():
    return int(input())

def main():
    n = read_int()

    # 최대 힙을 초기화
    heap = []

    # 작업 수행
    for _ in range(n):
        op = read_int()

        if op == 0:
            # 만약 작업이 0이라면, 최대 요소를 제거하고 출력 (만약 존재한다면)
            if heap:
                print(-heapq.heappop(heap))
            else:
                print(0)
        else:
            # 만약 작업이 0이 아니라면, 값을 음수로 변환하여 힙에 추가
            heapq.heappush(heap, -op)

if __name__ == "__main__":
    main()