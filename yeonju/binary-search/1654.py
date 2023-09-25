import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def binary_search(lopes, n):
    start, end = 1, max(lopes)
    result = 1

    while start <= end:
        mid = (start + end) // 2

        # 현재 설정한 길이로 나눈 랜선들의 개수 구하기
        sum_of_lopes = sum(lope // mid for lope in lopes)

        if sum_of_lopes < n:
            end = mid - 1
        else:
            start = mid + 1
            result = max(mid, result)
    
    return result

def main():
    k, n = read_int_array()
    lopes = []

    for _ in range(k):
        lope = read_int()
        lopes.append(lope)
    
    result = binary_search(lopes, n)
    print(result)

if __name__ == "__main__":
    main()
