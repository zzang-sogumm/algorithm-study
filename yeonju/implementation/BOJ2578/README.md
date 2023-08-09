# 빙고

- 풀이 유형: 구현

## 1. 처음 푼 코드

> 메모리 113.112MB/128MB 시간 0.116s/1s

```py
import sys
input = sys.stdin.readline

NUM = 5

# 입력받기
game = [list(map(int, input().split())) for _ in range(NUM)]
chk = [[0] * NUM for _ in range(NUM)]

mc = [list(map(int, input().split())) for _ in range(NUM)]

def checkBingo(mm):
    cnt = 0

    # 대각선 검사
    isLeftTopRightBottomBingo = True
    isRightTopLeftBottomBingo = True

    for i in range(5):
        if mm[i][i] == 0:
            isLeftTopRightBottomBingo = False
        if mm[NUM-i-1][i] == 0:
            isRightTopLeftBottomBingo = False

    if isLeftTopRightBottomBingo == True:
        cnt += 1
    if isRightTopLeftBottomBingo == True:
        cnt += 1

    # 행,열 검사
    for i in range(5):
        isRowBingo = True
        isColBingo = True

        for j in range(5):
            if mm[i][j] == 0:
                isRowBingo = False
            if mm[j][i] == 0:
                isColBingo = False

        if isRowBingo == True:
            cnt += 1
        if isColBingo == True:
            cnt += 1

    return cnt >= 3

ans = 0

for i in range(NUM): # 사회자가 부르는 번호 순회
    for j in range(NUM):
        now = mc[i][j]
        ans += 1

        for m in range(NUM):
            for n in range(NUM):
                if game[m][n] == now:
                    chk[m][n] = 1
                    if checkBingo(chk):
                        print(ans)
                        sys.exit()
```

- 개선할 점: 생각중,,
