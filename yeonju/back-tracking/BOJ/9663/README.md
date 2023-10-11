# N-Queen

- 문제: https://www.acmicpc.net/problem/9663

전에 풀었는데 모르겠는 이 기분,, 굉장히 별로.

## 시도 1

> 정답확인

퀸의 주변에만 없으면 되는 줄 알았는데, 퀸이 있는 행, 열, 대각선 전체에는 둘 수가 없는 규칙이었다..

```py
def adjacent(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == x - i:
            return False
    return True

def dfs(x):
    global result
    if x == n:
        result += 1
    else:
        for i in range(n):
            row[x] = i
            if adjacent(x): # 행, 열, 대각선에 퀸이 존재하지 않는다면, 계속 진행
                dfs(x + 1)

n = int(input())
row = [0] * n
result = 0

dfs(0)
print(result)
```

^^ 이해시켜주실 분
