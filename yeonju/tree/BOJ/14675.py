import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n = read_int()
    tree =  [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = read_int_list()
        tree[a].append(b)
        tree[b].append(a)
    
    def is_cut_vertex(tree, k):
        if len(tree[k]) < 2:
            return False
        return True

    def is_bridge():
        return True

    q = read_int()
    for _ in range(q):
        t, k = read_int_list()

        if t == 1:
            if is_cut_vertex(tree, k):
                print('yes')
            else:
                print('no')
        elif t == 2:
            if is_bridge():
                print('yes')
            else:
                print('no')

if __name__ == "__main__":
    main()
