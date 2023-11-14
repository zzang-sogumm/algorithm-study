import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def read_array():
    return input().split()

def binary_search(powers, target):
    start = 0
    end = len(powers) - 1
    
    while start <= end:
        mid = (start + end) // 2

        if powers[mid][1] < target:
            start = mid + 1
        else:
            end = mid - 1

    return powers[start][0]

def main():
    n, m = read_int_array()
    powers = []

    for _ in range(n):
        t, v = read_array()
        v = int(v)
        powers.append([t, v])
    
    for _ in range(m):
        strength = read_int()
        result = binary_search(powers, strength)
        print(result)
    
if __name__ == "__main__":
    main()
