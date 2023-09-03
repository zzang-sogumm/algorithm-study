import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, x = read_int_list()
    visitors = read_int_list()
    
    # 초기값 설정: 처음 x일 동안의 방문자 수를 합산
    max_visitors = sum(visitors[:x])
    max_periods = 1

    # 시작 인덱스를 설정
    start_index = 0
    current_visitors = max_visitors

    # 슬라이딩 윈도우를 사용하여 최대 방문자 수를 찾음
    for i in range(x, n):
        # 현재 방문자 수를 업데이트
        current_visitors = current_visitors - visitors[start_index] + visitors[i]
        start_index += 1

        # 최대 방문자 수를 비교하고 업데이트
        if current_visitors > max_visitors:
            max_visitors = current_visitors
            max_periods = 1
        elif current_visitors == max_visitors:
            max_periods += 1
    
    if max_visitors == 0:
        print('SAD')
    else:
        print(max_visitors)
        print(max_periods)


if __name__ == "__main__":
    main()