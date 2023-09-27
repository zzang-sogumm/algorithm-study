from collections import deque
import sys

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_string():
    return input().rstrip()

def read_int():
    return int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 최단 경로 -> bfs 이용
def bfs(graph, n, m, x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        # 현재 위치에서 네 방향으로의 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 미로 찾기 공간을 벗어난 경우 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            # 벽인 경우 무시
            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

    return graph[n - 1][m - 1]


def main():
    n, m = read_int_list()
    maze = [[] for _ in range(n)]

    for i in range(n):
        s = read_string()
        maze[i] = list(map(int, list(s)))

    result = bfs(maze, n, m, 0, 0)
    print(result)

if __name__ == "__main__":
    main()
