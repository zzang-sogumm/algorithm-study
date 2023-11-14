import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, s = read_int_list()
    arr = read_int_list()
    cnt = 0

    def back(idx, subsequence):
        nonlocal cnt

        if idx == n:
            return

        subsequence += arr[idx]

        if subsequence == s:
            cnt += 1

        back(idx + 1, subsequence)
        back(idx + 1, subsequence - arr[idx])

    back(0, 0)
    print(cnt)

if __name__ == "__main__":
    main()

