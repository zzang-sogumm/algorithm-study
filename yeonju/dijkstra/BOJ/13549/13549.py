import sys
from collections import deque

input = sys.stdin.readline
MAX_LEN = 100001


def read_int_list():
    return list(map(int, input().split()))


n, k = read_int_list()
q = deque([n])
visited = [-1 for _ in range(MAX_LEN)]
visited[n] = 0

while q:
    now = q.popleft()

    if 0 <= now - 1 < MAX_LEN and visited[now - 1] == -1:
        visited[now - 1] = visited[now] + 1
        q.append(now - 1)

    if 0 < now * 2 < MAX_LEN and visited[now * 2] == -1:  # 순간이동
        visited[now * 2] = visited[now]
        q.appendleft(now * 2)  # 가장 우선순위가 되기 위해 처음으로

    if 0 <= now + 1 < MAX_LEN and visited[now + 1] == -1:
        visited[now + 1] = visited[now] + 1
        q.append(now + 1)

print(visited[k])
