import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def dfs(graph, v, visited):
    visited[v] = True
    result = 0

    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(graph, neighbor, visited)

    result = sum(visited) - 1
    
    return result

def main():
    n = read_int()
    k = read_int()

    graph = [[] for _ in range(n + 1)]
    visited = [False] * (n + 1)

    for _ in range(k):
        computer1, computer2 = read_int_list()
        graph[computer1].append(computer2)
        graph[computer2].append(computer1)

    result = dfs(graph, 1, visited)
    print(result)


if __name__ == "__main__":
    main()
