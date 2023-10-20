# 특정 거리의 도시 찾기

- 문제: https://www.acmicpc.net/problem/18352

## 시도 1: bfs -> 시간초과

```py
def main():
    n, m, k, x = read_int_list()
    cities = [[] for _ in range(n + 1)]
    distances = [INF] * (n + 1)

    for _ in range(m):
        a, b = read_int_list()
        cities[a].append(b)

    def bfs(start):
        nonlocal cities
        nonlocal distances

        queue = deque([(start, 0)])
        visited = [False] * (n + 1)
        visited[start] = True

        while queue:
            current_city, depth = queue.popleft()
            distances[current_city] = depth

            for next_city in cities[current_city]:
                if not visited[next_city]:
                    visited[next_city] = True
                    queue.append((next_city, depth + 1))

    bfs(x)

    not_found = True
    for i in range(1, n + 1):
        if distances[i] == k:
            not_found = False
            print(i)

    if not_found:
        print(-1)
```

## 시도2: 다익스트라 -> 성공

> 정답 확인...

```py
def main():
    n, m, k, x = read_int_list()
    cities = [[] for _ in range(n + 1)]
    distances = [INF] * (n + 1)

    for _ in range(m):
        a, b = read_int_list()
        cities[a].append(b)

    distances[x] = 0
    pq = [(0, x)]

    while pq:
        distance, current_city = heapq.heappop(pq)

        if distance > distances[current_city]:
            continue

        for next_city in cities[current_city]:
            if distances[next_city] > distance + 1:
                distances[next_city] = distance + 1
                heapq.heappush(pq, (distances[next_city], next_city))

    not_found = True
    for i in range(1, n + 1):
        if distances[i] == k:
            not_found = False
            print(i)

    if not_found:
        print(-1)
```
