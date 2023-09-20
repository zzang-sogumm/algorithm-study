# 1로 만들기

```
dp[1] = 0
dp[2] = 1
dp[3] = 1
dp[4] = 2 (4 -> 3 -> 1)
dp[5] = 3 (5 -> 4 -> 2 -> 1)
dp[6] = 2 (6 -> 2 -> 1)
dp[7] = 3 (7 -> 6 -> 3 -> 1)
dp[8] = 3 (8 -> 4 -> 2 -> 1)
dp[9] = 2 (9 -> 3 -> 1)
dp[10] = 3 (10 -> 9 -> 3 -> 1)
dp[11] = 4 (11 -> 10 -> 9 -> 3 -> 1)
dp[12] = 3 (12 -> 4 -> 2 -> 1)
dp[99] = 6 (99 -> 33 -> 11 -> 10 -> 9 -> 3 -> 1)
```

### 풀이방법1: dp -> 틀림

```py
def main():
    n = read_int()
    dp = [0] * (n + 3)

    dp[1] = 1 # 틀린 부분.... 초기화를 잘못했던 것.......
    dp[2] = 1
    dp[3] = 1

    for i in range(4, n + 1):
        arr = []
        if i % 3 == 0:
            arr.append(dp[i // 3] + 1)
        if i % 2 == 0:
            arr.append(dp[i // 2] + 1)
        arr.append(dp[i - 1] + 1)

        dp[i] = min(arr)

    print(dp[n])
```

### 풀이방법2: dp -> 맞음

```py
def main():
    n = read_int()
    dp = [0] * (n + 3)

    dp[1] = 0 # 고침
    dp[2] = 1
    dp[3] = 1

    for i in range(4, n + 1):
        arr = []
        if i % 3 == 0:
            arr.append(dp[i // 3] + 1)
        if i % 2 == 0:
            arr.append(dp[i // 2] + 1)
        arr.append(dp[i - 1] + 1)

        dp[i] = min(arr)

    print(dp[n])
```

### 리팩토링

```py
def main():
    n = read_int()

    dp = [0] * (n + 3)
    dp[2] = 1
    dp[3] = 1

    for i in range(4, n + 1):
        operations = [dp[i - 1] + 1]

        if i % 3 == 0:
            operations.append(dp[i // 3] + 1)
        if i % 2 == 0:
            operations.append(dp[i // 2] + 1)

        dp[i] = min(operations) # 가능한 연산 중에서 최소 연산 횟수를 선택하여 dp 테이블에 저장합니다.

    print(dp[n])
```
