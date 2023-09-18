import sys

input = sys.stdin.readline

def read_int():
    return int(input()) 

def read_int_array():
    return list(map(int, input().split()))

def binary_search(arr, max_money, start, end):
    result = 0

    while start <= end:
        mid = (start + end) // 2  # 이분 탐색을 위한 중간값 계산

        sum_of_arr = 0

        for a in arr:
            if a < mid:
                sum_of_arr += a
            else:
                sum_of_arr += mid

        if sum_of_arr <= max_money:  # 예산을 초과하지 않는 경우
            result = mid  # 현재 중간값을 임시 결과로 저장
            start = mid + 1  # 더 큰 값을 찾기 위해 범위를 조정
        else:
            end = mid - 1  # 예산을 초과하는 경우 범위를 왼쪽으로 조정

    return result  # 최적의 예산을 반환

def main():
    n = read_int()
    arr = read_int_array()
    m = read_int()

    arr.sort()  # 국가 예산을 정렬하여 이분 탐색을 위한 준비

    result = binary_search(arr, m, 0, max(arr))  # 최적의 예산 계산
    print(result)

if __name__ == "__main__":
    main()
