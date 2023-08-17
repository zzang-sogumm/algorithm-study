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