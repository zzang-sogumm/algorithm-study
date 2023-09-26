from collections import deque
import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def bfs(graph, start):
    n = len(graph) - 1
    parent = [0] * (n + 1)
    visited = [False] * (n + 1)

    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()

        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                parent[neighbor] = current
                queue.append(neighbor)
    
    return parent

def main():
    n = read_int()
    trees = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = read_int_list()
        trees[a].append(b)
        trees[b].append(a)
    
    parents = bfs(trees, 1)
    
    for i in range(2, n + 1):
        print(parents[i])

if __name__ == "__main__":
    main()
