# TODO
import sys

input = sys.stdin.readline
INF = int(1e9)

n = int(input())
ropes = []

totalMaxWeight = INF

for i in range(n):
    max_weight = int(input())
    w = max_weight * n

    if w <= totalMaxWeight:
        totalMaxWeight = w

print(totalMaxWeight)