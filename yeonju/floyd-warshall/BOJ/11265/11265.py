import sys

input = sys.stdin.readline

def read_int_list():
    return list(map(int, input().split()))

def read_int():
    return int(input())

def main():
    n, m = read_int_list()
    party_rooms = [[] for _ in range(n)]

    for i in range(n):
        party_rooms[i] = read_int_list()
    
    for k in range(n):
        for a in range(n):
            for b in range(n):
                party_rooms[a][b] = min(party_rooms[a][b], party_rooms[a][k] + party_rooms[k][b])

    for i in range(m):
        a, b, c = read_int_list()
        if party_rooms[a - 1][b - 1] <= c:
            print("Enjoy other party")
        else:
            print("Stay here")

if __name__ == "__main__":
    main()
