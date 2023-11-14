import sys

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n = read_int()
    a = read_int_list()
    plus, minus, multiply, divide = read_int_list()

    maximum = -INF
    minimum = INF

    def dfs(depth, total, plus, minus, multiply, divide):
        nonlocal maximum, minimum

        if depth == n:
            maximum = max(total, maximum)
            minimum = min(total, minimum)
            return
        
        if plus:
            dfs(depth + 1, total + a[depth], plus - 1, minus, multiply, divide)
        if minus:
            dfs(depth + 1, total - a[depth], plus, minus - 1, multiply, divide)
        if multiply:
            dfs(depth + 1, total * a[depth], plus, minus, multiply - 1, divide)
        if divide:
            dfs(depth + 1, int(total / a[depth]), plus, minus, multiply, divide - 1)
    
    dfs(1, a[0], plus, minus, multiply, divide)
    print(maximum)
    print(minimum)

if __name__ == "__main__":
    main()
