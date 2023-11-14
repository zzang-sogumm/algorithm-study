# IF문 좀 대신 써줘

- 문제: https://www.acmicpc.net/problem/19637

## 시도 1: 이진 탐색 + 딕셔너리 -> 실패

딕셔너리 + 이진 탐색을 이용했는데 시간초과가 났다..

```py
def current_power(powers, i):
    return list(powers.keys())[i]

def current_power_type(powers, i):
    return list(powers.values())[i]

def binary_search(powers, target):
    start = 0
    end = len(powers) - 1
    result = current_power_type(powers, 0)

    while start <= end:
        mid = (start + end) // 2

        if current_power(powers, mid) < target:
            start = mid + 1
        else:
            result = current_power_type(powers, mid)
            end = mid - 1

    return result

def main():
    n, m = read_int_array()
    powers = dict()

    for _ in range(n):
        t, v = read_array()
        v = int(v)

        if v not in powers.keys():
            powers[v] = t

    for _ in range(m):
        strength = read_int()
        result = binary_search(powers, strength)
        print(result)
```

딕셔너리 자료형이 시간이 오래걸리나 싶어서 리스트로 바꿨더니 시간 초과가 그대로 발생했다...

## 시도 2: 이진 탐색 + 리스트 -> 성공

> 정답 확인

```py
def binary_search(powers, target):
    start = 0
    end = len(powers) - 1

    while start <= end:
        mid = (start + end) // 2

        if powers[mid][1] < target:
            start = mid + 1
        else:
            end = mid - 1

    return powers[start][0]

def main():
    n, m = read_int_array()
    powers = []

    for _ in range(n):
        t, v = read_array()
        v = int(v)
        powers.append([t, v])

    for _ in range(m):
        strength = read_int()
        result = binary_search(powers, strength)
        print(result)
```

전투력이 같은 칭호는 걸러주는 작업을 수행하지 않으니, 시간 초과가 사라졌다..!
위에 처럼 작성하더라도, 같은 전투력을 가진 칭호가 여러 개 있을 때 가장 먼저 입력된 칭호 하나만 출력된다.

이는 이진 탐색 중에 target가 powers[mid][1]보다 크거나 같은 경우 end를 재조정하기 때문이다.
이로써 같은 전투력일 때도 가장 앞의 칭호가 선택된다.
