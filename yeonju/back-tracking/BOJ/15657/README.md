# N과 M (8)

- 문제: https://www.acmicpc.net/problem/15657

## 시도 1: 조합 -> 성공
```python
def main():
    n, m = read_int_list()
    arr = read_int_list()

    arr.sort()
    cbs = combinations_with_replacement(arr, m)

    for c in cbs:
        print(*c)
```
너무 라이브러리 의존적인 것 같아서 다시 풀어봤다.

## 시도2: back-tracking -> 성공
재귀를 이용해서 풀었다.
- 한정조건: 조합의 길이가 m이 될 때
```python
def main():
    n, m = read_int_list()
    arr = read_int_list()

    arr.sort()

    def dfs(idx, combi):
        if len(combi) == m:  # back
            print(*combi)
            return

        for i in range(idx, n):
            dfs(i, combi + [arr[i]])

    dfs(0, [])
```