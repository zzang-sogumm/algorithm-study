import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def binary_search(arr, v, dir):
    start, end = 0, len(arr) - 1

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == v:
            return mid
        if arr[mid] < v:
            start = mid + 1
        else:
            end = mid - 1
        
    # 이분 탐색이 종료된 후에도 v보다 작은 값과 큰 값 중에서 가장 가까운 인덱스를 반환
    if dir == 0:
        return start
    else:
        return end

def main():
    n, m = read_int_array()
    dots = read_int_array()

    dots.sort()

    for _ in range(m):
        start, end = read_int_array() 

        start_idx = binary_search(dots, start, 0)
        end_idx = binary_search(dots, end, 1)

        print(end_idx - start_idx + 1)

if __name__ == "__main__":
    main()
