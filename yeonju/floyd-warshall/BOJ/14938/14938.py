import sys

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, m, r = read_int_list()
    items = [0] + read_int_list()
    cities = [[INF] * (n + 1) for _ in range(n + 1)]

    # 자기 자신은 0으로
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            if a == b:
                cities[a][b] = 0

    for _ in range(r):
        a, b, l = read_int_list()
        cities[a][b] = l
        cities[b][a] = l

    for k in range(1, n + 1):
        for a in range(1, n + 1):
            for b in range(1, n + 1):
                if cities[a][b] > cities[a][k] + cities[k][b]:
                    cities[a][b] = cities[a][k] + cities[k][b]

    result = 0
    for i in range(1, n + 1):
        tmp = 0
        for j in range(1, n + 1):
            if cities[i][j] <= m:
                tmp += items[j]
            if tmp > result:
                result = tmp
            
    print(result)

if __name__ == "__main__":
    main()
