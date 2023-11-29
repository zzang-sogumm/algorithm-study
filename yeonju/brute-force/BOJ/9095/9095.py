import sys

input = sys.stdin.readline


def read_int():
    return int(input())


def main():
    t = read_int()
    result = []

    for _ in range(t):
        n = read_int()
        dp = [0] * 12

        dp[1] = 1
        dp[2] = 2
        dp[3] = 4

        for i in range(4, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

        result.append(dp[n])

    for i in range(t):
        print(result[i])


if __name__ == "__main__":
    main()
