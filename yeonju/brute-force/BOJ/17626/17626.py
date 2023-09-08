import sys

input = sys.stdin.readline

n = int(input())

# 각 숫자별 필요한 최소 제곱 수를 저장
dp = [0] * (n + 1)

for i in range(1, n + 1):
    dp[i] = i  # dp[i]를 가장 큰 가능한 값으로 초기화

    # i 이하의 모든 제곱 수 시도
    j = 1
    while j * j <= i:
        dp[i] = min(dp[i], dp[i - j * j] + 1)
        j += 1

print(dp[n])