import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    # 퇴사까지 남은 일수 입력 받기
    n = read_int()

    # dp 테이블 초기화
    dp = [0] * (n + 1)

    # 스케줄표 저장
    schedules = [read_int_list() for _ in range(n)]

    # Bottom-up dynamic programming
    for i in range(n):
        # 현재 날짜의 상담 기간과 이익을 읽어옴
        t, p = schedules[i]

        # 다음 상담이 끝나는 날짜를 계산
        next_day = i + t

        # 만약 다음 날짜가 퇴사일을 넘어가지 않는다면
        if next_day <= n:
            # 다음 날짜의 DP 값을 현재까지의 최대 이익과 현재 상담 이익을 더한 값 중에서 더 큰 값으로 업데이트
            dp[next_day] = max(dp[next_day], dp[i] + p)

        # 다음 날짜를 고려하지 않는 경우, 현재 날짜의 DP 값을 그대로 복사
        dp[i + 1] = max(dp[i + 1], dp[i])

    # 퇴사일에 얻을 수 있는 최대 이익 출력
    print(dp[n])

if __name__ == "__main__":
    main()

