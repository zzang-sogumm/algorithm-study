import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, m = read_int_list()
    arr = read_int_list()

    arr.sort()

    def dfs(idx, combi):
        if len(combi) == m:  # back
            print(*combi)
            return

        for i in range(idx, n):
            dfs(i, combi + [arr[i]])

    dfs(0, [])

if __name__ == "__main__":
    main()
