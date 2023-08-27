import sys

input = sys.stdin.readline
EXIT_SIGNAL = -1

n = int(input())

count = 0

while True:
  if n == 0 or n < 2 : break
  if n % 5 == 0:
    count += n // 5
    n %= 5
  else:
    count += 1
    n -= 2

if n != 0:
   print(EXIT_SIGNAL)
else:
   print(count)