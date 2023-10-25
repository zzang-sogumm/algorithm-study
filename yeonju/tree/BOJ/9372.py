import sys

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    t = read_int()

    for _ in range(t):
        n, m = read_int_list()
        trees = [[] for _ in range(n + 1)]

        for _ in range(m):
            a, b = read_int_list()
        
        print(n - 1)


if __name__ == "__main__":
    main()
