import sys

input = sys.stdin.readline


def read_int_list():
    return list(map(int, input().split()))


def read_int():
    return int(input())


# 미세먼지 확산
def spread(home, r, c):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    added_dust = [[0] * c for _ in range(r)] # 틀렸던 부분: 바로바로 미세먼지 양을 갱신해줬었었음,,

    for x in range(r):
        for y in range(c):
            if home[x][y] <= 0:
                continue

            dust = home[x][y] // 5
            removed_dust = 0

            for i in range(4):
                nx = dx[i] + x
                ny = dy[i] + y

                if nx < 0 or ny < 0 or nx >= r or ny >= c: # 칸이 없는 곳
                    continue
                
                if home[nx][ny] == -1: # 공기청정기가 있는 곳
                    continue
                
                added_dust[nx][ny] += dust
                removed_dust += dust

            home[x][y] -= removed_dust
    
    for x in range(r):
        for y in range(c):
            home[x][y] += added_dust[x][y]


# 공기청정기 위치 찾기
def find_air_cleaner(home, r):
    air_cleaner_start_idx = 0

    for i in range(r):
        if home[i][0] == -1:
            air_cleaner_start_idx = i
            break
    
    return [air_cleaner_start_idx, air_cleaner_start_idx + 1]


# 공기청정기 작동
def air_cleaner(home, r, c, type):
    [top, bottom] = find_air_cleaner(home, r)

    if type == 'top':
        # 확산 순서: 동 -> 북 -> 서 -> 남
        dx = [0, -1, 0, 1]
        dy = [1, 0, -1, 0]
        x, y = top, 1
        start_idx = top
    else:
        # 확산 순서: 동 -> 남 -> 서 -> 북
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        x, y = bottom, 1
        start_idx = bottom

    direction = 0
    before = 0

    while True:
        if x == start_idx and y == 0:
            break

        nx = x + dx[direction]
        ny = y + dy[direction]

        if not 0 <= nx < r or not 0 <= ny < c:
            direction += 1
            continue
            
        home[x][y], before = before, home[x][y]
        x, y = nx, ny


def main():
    r, c, t = read_int_list()
    home = []

    for _ in range(r):
        home.append(read_int_list())

    for _ in range(t):
        spread(home, r, c)
        air_cleaner(home, r, c, 'top')
        air_cleaner(home, r, c, 'bottom')

    result = 0
    for i in range(r) :
        for j in range(c) :
            if home[i][j] > 0 :
                result += home[i][j]
    
    print(result)

if __name__ == "__main__":
    main()
