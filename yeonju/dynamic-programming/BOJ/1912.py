import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n = read_int()
    dp = read_int_list()

    for i in range(1, n):
        if dp[i] < dp[i - 1] + dp[i]:
            dp[i] += dp[i - 1]
    
    print(max(dp))

if __name__ == "__main__":
    main()
