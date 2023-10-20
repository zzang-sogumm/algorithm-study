import sys
import heapq

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def main():
    n, m, k, x = read_int_list()
    cities = [[] for _ in range(n + 1)]
    distances = [INF] * (n + 1)

    for _ in range(m):
        a, b = read_int_list()
        cities[a].append(b)

    distances[x] = 0
    pq = [(0, x)]

    while pq:
        distance, current_city = heapq.heappop(pq)

        if distance > distances[current_city]:
            continue

        for next_city in cities[current_city]:
            if distances[next_city] > distance + 1:
                distances[next_city] = distance + 1
                heapq.heappush(pq, (distances[next_city], next_city))

    not_found = True
    for i in range(1, n + 1):
        if distances[i] == k:
            not_found = False
            print(i)

    if not_found:
        print(-1)

if __name__ == "__main__":
    main()
