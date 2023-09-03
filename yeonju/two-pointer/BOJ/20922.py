import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, k = read_int_list()
    a = read_int_list() 

    left = 0    # 왼쪽 포인터 초기화
    right = 0   # 오른쪽 포인터 초기화
    max_len = 0 # 최대 길이 초기화
    num_count = [0] * 100001    # 숫자 등장 횟수를 기록하기 위한 배열, 배열 크기를 충분히 크게 설정

    while right < n:
        num = a[right]
        num_count[num] += 1 # 현재 숫자 등장 횟수를 증가

        while num_count[num] > k:
            left_num = a[left]
            num_count[left_num] -= 1
            left += 1   # 중복 허용 횟수를 초과할 때, 왼쪽 포인터를 이동

        max_len = max(max_len, right - left + 1)    # 최대 길이 갱신
        right += 1  # 오른쪽 포인터를 이동

    print(max_len)

if __name__ == "__main__":
    main()
