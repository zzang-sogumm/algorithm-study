from collections import deque
import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def bfs(graph, n, start):
    visited = [False] * (n + 1)
    visited[start] = True
    count = 1

    queue = deque([start])

    while queue:
        v = queue.popleft()
    
        for neighbor in graph[v]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True
                count += 1
    
    return count

def main():
    n, m = read_int_list()
    computers = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = read_int_list()
        computers[b].append(a)
    
    max_count = 1
    result = []
    
    for i in range(1, n + 1):
        count = bfs(computers, n, i)
        if count > max_count:
            max_count = count
            result = [i]
        elif count == max_count:
            result.append(i)
    
    print(*result)

if __name__ == "__main__":
    main()
