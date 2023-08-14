import sys

input = sys.stdin.readline
COIN = [5, 2]
EXIT_SIGNAL = -1

money = int(input())
cnt = 0

max_cnt = money // COIN[0]
changes = money % COIN[0]

while max_cnt >= 0:
    changes = money - COIN[0] * max_cnt
    leftMoney = changes % COIN[1]

    if leftMoney == 0:
        cnt += max_cnt
        cnt += changes // COIN[1]
        break

    max_cnt -= 1

if cnt == 0:
    print(EXIT_SIGNAL)
else:
    print(cnt)

