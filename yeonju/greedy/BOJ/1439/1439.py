import sys

input = sys.stdin.readline

s = list(input().strip())

digit = s[0]
digitArray = [0, 0]
digitArray[int(digit)] += 1

for i in range(len(s)):
    if s[i] == digit:
        continue
    
    digit = s[i]
    digitArray[int(digit)] += 1

print(min(digitArray[0], digitArray[1]))