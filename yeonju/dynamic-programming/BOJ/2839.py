import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def find_min_bags(n):
    dp = [5001] * (n + 3)  # dp 테이블 초기화, (n + 3)로 설정하여 인덱스 오류를 방지
    dp[3] = dp[5] = 1  # 초기값 설정

    for i in range(6, n + 1):
        dp[i] = min(dp[i - 3], dp[i - 5]) + 1  # 최소 가방 수 계산 및 갱신

    return dp[n]  # n을 만드는데 필요한 최소 가방 수 반환

def main():
    n = read_int()  # 입력 받은 n 값

    result = find_min_bags(n)  # 최소 가방 수 계산

    if result < 5001:
        print(result)  # 결과 출력
    else:
        print(-1)  # 불가능한 경우 -1 출력

if __name__ == '__main__':
    main()

# 첫 시도: 못품