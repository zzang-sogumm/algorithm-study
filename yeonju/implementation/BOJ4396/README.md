# 지뢰찾기

- 풀이 유형: 구현

## 1. 처음 푼 코드

ㅋ.ㅋ 풀기 싫었나 봅니다.

> 메모리 113.112MB/128MB 시간 0.112s/1s

```py
import sys
input = sys.stdin.readline

n = int(input())
game = [list(input().strip()) for _ in range(n)]
user = [list(input().strip()) for _ in range(n)]

# 주위에 지뢰 수 측정
def checkAroundBomb(mm, max_n, i, j):
    cnt = 0
    if i - 1 >= 0:
        if j - 1 >= 0 and mm[i - 1][j - 1] == '*':
            cnt += 1
        if mm[i - 1][j] == '*':
            cnt += 1
        if j + 1 < max_n and mm[i - 1][j + 1] == '*':
            cnt += 1
    if j - 1 >= 0 and mm[i][j - 1] == '*':
        cnt += 1
    if j + 1 < max_n and mm[i][j + 1] == '*':
        cnt += 1
    if i + 1 < max_n:
        if j - 1 >= 0 and mm[i + 1][j - 1] == '*':
            cnt += 1
        if mm[i + 1][j] == '*':
            cnt += 1
        if j + 1 < max_n and mm[i + 1][j + 1] == '*':
            cnt += 1
    return cnt


ans = []
openBomb = False

for i in range(n):
    line = ''
    for j in range(n):
        if user[i][j] == '.': # 유저가 클릭하지 않은 곳
            line += '.'
        else:
            line += str(checkAroundBomb(game, n, i, j)) # 유저가 클릭한 곳은 지뢰 개수 측정

            if(game[i][j] == '*'): # 지뢰밟음
                openBomb = True

    ans.append(list(line))

# 결과 출력
for i in range(n):
    for j in range(n):
        if openBomb and game[i][j] == '*': # 지뢰를 밟았다면 지뢰는 다 *로
            ans[i][j] = '*'

    print(''.join(ans[i]))

```

- 개선할 점
  - 방향 측정에서 너무 중복되는 코드가 많다.

## 2. 개선한 코드

- 탐색할 방향의 인덱스를 dx, dy 배열로 만들어둠

> 메모리 113.112MB/128MB 시간 0.128s/1s

```py
import sys
input = sys.stdin.readline

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

n = int(input())
game = [list(input().strip()) for _ in range(n)]
user = [list(input().strip()) for _ in range(n)]

# 주위에 지뢰 수 측정
def checkAroundBomb(mm, max_n, i, j):
    cnt = 0

    for n in range(8):
        nx = i + dx[n]
        ny = j + dy[n]

        if nx < 0 or nx >= max_n or ny < 0 or ny >= max_n:
            continue

        if mm[nx][ny] == '*':
            cnt += 1

    return cnt


ans = []
openBomb = False

for i in range(n):
    line = ''
    for j in range(n):
        if user[i][j] == '.': # 유저가 클릭하지 않은 곳
            line += '.'
        else:
            line += str(checkAroundBomb(game, n, i, j)) # 유저가 클릭한 곳은 지뢰 개수 측정

            if(game[i][j] == '*'): # 지뢰밟음
                openBomb = True

    ans.append(list(line))

# 결과 출력
for i in range(n):
    for j in range(n):
        if openBomb and game[i][j] == '*': # 지뢰를 밟았다면 지뢰는 다 *로
            ans[i][j] = '*'

    print(''.join(ans[i]))

```
