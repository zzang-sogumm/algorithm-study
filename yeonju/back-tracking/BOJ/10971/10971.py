import sys

INF = float('inf')

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n = read_int()
    w = [[] for _ in range(n)]
    min_cost = INF

    for i in range(n):
        w[i] = read_int_list()

    def dfs(visited, current_cost):
            nonlocal min_cost
            current_city = visited[-1]

            if current_cost > min_cost:
                return
            
            if len(visited) == n:
                first_city = visited[0]
                last_point = w[current_city][first_city]

                if last_point == 0: # 마지막 지점에서 첫 지점으로 못 돌아올 경우
                    return
                
                new_cost = current_cost + last_point
                min_cost = min(new_cost, min_cost)
                return
            
            for next_city in range(n):
                new_point_cost = w[current_city][next_city]
                
                if next_city not in visited and new_point_cost != 0:
                    new_visited = visited + [next_city]
                    new_cost = current_cost + new_point_cost
                    dfs(new_visited, new_cost)

    for start_city in range(n):
        dfs([start_city], 0)
    
    print(min_cost)

if __name__ == "__main__":
    main()
