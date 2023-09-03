import sys

input = sys.stdin.readline

def read_str():
    return input().rstrip()

# 괄호 표현식의 값을 계산하는 함수
def calculate_parentheses_value(expression):
    stack = []

    for char in expression:
        if char == '(' or char == '[':
            stack.append(char)
        elif char == ')':
            if not stack:
                return 0  # 스택이 비어있으면 표현식이 유효하지 않음

            top = stack.pop()  # 스택의 맨 위 요소를 꺼냄
            total = 0

            while top != '(':
                if not isinstance(top, int):
                    return 0  # 맨 위 요소가 정수가 아니면 표현식이 유효하지 않음
                total += top
                if not stack:
                    return 0  # 스택이 비어있으면 표현식이 유효하지 않음
                top = stack.pop()  # 여는 괄호를 찾을 때까지 계속해서 꺼냄

            if total == 0:
                stack.append(2)  # total이 0이면 괄호 한 쌍이 있었음을 의미
            else:
                stack.append(2 * total)  # 중첩된 괄호인 경우 total에 2를 곱함
        elif char == ']':
            if not stack:
                return 0  # 스택이 비어있으면 표현식이 유효하지 않음

            top = stack.pop()  # 스택의 맨 위 요소를 꺼냄
            total = 0

            while top != '[':
                if not isinstance(top, int):
                    return 0  # 맨 위 요소가 정수가 아니면 표현식이 유효하지 않음
                total += top
                if not stack:
                    return 0  # 스택이 비어있으면 표현식이 유효하지 않음
                top = stack.pop()  # 여는 대괄호를 찾을 때까지 계속해서 꺼냄

            if total == 0:
                stack.append(3)  # total이 0이면 대괄호 한 쌍이 있었음을 의미
            else:
                stack.append(3 * total)  # 중첩된 대괄호인 경우 total에 3을 곱함
        else:
            return 0  # 문자가 유효한 괄호나 대괄호가 아니면 표현식이 유효하지 않음

    if not all(isinstance(x, int) for x in stack):
        return 0  # 스택에 정수가 아닌 요소가 포함되어 있다면 표현식이 유효하지 않음

    return sum(stack)  # 스택에 있는 모든 정수 요소를 합하여 최종 값을 반환

def main():
    expression = read_str()
    result = calculate_parentheses_value(expression)
    print(result)

if __name__ == "__main__":
    main()
