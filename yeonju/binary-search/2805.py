import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def binary_search(arr, home_tree, start, end):
    result = 0

    while start <= end:
        mid = (start + end) // 2

        sum_of_trees = 0

        for a in arr:
            if mid < a:
                sum_of_trees += (a - mid)
        
        if sum_of_trees >= home_tree:
            result = mid
            start = mid + 1
        else:
            end = mid - 1

    return result

def main():
    n, m = read_int_array()
    trees = read_int_array()

    result = binary_search(trees, m, 0, max(trees))
    print(result)

if __name__ == "__main__":
    main()
