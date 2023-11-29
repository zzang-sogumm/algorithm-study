import sys

INF = float('inf')

input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def main():
    n = read_int()
    teams = [read_int_list() for _ in range(n)]
    visited = [False for _ in range(n)]
    min_diff = INF

    def back(depth, idx):
        nonlocal min_diff

        if depth == n // 2:  # 팀이 다 나눠졌으면
            start, link = 0, 0

            for i in range(n):
                for j in range(n):
                    if visited[i] and visited[j]:  # start 팀
                        start += teams[i][j]
                    elif not visited[i] and not visited[j]:  # link팀
                        link += teams[i][j]

            min_diff = min(min_diff, abs(start - link))

        for i in range(idx, n):
            if not visited[i]:
                visited[i] = True
                back(depth + 1, i + 1)
                visited[i] = False

    back(0, 0)
    print(min_diff)


if __name__ == "__main__":
    main()
