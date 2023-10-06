from collections import deque
import sys

input = sys.stdin.readline

def read_string():
    return input().rstrip()

def read_int():
    return int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque([])
    queue.append((x, y))
    count = 1
    
    if graph[x][y] != 1:
        return 0

    graph[x][y] = 2

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
    
            if graph[nx][ny] == 1:
                graph[nx][ny] += 1
                queue.append((nx, ny))
                count += 1

    return count

def main():
    global n
    global graph

    n = read_int()
    graph = [[] for _ in range(n)]

    for i in range(n):
        s = read_string()
        graph[i] = list(map(int, list(s)))
    
    result = 0
    counts = []

    for i in range(n):
        for j in range(n):
            count = bfs(i, j)

            if count != 0:
                result += 1
                counts.append(count)

    print(result)

    counts.sort()
    for count in counts:
        print(count)
        
if __name__ == "__main__":
    main()
