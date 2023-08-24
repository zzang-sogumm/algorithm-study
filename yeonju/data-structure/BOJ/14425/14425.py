import sys

# initial setting
input = sys.stdin.readline
def inputIntList():
    return list(map(int, input().split()))
def inputStr():
    return input().rstrip()

# start
n, m = inputIntList()

# 문자열을 저장할 딕셔너리 생성
book = {}

# 결과 카운터 초기화
cnt = 0

# n개의 문자열을 읽어서 딕셔너리에 저장
for _ in range(n):
    string = inputStr()
    book[string] = True

# 두 번째 입력 목록에 있는 문자열이 딕셔너리에 있는지 확인
for _ in range(m):
    q = inputStr()
    if q in book:
        cnt += 1

print(cnt)