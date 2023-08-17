# 그룹 단어 체커

- 풀이 유형: 구현

## 1. 처음 푼 풀이

> 메모리: 114.488MB/127MB 시간 0.149s/1s

- idea: 이전 알파벳과 달라지는 순간을 포착하자!

```py
import sys
input = sys.stdin.readline

n = int(input())
ans = 0

for i in range(n):
    word = input().strip()
    word = list(word)

    set_word = list(set(word)) # set을 하여 중복 제거한 배열

    group_word = [word[0]] # 그룹 단어 확인 배열 생성
    for j in range(1, len(word)):
        if word[j] != word[j-1]: # 이전 알파벳과 다를 때 배열에 추가
            group_word.append(word[j])

    # set을 하여 중복을 제거한 배열 == 그룹 단어로 변환한 배열의 길이가 같다면 진짜 그룹 배열
    if len(set_word) == len(group_word):
        ans += 1

print(ans)
```

## 2. 다른 풀이

```py
모두가 그룹 단어라고 가정

if 이전 단어와 같다면:
    continue
elif 이전 단어와 달라졌을 때, 이후에도 그 단어가 있다면:
    그룹 단어 수 감소
    break
```

```py
import sys
input = sys.stdin.readline

n = int(input())
ans = n

for i in range(n):
    word = input().strip()
    word = list(word)

    for j in range(0, len(word)-1):
        if word[j] == word[j+1]:
            continue
        elif word[j] in word[j+1:]:
            ans -= 1
            break

print(ans)
```
