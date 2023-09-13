import sys

input = sys.stdin.readline

INF = float('inf')  # 무한대를 나타내는 상수 설정

def read_int_list():
    return list(map(int, input().split()))

def find_optimal_liquids(arr):
    left = 0
    right = len(arr) - 1
    min_diff = INF  # 초기 최소 차이를 무한대로 설정
    optimal_pair = (0, 0)  # 최적의 두 용액을 저장하는 튜플 초기화

    # 두 용액을 찾는 과정
    while left < right:
        sum_of_liquids = arr[left] + arr[right] 
        abs_diff = abs(sum_of_liquids)  # 현재 합의 절대값을 계산

        # 현재 합의 절대값이 최소 차이보다 작으면 최적의 두 용액을 업데이트
        if abs_diff < min_diff:
            min_diff = abs_diff
            optimal_pair = (arr[left], arr[right])

        # 합이 0보다 작으면 더 큰 값을 가진 용액을 선택하기 위해 왼쪽 포인터를 오른쪽으로 이동
        if sum_of_liquids < 0:
            left += 1
        else:
            # 합이 0보다 크거나 같으면 더 작은 값을 가진 용액을 선택하기 위해 오른쪽 포인터를 왼쪽으로 이동
            right -= 1


    return optimal_pair

def main():
    n = read_int_list()
    solutions = read_int_list()

    solutions.sort()  # 용액을 정렬

    result = find_optimal_liquids(solutions)  # 최적의 두 용액을 찾음
    print(result[0], result[1])  # 결과를 출력

if __name__ == "__main__":
    main()
