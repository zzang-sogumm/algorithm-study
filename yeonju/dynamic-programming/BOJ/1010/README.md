# 다리 놓기

## 풀이 방법 1: 조합 -> 틀림 (시간 초과)

- $_{2}\mathrm{C}_{2} = 1$
- $_{5}\mathrm{C}_{1} = 5$
- $_{29}\mathrm{C}_{13} = 67863915$

```py
def main():
    t = read_int()

    for _ in range(t):
        n, m = read_int_list()
        print(len(list(combinations(range(m), n))))
```

## 풀이 방법 2: 조합 (재귀함수 이용) -> 맞음

```py
def factorial(n):
    if n > 1:
        return n * factorial(n - 1)
    else:
        return 1

def main():
    t = read_int()

    for _ in range(t):
        n, m = read_int_list()
        combination = factorial(m) // (factorial(m - n) * factorial(n))
        print(combination)
```
