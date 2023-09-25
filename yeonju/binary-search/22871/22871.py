import sys

INF = float('inf')

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def main():
    n = read_int()
    stones = read_int_array()
    
    dp = [0] + [INF] * (n - 1)

    for i in range(1, n):
        for j in range(0, i):
            power = max((i - j) * (1 + abs(stones[i] - stones[j])), dp[j])
            dp[i] = min(dp[i], power)

    print(dp[-1])


if __name__ == "__main__":
    main()
