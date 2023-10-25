import sys

input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def read_int_tuple():
    return tuple(map(int, input().split()))


def main():
    N, M = read_int_list()
    board = [read_int_list() for _ in range(N)]
    moves = [read_int_tuple() for _ in range(M)]

    dy = [0, 0, -1, -1, -1, 0, 1, 1, 1]
    dx = [0, -1, -1, 0, 1, 1, 1, 0, -1]

    clouds = [(N-1, 0), (N-1, 1), (N-2, 0), (N-2, 1)]
    for d, s in moves:
        moved_clouds = []
        for y, x in clouds:
            ny = (y + dy[d] * s) % N
            nx = (x + dx[d] * s) % N
            board[ny][nx] += 1
            moved_clouds.append((ny, nx))

        for y, x in moved_clouds:
            cnt = 0
            for d in range(2, 9, 2):
                ny = y + dy[d]
                nx = x + dx[d]
                if ny < 0 or nx < 0 or ny >= N or nx >= N:
                    continue
                elif board[ny][nx] > 0:
                    cnt += 1
            board[y][x] += cnt

        new_clouds = []
        for y in range(N):
            for x in range(N):
                if (y, x) in moved_clouds or board[y][x] < 2:
                    continue

                board[y][x] -= 2
                new_clouds.append((y, x))
        clouds = new_clouds

    result = 0
    for y in range(N):
        for x in range(N):
            result += board[y][x]
    print(result)


if __name__ == "__main__":
    main()
