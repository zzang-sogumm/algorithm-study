import sys

input = sys.stdin.readline

def read_str():
    return input().rstrip()

def count_iron_stick_pieces(stick_arrangement):
    stack = []  # 여는 괄호를 추적하기 위한 스택
    total_pieces = 0  # 총 쇠막대기 조각 수 초기화

    for i in range(len(stick_arrangement)):
        if stick_arrangement[i] == '(':  # 여는 괄호를 만나면 스택에 추가
            stack.append('(')
        else:
            stack.pop()  # 닫는 괄호는 짝이 맞는 여는 괄호를 제거

            if stick_arrangement[i - 1] == '(':  # 직전 문자가 여는 괄호라면 레이저
                total_pieces += len(stack)  # 스택에 남아있는 쇠막대기 수를 조각으로 추가
            else:
                total_pieces += 1  # 여는 괄호와 짝인 닫는 괄호를 만나면 쇠막대기의 끝

    return total_pieces

def main():
    stick_arrangement = read_str()
    result = count_iron_stick_pieces(stick_arrangement)
    print(result)

if __name__ == "__main__":
    main()
