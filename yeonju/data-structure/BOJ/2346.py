import sys

input = sys.stdin.readline

def read_int():
    return int(input())

def read_int_array():
    return list(map(int, input().split()))


def main():
    n = read_int() # 풍선의 개수를 입력
    movements = read_int_array() # 각 풍선의 이동 거리를 입력
    balloons = []

    for i in range(n):
        balloons.append([i + 1, movements[i]])

    popped_indices = []  # 터뜨린 풍선의 인덱스를 저장하는 리스트

    # 초기 위치 및 이동거리 설정
    current_index = 0

    while True:
        # 현재 위치의 풍선을 터뜨림. 해당 풍선은 리스트에서 제거
        popped_balloon, movement = balloons[current_index]
        del balloons[current_index]

        popped_indices.append(popped_balloon)   # 1부터 시작하는 인덱스를 결과 리스트에 추가

        # 모든 풍선이 터졌을 때 루프를 종료
        if not balloons:
            break
    
        del movements[current_index]

        # 다음 이동 거리에 따라 다음 위치 설정
        if movement >= 0:
            current_index = (current_index + movement - 1) % len(movements)
        else:
            current_index = (current_index + movement) % len(movements)

    # 결과 출력
    print(" ".join(map(str, popped_indices)))

if __name__ == "__main__":
    main()