import sys
import heapq

input = sys.stdin.readline

def read_int():
    return int(input())

def main():
    # 연산의 개수 입력받기
    n = read_int()

    # 힙 초기화
    heap = []

    for i in range(n):
        x = read_int()
        
        if x != 0:
            heapq.heappush(heap, (abs(x), x))
        else:
            # 절대값의 최솟값 출력
            if heap:
                print(heapq.heappop(heap)[1])
            else:
                print(0)

if __name__ == "__main__":
    main()