import sys


input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def main():
    n, m = read_int_list()
    blocks = []

    for _ in range(n):
        blocks.append(read_int_list())

    # 윗면
    result = n * m

    # 왼쪽
    for i in range(n):
        result += blocks[i][0]

        for j in range(1, m):
            sub = blocks[i][j] - blocks[i][j - 1]
            if sub > 0:
                result += sub

    blocks = list(map(list, zip(*blocks)))

    # 정면
    for i in range(m):
        result += blocks[i][0]

        for j in range(1, n):
            sub = blocks[i][j] - blocks[i][j - 1]
            if sub > 0:
                result += sub

    print(result * 2)


if __name__ == "__main__":
    main()
