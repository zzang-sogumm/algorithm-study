import sys

# initial setting
input = sys.stdin.readline
def inputIntList():
    return list(map(int, input().split()))
def inputStr():
    return input().rstrip()

# start
n, m = inputIntList()

# 포켓몬 정보를 저장할 딕셔너리 생성
book = {}

# n개의 포켓몬 정보 입력 및 딕셔너리에 저장
for i in range(1, n + 1):
    name = inputStr()
    book[name] = str(i) # 이름으로 번호 조회
    book[str(i)] = name  # 번호로 이름 조회

# m개의 쿼리 수행
for i in range(m):
    q = inputStr()
    print(book[q]) # 쿼리에 해당하는 값을 출력