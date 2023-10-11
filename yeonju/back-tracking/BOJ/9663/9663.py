def promising(x):
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
            if promising(x): # 행, 열, 대각선에 퀸이 존재하지 않는다면, 계속 진행
                dfs(x + 1)

n = int(input())
row = [0] * n
result = 0

dfs(0)
print(result)