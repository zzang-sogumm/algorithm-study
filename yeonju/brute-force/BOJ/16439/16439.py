from itertools import combinations
import sys

input = sys.stdin.readline
INF = int(1e9)

def read_input_list():
    return list(map(int, input().split()))

def main():
    n, m = read_input_list()

    a = [] # 회원들의 만족도 저장
    for _ in range(n):
        a.append(read_input_list())

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

if __name__ == "__main__":
    main()
