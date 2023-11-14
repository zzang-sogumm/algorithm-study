import sys
from itertools import permutations

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def count_strike_and_ball(guess, number):
    # 스트라이크와 볼의 개수를 계산하는 함수
    strike_count = sum(1 for i, j in zip(guess, number) if i == j)
    ball_count = sum(1 for i in guess if i in number) - strike_count
    return strike_count, ball_count

def main():
    n = read_int()
    available_numbers = list(permutations('123456789', 3))

    for _ in range(n):
        guess, strike, ball = read_int_list()
        guess = list(str(guess))
        remaining_numbers = []

        for number in available_numbers:
            strike_count, ball_count = count_strike_and_ball(guess, number)

            # 주어진 스트라이크와 볼 개수와 일치하는 숫자를 남김
            if strike == strike_count and ball == ball_count:
                remaining_numbers.append(number)

        available_numbers = remaining_numbers
    
    # 남은 가능한 숫자의 개수 출력
    print(len(available_numbers))

if __name__ == "__main__":
    main()
