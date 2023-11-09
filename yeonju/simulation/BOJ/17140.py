import sys
from collections import Counter


input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def R(row_len, a):
    max_len = 0
    for x in range(row_len):
        cnt = Counter(a[x])
        cnt = sorted(cnt.items(), key=lambda x: (x[1], x[0]))
        if len(cnt) > 100:
            cnt = cnt[:100]

        new_array = []
        for key, value in cnt:
            if key == 0:
                continue
            new_array.append(key)
            new_array.append(value)

        a[x] = new_array
        max_len = max(max_len, len(a[x]))

        for x in range(len(a)):
            if len(a[x]) < max_len:
                a[x] += [0] * (max_len - len(a[x]))


def main():
    r, c, k = read_int_list()
    a = []
    min_time = 0

    for _ in range(3):
        a.append(read_int_list())

    is_possible = False

    for t in range(0, 101):
        if r - 1 < len(a) and c - 1 < len(a[0]):
            if a[r - 1][c - 1] == k:
                is_possible = True
                min_time = t
                break

        row_len = len(a)
        col_len = len(a[0])

        # R 연산
        if row_len >= col_len:
            R(row_len, a)

        # C 연산
        else:
            a = list(map(list, zip(*a)))
            R(col_len, a)
            a = list(map(list, zip(*a)))

    if is_possible:
        print(min_time)
    else:
        print(-1)


if __name__ == "__main__":
    main()
