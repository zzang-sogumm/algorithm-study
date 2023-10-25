import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n = read_int()
    parent_nodes = read_int_list()
    k = read_int()

    def dfs(arr, node):
        arr[node] = -2

        for i in range(len(arr)):
            if node == arr[i]:
                dfs(arr, i)
    
    dfs(parent_nodes, k)

    count = 0
    for i in range(len(parent_nodes)):
        if parent_nodes[i] != -2 and i not in parent_nodes:
            count += 1
    
    print(count)

if __name__ == "__main__":
    main()
