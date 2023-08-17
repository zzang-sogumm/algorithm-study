import sys
from itertools import combinations

input = sys.stdin.readline

SELECTED_ICE_CREAM_NUMBER = 3

n, m = list(map(int, input().split()))
iceCreams = [[False for _ in range(n)] for _ in range(n)]
answer = 0

for i in range(m):
    ice1, ice2 = list(map(int, input().split()))
    iceCreams[ice1 - 1][ice2 - 1] = True
    iceCreams[ice2 - 1][ice1 - 1] = True

for i in combinations(range(n), SELECTED_ICE_CREAM_NUMBER):
    if iceCreams[i[0]][i[1]] or iceCreams[i[0]][i[2]] or iceCreams[i[1]][i[2]]:
        continue
    answer += 1

print(answer)
