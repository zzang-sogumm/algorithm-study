import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, k  = read_int_list()
    ice = []

    for _ in range(n):
        g, x = read_int_list()
        ice.append((x, g))

    ice.sort(key=lambda x: x[0])

    end = 0
    result = 0
    sum_of_ice = 0

    for start in range(n):
        d = ice[end][0] - ice[start][0]

        while end < n and d <= 2 * k:
            sum_of_ice += ice[end][1]
            end += 1

        result = max(result, sum_of_ice)
        sum_of_ice -= ice[start][1]

    print(result)

if __name__ == "__main__":
    main()