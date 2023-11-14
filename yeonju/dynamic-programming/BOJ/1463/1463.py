import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def find_min_operations(n):
    dp = [0] * (n + 3)
    dp[2] = 1
    dp[3] = 1

    for i in range(4, n + 1):
        operations = [dp[i - 1] + 1]

        if i % 3 == 0:
            operations.append(dp[i // 3] + 1)
        if i % 2 == 0:
            operations.append(dp[i // 2] + 1)

        dp[i] = min(operations)

    return dp[n]

def main():
    n = read_int()
    result = find_min_operations(n)
    print(result)

if __name__ == '__main__':
    main()

