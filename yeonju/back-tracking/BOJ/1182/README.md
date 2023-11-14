# 부분수열의 합

- 문제: https://www.acmicpc.net/problem/1182

## 시도 1: 백트래킹 -> 성공
부분수열을 구하는 재귀함수를 작성해 품.
```python
def main():
    n, s = read_int_list()
    arr = read_int_list()
    cnt = 0

    def back(idx, subsequence):
        nonlocal cnt

        if idx == n:
            return

        if len(subsequence) != 0 and sum(subsequence) == s:
            cnt += 1

        for i in range(idx + 1, n):
            subsequence.append(arr[i])
            back(i, subsequence)
            subsequence.pop()

    back(-1, [])
    print(cnt)
```
근데, 굳이 부분수열의 원소들을 저장해 둘 필요가 없어보임.
합만 있어도 되지 않나 싶음.
따라서 아래와 같이 수정함.

## 시도2: 백트래킹 -> 성공
```python
def main():
    n, s = read_int_list()
    arr = read_int_list()
    cnt = 0

    def back(idx, subsequence):
        nonlocal cnt

        if idx == n:
            return

        subsequence += arr[idx]

        if subsequence == s:
            cnt += 1

        back(idx + 1, subsequence)
        back(idx + 1, subsequence - arr[idx])

    back(0, 0)
    print(cnt)
```