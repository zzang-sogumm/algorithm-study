import sys

input = sys.stdin.readline

n = int(input())
receivedTips = 0
tips = []
for i in range(n):
    tip = int(input())
    tips.append(tip)

tips.sort(reverse=True) # 내림차순 정렬을 시키자.

for i in range(n):
    rank = i + 1
    tip = tips[i] - (rank - 1)

    if tip <= 0:
        continue
    
    receivedTips += tip

print(receivedTips)