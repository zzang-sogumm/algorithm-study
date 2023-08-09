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