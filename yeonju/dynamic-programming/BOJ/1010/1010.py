import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_list():
    return list(map(int, input().split()))

def factorial(n):
    if n > 1:
        return n * factorial(n - 1)
    else:
        return 1

def main():
    t = read_int()

    for _ in range(t):
        n, m = read_int_list()
        combination = factorial(m) // (factorial(m - n) * factorial(n))
        print(combination)

if __name__ == "__main__":
    main()
