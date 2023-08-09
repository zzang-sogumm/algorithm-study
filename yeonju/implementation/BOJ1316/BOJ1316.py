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