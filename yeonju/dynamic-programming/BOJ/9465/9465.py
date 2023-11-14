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
        dp = [read_int_list() for _ in range(2)]

        if n >= 2:
            dp[0][1] += dp[1][0] 
            dp[1][1] += dp[0][0] 

        for i in range(2, n):
            dp[0][i] += max(dp[1][i - 1], dp[1][i - 2])
            dp[1][i] += max(dp[0][i - 1], dp[0][i - 2])

        result = max(dp[0][n - 1], dp[1][n - 1])
        print(result)

if __name__ == "__main__":
    main()