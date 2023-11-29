import sys

INF = float('inf')

input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def main():
    n, m = read_int_list()
    tetromino = [read_int_list() for _ in range(n)]

    visited = [([0] * m) for _ in range(n)]
    result = 0
    max_arr = max(map(max, tetromino))

    def dfs(x, y, idx, total):
        nonlocal result
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        if result >= total + max_arr * (3 - idx):
            return

        if idx == 3:
            result = max(result, total)
            return

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0:
                if idx == 1:
                    visited[nx][ny] = 1
                    dfs(x, y, idx + 1, total + tetromino[nx][ny])
                    visited[nx][ny] = 0

                visited[nx][ny] = 1
                dfs(nx, ny, idx + 1, total + tetromino[nx][ny])
                visited[nx][ny] = 0

    for x in range(n):
        for y in range(m):
            visited[x][y] = 1
            dfs(x, y, 0, tetromino[x][y])
            visited[x][y] = 0

    print(result)


if __name__ == "__main__":
    main()
