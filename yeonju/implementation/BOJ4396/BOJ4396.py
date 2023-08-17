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

