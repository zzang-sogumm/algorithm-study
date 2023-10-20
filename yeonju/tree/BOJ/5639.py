import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

def read_int():
    return int(input())

def main():
    pre = []

    while True:
        try:
            pre.append(read_int())
        except:
            break
    
    def post_order(start, end):
        if start > end:
            return
        
        mid = end + 1
        
        for i in range(start + 1, end + 1):
            if pre[i] > pre[start]:
                mid = i
                break
        
        post_order(start + 1, mid - 1)
        post_order(mid, end)
        print(pre[start])

    post_order(0, len(pre) - 1)

if __name__ == "__main__":
    main()
