# 🐜 기적의 매매법 🐜

- 풀이 유형: 구현

## 1. 처음 푼 코드

> 메모리 113.112MB/512MB, 시간 0.120s/1s

```py
import math

money = int(input())
jh, sm = [money, 0], [money, 0] # [보유 현금, 보유 주식 수]

stocks = list(map(int, input().split()))

for i in range(0, len(stocks)):
    # 준현
    if jh[0] >= stocks[i]:
        # 전량 매수
        n = math.floor(jh[0] / stocks[i]) # 살 수 있는 주식수
        jh[1] += n
        jh[0] = jh[0] % stocks[i]

    if i < 3:
        continue

    # 성민
    if stocks[i] > stocks[i-1] > stocks[i-2] > stocks[i-3]:
        # 전량 매도
        sm[0] += sm[1] * stocks[i]
        sm[1] = 0
    elif stocks[i] < stocks[i-1] < stocks[i-2] < stocks[i-3]:
        # 전량 매수
        n = math.floor(sm[0] / stocks[i])
        sm[1] += n
        sm[0] = sm[0] % stocks[i]


total_jh = jh[0] + stocks[-1] * jh[1]
total_sm = sm[0] + stocks[-1] * sm[1]

if total_jh > total_sm:
    print('BNP')
elif total_jh<total_sm:
    print('TIMING')
else:
    print('SAMESAME')
```

- 개선점: 공통 로직은 함수로 분리하자. 추상화를 해보자.

  - 공통 로직: 전량 매수, 전량 매도, 현재 가치 계산

- math 함수를 import하지 말고 몫만 구하는 연산자를 사용하자.

## 2. 개선한 코드

> 메모리 113112KB, 시간 120ms

```py
money = int(input())
jh, sm = [money, 0], [money, 0]

stocks = list(map(int, input().split()))
l = len(stocks)

def totalPurchase(currentStock, person):
    n = person[0] // currentStock # 살 수 있는 주식 수
    person[1] += n # 보유 주식 수 증가
    person[0] = person[0] % currentStock # 남은 현금

def totalSell(currentStock, person):
    person[0] += person[1] * currentStock # 전량 매도
    person[1] = 0 # 보유 주식 수 0개

def getCurrentValue(currentStock, person):
    return person[0] + currentStock * person[1]

for i in range(0, l):
    # 준현
    if jh[0] >= stocks[i]:
        totalPurchase(stocks[i], jh)

    # 성민
    if i < 3:
        continue
    if stocks[i] > stocks[i-1] > stocks[i-2] > stocks[i-3]:
        totalSell(stocks[i], sm)
    elif stocks[i] < stocks[i-1] < stocks[i-2] < stocks[i-3]:
        totalPurchase(stocks[i], sm)


total_jh = getCurrentValue(stocks[-1], jh)
total_sm = getCurrentValue(stocks[-1], sm)

if total_jh > total_sm:
    print('BNP')
elif total_jh < total_sm:
    print('TIMING')
else:
    print('SAMESAME')
```
