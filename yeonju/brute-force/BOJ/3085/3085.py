import sys

input = sys.stdin.readline


def read_string_list():
    return list(input().rstrip())


def read_int():
    return int(input())


def check(arr, n):
    result = 1

    for i in range(n):
        colCnt = 1
        for j in range(1, n):
            if arr[i][j] == arr[i][j-1]:
                colCnt += 1
            else:
                colCnt = 1

            if colCnt > result:
                result = colCnt

        rowCnt = 1
        for j in range(1, n):
            if arr[j][i] == arr[j-1][i]:
                rowCnt += 1
            else:
                rowCnt = 1

            if rowCnt > result:
                result = rowCnt

    return result


def main():
    n = read_int()
    candy = []
    result = 0

    for _ in range(n):
        candy.append(read_string_list())

    for i in range(n):
        for j in range(n):
            # 열 바꾸기
            if j+1 < n:
                candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]

                tmp = check(candy, n)

                if tmp > result:
                    result = tmp

                candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]

            # 행 바꾸기
            if i+1 < n:
                candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]

                tmp = check(candy, n)

                if tmp > result:
                    result = tmp

                candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]

    print(result)


if __name__ == "__main__":
    main()
