import sys

# 상수 정의
INF = int(1e9)

# 기본 입력 함수 정의
input = sys.stdin.readline

def read_int():
    return int(input())

def main():
    # 로프 개수 입력받기
    n = read_int()
    ropes = [read_int() for _ in range(n)]

    ropes.sort(reverse=True)

    # 가장 무거운 로프의 무게를 초기값으로 설정
    max_weight = ropes[0]

    # 로프를 순회하며 최대 무게 찾기
    for i in range(1, n):
        max_weight = max(max_weight, ropes[i] * (i + 1))

    print(max_weight)

if __name__ == "__main__":
    main()