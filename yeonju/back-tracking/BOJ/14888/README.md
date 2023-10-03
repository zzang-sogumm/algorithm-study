# 연산자 끼워넣기

- 문제: https://www.acmicpc.net/problem/14888

연산자를 먼저 배열로 만들어야 하나 등등,, 고민하다가 답을 확인했다.

## 시도 1 -> 정답

> 정답확인

풀이를 보자마자 납득이 갔다,,

```py
def main():
    n = read_int()
    a = read_int_list()
    plus, minus, multiply, divide = read_int_list()

    maximum = -INF
    minimum = INF

    def dfs(depth, total, plus, minus, multiply, divide):
        nonlocal maximum, minimum

        if depth == n:
            maximum = max(total, maximum)
            minimum = min(total, minimum)
            return

        if plus:
            dfs(depth + 1, total + a[depth], plus - 1, minus, multiply, divide)
        if minus:
            dfs(depth + 1, total - a[depth], plus, minus - 1, multiply, divide)
        if multiply:
            dfs(depth + 1, total * a[depth], plus, minus, multiply - 1, divide)
        if divide:
            dfs(depth + 1, int(total / a[depth]), plus, minus, multiply, divide - 1)

    dfs(1, a[0], plus, minus, multiply, divide)
    print(maximum)
    print(minimum)
```
