import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_list():
    return list(map(int, input().split()))

def main():
    t = read_int()

    for _ in range(t):
        n = read_int()
        stickers = [read_int_list() for _ in range(2)]

        dp = [[0] * (n + 3) for _ in range(2)]
        dp[0][0] = stickers[0][0]
        dp[1][0] = stickers[1][0]

        if n >= 2:
            dp[0][1] = dp[1][0] + stickers[0][1]
            dp[1][1] = dp[0][0] + stickers[1][1]

        for i in range(2, n):
            dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i]
            dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i]

        print(max(dp[0][n - 1], dp[1][n - 1]))

if __name__ == "__main__":
    main()