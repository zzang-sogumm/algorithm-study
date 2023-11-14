# 외판원 순회2

- 문제: https://www.acmicpc.net/problem/10971

## 시도 1

1. visited 배열을 만들어서, [0, 1, 2, 3] 처럼 경로를 넣어줌
2. 길이가 n이 되면, 최소 비용 계산
   1. `3 -> 0` 으로 가는 것도 계산해줘야 함
   2. 주의: `3 -> 0`으로 이동할 수 없으면, 불가능한 경로
3. 백트래킹 조건: 길이가 n이 되기 전에 해당 경로가 최소 비용을 이미 넘어버리면 그 경로는 더 이상 탐색하지 않아도 됨.

```py
def main():
    n = read_int()
    w = [[] for _ in range(n)]
    min_cost = INF

    for i in range(n):
        w[i] = read_int_list()

    def dfs(visited, current_path, current_cost):
            nonlocal min_cost

            if current_cost > min_cost:
                return

            if len(visited) == n:
                last_point = w[current_path[-1]][current_path[0]]

                if last_point == 0: # 마지막 지점에서 첫 지점으로 못 돌아올 경우
                    return

                new_cost = current_cost + last_point
                min_cost = min(new_cost, min_cost)
                return

            for i in range(n):
                new_point = w[current_path[-1]][i]

                if i not in visited and new_point != 0:
                    new_visited = visited + [i]
                    new_path = current_path + [i]
                    new_cost = current_cost + w[current_path[-1]][i]
                    dfs(i, new_visited, new_path, new_cost)

    for i in range(n):
        start_city = i
        dfs([start_city], [start_city], 0)

    print(min_cost)
```

- 개선해야 할 점
  - visited, current_path가 동일한 배열인데 왜 저렇게 짰을까. 역시 무지성 코딩은 위험하다.

## 시도 2 -> 정답

```py
def main():
    n = read_int()
    w = [[] for _ in range(n)]
    min_cost = INF

    for i in range(n):
        w[i] = read_int_list()

    def dfs(visited, current_cost):
            nonlocal min_cost
            current_city = visited[-1]

            if current_cost > min_cost:
                return

            if len(visited) == n:
                first_city = visited[0]
                last_point = w[current_city][first_city]

                if last_point == 0: # 마지막 지점에서 첫 지점으로 못 돌아올 경우
                    return

                new_cost = current_cost + last_point
                min_cost = min(new_cost, min_cost)
                return

            for next_city in range(n):
                new_point_cost = w[current_city][next_city]

                if next_city not in visited and new_point_cost != 0:
                    new_visited = visited + [next_city]
                    new_cost = current_cost + new_point_cost
                    dfs(new_visited, new_cost)

    for start_city in range(n):
        dfs([start_city], 0)

    print(min_cost)
```

- 추가로 개선한 점
  의미 있는 변수명을 사용하려고 노력했다.
  visited[0], visited[-1]을 써도 상관없겠지만, first_city, current_city로 이름을 지어주어 좀 더 직관적으로 와닿을 수 있게끔 함.
