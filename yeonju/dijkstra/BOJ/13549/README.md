# 숨바꼭질 3

- 문제: https://www.acmicpc.net/problem/13549

## 시도 1

> 정답 확인

```py
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
        q.appendleft(now * 2)  # 가장 우선순위가 되기 위해 처음으로 ⭐️

    if 0 <= now + 1 < MAX_LEN and visited[now + 1] == -1:
        visited[now + 1] = visited[now] + 1
        q.append(now + 1)

print(visited[k])
```

- 순간이동 연산이 가장 우선순위가 되어야 하는데 이를 어떻게 구현할 지 감이 안잡혔다.
- dp로 푸려고 했지만, 순간이동을 구현할 아이디어가 떠오르지 않았다.
- 양방향인 deque를 이용하는 방법이 있었다..
