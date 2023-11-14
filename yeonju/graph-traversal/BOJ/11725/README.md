# 트리의 부모 찾기

- 문제: https://www.acmicpc.net/problem/11725

## 시도 1: bfs -> 시간초과

- queue에 넣으면서, 탐색해나가다 루트 노드인 1번 노드를 만나면 멈추고 직전 부모(queue[1])를 반환하려고 함..!
  <img width="400" src="https://github.com/zzang-sogumm/algorithm-study/assets/97719273/2265bb43-6828-4d94-9c40-3d935666b0ae" />
- 그러나 어림도 없이 시간초과,,
  <br />

```py
def bfs(graph, start, visited):
    queue = [start]
    visited[start] = True
    idx = 0

    while idx < len(visited):
        v = queue[idx]

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

            if i == 1:
                return queue[1]

        idx += 1

    return 1

def main():
    n = read_int()
    trees = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        tree1, tree2 = read_int_list()
        trees[tree1].append(tree2)
        trees[tree2].append(tree1)

    for i in range(2, n + 1):
        visited = [False] * (n + 1)
        result = bfs(trees, i, visited)
        print(result)
```

## 시도 2: bfs -> 성공

> 한참 고민하다가 정답을 봤다..

부모 노드가 아닌, 루트 노드를 반환하는 방법밖에 생각이 안났는데 아래 별표쳐 둔 곳이 포인트였다..!

```py
def bfs(graph, start):
    n = len(graph) - 1
    parent = [0] * (n + 1)
    visited = [False] * (n + 1)

    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()

        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                parent[neighbor] = current # ⭐️⭐️⭐️
                queue.append(neighbor)

    return parent

def main():
    n = read_int()
    trees = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = read_int_list()
        trees[a].append(b)
        trees[b].append(a)

    parents = bfs(trees, 1)

    for i in range(2, n + 1):
        print(parents[i])
```
