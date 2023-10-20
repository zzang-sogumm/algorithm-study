import sys

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n = read_int()
    graph = [[] for _ in range(n)]

    for i in range(n):
        graph[i] = read_int_list()

    # 플로이드 워셜 알고리즘 수행
    for k in range(n):
        for a in range(n):
            for b in range(n):
                if graph[a][k] and graph[k][b]:
                    graph[a][b] = 1

    for g in graph:
        print(*g)

if __name__ == "__main__":
    main()
