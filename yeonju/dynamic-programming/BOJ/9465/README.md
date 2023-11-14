# 스티커

## 풀이방법 1: dp => 맞음

```py
def main():
    t = read_int()

    for _ in range(t):
        n = read_int()
        stickers = [read_int_list() for _ in range(2)]

        dp = [[0] * (n + 3) for _ in range(2)]
        dp[0][0] = stickers[0][0]
        dp[1][0] = stickers[1][0]

        if n >= 2:
            dp[0][1] = dp[1][0] + stickers[0][1]
            dp[1][1] = dp[0][0] + stickers[1][1]

        for i in range(2, n):
            dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i]
            dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i]

        print(max(dp[0][n - 1], dp[1][n - 1]))
```

## 리팩토링

- dp 배열에 바로 입력받기

```py
def main():
    t = read_int()

    for _ in range(t):
        n = read_int()
        dp = [read_int_list() for _ in range(2)]

        if n >= 2:
            dp[0][1] += dp[1][0]
            dp[1][1] += dp[0][0]

        for i in range(2, n):
            dp[0][i] += max(dp[1][i - 1], dp[1][i - 2])
            dp[1][i] += max(dp[0][i - 1], dp[0][i - 2])

        result = max(dp[0][n - 1], dp[1][n - 1])
        print(result)
```
