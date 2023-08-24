from itertools import combinations
import sys

# initial setting
input = sys.stdin.readline
INF = int(1e9)
def inputIntList():
    return list(map(int, input().split()))

# start
n, m = inputIntList()

a = [] # 회원들의 만족도 저장
for i in range(n):
    a.append(inputIntList())

chickens = combinations(range(m), 3) # 치킨 조합 생성

answer = -INF
for c in chickens:
    x, y, z = list(c)

    # 각 회원마다 최대 만족도 구해서 더하기
    satisfaction = 0
    for person in a:
        max_s = max(person[x], person[y], person[z]) 
        satisfaction += max_s
    
    if satisfaction > answer: # 만족도 최댓값 구하기
        answer = satisfaction

print(answer)

