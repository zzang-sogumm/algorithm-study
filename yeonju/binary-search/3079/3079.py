import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def binary_search(arr, m):
    start = min(arr) # 최소 시간: 가장 빠른 입국심사대가 걸리는 시간
    end = max(arr) * m # 최대 시간: 가장 늦은 입국심사대가 걸리는 시간의 m배

    result = end # 결과를 저장할 변수를 초기화

    while start <= end:
        mid = (start + end) // 2 # 가상으로 걸리는 시간
        available_people = 0 # 해당 시간으로 입국심사를 할 수 있는 사람 수

        # 각 입국심사대에서 mid 시간 동안 몇 명의 사람을 처리할 수 있는지 계산
        for i in range(len(arr)):
            available_people += mid // arr[i]

        if available_people >= m: # 가능한 사람 수가 목표인 m보다 크거나 같으면, 시간을 줄여보기 위해 end를 줄임.
            end = mid - 1
            result = min(mid, result)
        else: # 가능한 사람 수가 목표인 m보다 작으면, 시간을 늘려보기 위해 start를 늘림
            start = mid + 1
    
    return result

def main():
    n, m = read_int_list()
    counters = []

    for _ in range(n):
        t = read_int()
        counters.append(t)
    
    result = binary_search(counters, m)
    print(result)

if __name__ == "__main__":
    main()
