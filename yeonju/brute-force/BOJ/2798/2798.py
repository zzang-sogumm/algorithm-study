import sys
from itertools import combinations

input = sys.stdin.readline
INF = int(1e9)

n, m = list(map(int, input().split()))
cards = list(map(int, input().split()))
answer = -INF

# 내림차순 정렬
cards.sort(reverse=True)

# 조합 구하기
combinations = list(combinations(cards, 3))

for combination in combinations:
    sum_combination = sum(combination)

    if sum_combination <= m and answer < sum_combination:
        answer = sum_combination

print(answer)