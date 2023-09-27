# 효율적인 해킹

- 문제: https://www.acmicpc.net/problem/1325

## 시도 1: dfs -> 시간 초과

<img width='400' src="https://github.com/zzang-sogumm/algorithm-study/assets/97719273/44ab400e-7d4c-44bc-b35d-4cdcca19cd91" />

이 문제는 양방향이 아닌, 단방향이기 때문에 한 쪽만 연결시켜줘야한다.

dfs로 풀었는데,, 왜...시간 초과일까..??.... ㅎㅎ...^^

```py
def dfs(graph, v, visited):
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

    return sum(visited)

def main():
    n, m = read_int_list()
    computers = [[] for _ in range(n + 1)]

    results = [0] * (n + 1)

    for _ in range(m):
        a, b = read_int_list()
        computers[b].append(a)

    for i in range(1, n + 1):
        visited = [False] * (n + 1)
        results[i] = dfs(computers, i, visited)

    max_computers = max(results)

    for i in range(1, n + 1):
        if results[i] == max_computers:
            print(i, end=" ")
```

## 시도 2: bfs -> 시간 초과 ^^

```py
def bfs(graph, n, start):
    visited = [False] * (n + 1)
    visited[start] = True
    count = 1

    queue = deque([start])

    while queue:
        v = queue.popleft()

        for neighbor in graph[v]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True
                count += 1

    return count

def main():
    n, m = read_int_list()
    computers = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = read_int_list()
        computers[b].append(a)

    max_count = 1
    result = []

    for i in range(1, n + 1):
        count = bfs(computers, n, i)
        if count > max_count:
            max_count = count
            result = [i]
        elif count == max_count:
            result.append(i)

    print(*result)
```
