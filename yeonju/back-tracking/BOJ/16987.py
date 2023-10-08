import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def findBrokenEggs(arr):
    cnt = 0

    for a in arr:
        if a[0] <= 0:
            cnt += 1
    
    return cnt

def main():
    n = int(input())
    eggs = []
    result = 0

    for _ in range(n):
        eggs.append(read_int_list())
    
    def dfs(idx, arr):
        nonlocal result

        if idx == n: # 가장 오른쪽에 위치한 계란일 경우
            result = max(result, findBrokenEggs(arr))
            return

        if eggs[idx][0] <= 0: # 현재 계란이 이미 깨진 경우는 패스
            dfs(idx + 1, arr)
            return

        no_eggs_to_break = True

        for i in range(n):
            if i != idx and eggs[i][0] > 0: # 깰 수 있는 다른 계란 발견
                no_eggs_to_break = False
                arr[idx][0] -= arr[i][1]
                arr[i][0] -= arr[idx][1]
                dfs(idx + 1, arr)
                arr[idx][0] += arr[i][1]
                arr[i][0] += arr[idx][1]

        if no_eggs_to_break: # 깰 수 있는 계란이 없으면, 그냥 다음 계란으로 이동
            dfs(idx + 1, arr)

    dfs(0, eggs)
    print(result)


if __name__ == "__main__":
    main()
