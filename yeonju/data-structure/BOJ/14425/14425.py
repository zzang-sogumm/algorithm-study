import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_str():
    return input().rstrip()

def main():
    n, m = read_int_list()

    # 문자열을 저장할 딕셔너리 생성
    book = {}

    # 결과 카운터 초기화
    cnt = 0

    # n개의 문자열을 읽어서 딕셔너리에 저장
    for _ in range(n):
        string = read_str()
        book[string] = True

    # 두 번째 입력 목록에 있는 문자열이 딕셔너리에 있는지 확인
    for _ in range(m):
        q = read_str()
        if q in book:
            cnt += 1

    print(cnt)

if __name__ == "__main__":
    main()