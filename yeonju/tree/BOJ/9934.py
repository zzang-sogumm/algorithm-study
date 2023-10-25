import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    k = read_int()
    order = read_int_list()

    tree = [[] for _ in range(k)]

    def dfs(arr, depth):
        mid = len(arr) // 2
        tree[depth].append(arr[mid])

        if len(arr) == 1:
            return
        
        dfs(arr[:mid], depth + 1)
        dfs(arr[mid + 1:], depth + 1)
    
    dfs(order, 0)

    for t in tree:
        print(*t)

if __name__ == "__main__":
    main()