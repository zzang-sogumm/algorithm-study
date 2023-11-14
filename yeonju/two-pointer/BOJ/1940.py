import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))

def main():
    n = read_int()
    m = read_int()
    materials = read_int_array()

    # 재료를 무게를 기준으로 정렬
    materials.sort()

    # 왼쪽 포인터와 오른쪽 포인터를 초기화
    left, right = 0, n - 1

    # 합산된 재료의 개수를 저장할 변수를 만듭
    count = 0

    while left < right:
        sum_of_materials = materials[left] + materials[right] # 현재 왼쪽과 오른쪽 포인터가 가리키는 재료의 무게를 더함

        if sum_of_materials == m: # 합산된 무게가 원하는 합과 같으면 카운트를 증가하고 포인터를 이동
            count += 1
            left += 1
            right -= 1
        elif sum_of_materials < m: # 합산된 무게가 원하는 합보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            left += 1
        else:
            right -= 1 # 합산된 무게가 원하는 합보다 크면 오른쪽 포인터를 왼쪽으로 이동

    print(count)

if __name__ == "__main__":
    main()