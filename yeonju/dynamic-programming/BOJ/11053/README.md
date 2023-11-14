# 가장 긴 증가하는 부분 수열

### 풀이1: 완전 탐색 -> 틀림

- 증가할 때마다 +1 해주자.

```py
def main():
    n = read_int()
    a = read_int_array()

    answer = 1
    min_a = a[0]

    for i in range(1, n):
        if a[i] > min_a:
            min_a = a[i]
            answer += 1

    print(answer)
```

- 당연히 맞을리가 없음. `10 5 7 30 40` 처럼 중간부터 시작할 때 틀림

### 풀이2: 답 확인.. dp -> 맞음

```py
def main():
    n = read_int()
    a = read_int_array()
    dp = [1] * n

    for i in range(1, n):
        for j in range(i):
            if a[i] > a[j]:
                dp[i] = max(dp[i], dp[j] + 1)

    print(max(dp))
```
