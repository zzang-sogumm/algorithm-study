import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def main():
    n = read_int()
    a = read_int_array()
    dp = [1] * n

    for i in range(1, n):
        for j in range(i):
            if a[i] > a[j]:
                dp[i] = max(dp[i], dp[j] + 1)

    print(max(dp))

if __name__ == '__main__':
    main()
