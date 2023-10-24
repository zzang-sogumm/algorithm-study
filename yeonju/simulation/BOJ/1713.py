import sys
from collections import defaultdict

input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


def main():
    n = read_int()
    m = read_int()
    recommendations = read_int_list()

    photos = defaultdict(int)
    candidates = []

    for recommend in recommendations:
        # 1. 현재 사진 목록에 있는 경우
        if recommend in candidates:
            photos[recommend] += 1
            continue

        # 2. 현재 사진 목록에 없는 경우
        if len(candidates) == n:  # 꽉찼을 경우, 추천 받은 횟수가 가장 적은 학생 사진 중 오래된 사진 삭제
            min_candidate = min(candidates, key=lambda x: (photos[x]))
            candidates.remove(min_candidate)  # remove는 가장 첫 번째만 삭제
            photos[min_candidate] = 0

        # 새롭게 추천받은 학생 사진 게시
        candidates.append(recommend)
        photos[recommend] = 1

    candidates.sort()

    print(*candidates)


if __name__ == "__main__":
    main()
