import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_string():
    return input().rstrip()

def read_string_list():
    return list(read_string().split())

def main():
    n = read_int()
    tree = {}
    
    for _ in range(n):
        root, left, right = read_string_list()
        tree[root] = [left, right]

    def pre_order(root):
        if root != '.':
            print(root, end = "")
            pre_order(tree[root][0])
            pre_order(tree[root][1])

    def in_order(root):
        if root != '.':
            in_order(tree[root][0])
            print(root, end = "")
            in_order(tree[root][1])

    def post_order(root):
        if root != '.':
            post_order(tree[root][0])
            post_order(tree[root][1])
            print(root, end = "")

    pre_order('A')
    print()
    in_order('A')
    print()
    post_order('A')

if __name__ == "__main__":
    main()
