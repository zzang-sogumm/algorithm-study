import sys

input = sys.stdin.readline

EXIT_SIGNAL = -1

board = input()
answer = ''

i = 0

if len(board) == 1:
    if board[0] == '.':
        print(board[0])
    else:
        print(EXIT_SIGNAL)
else:
    while i < len(board):
        if board[i] == '.':
            answer += '.'
            i += 1
        elif board[i:i+4] == 'XXXX':
            answer += 'AAAA'
            i += 4
        elif board[i:i+2] == 'XX':
            answer += 'BB'
            i += 2
        else:
            answer = EXIT_SIGNAL
            break

    if answer == EXIT_SIGNAL:
        print(EXIT_SIGNAL)
    else:
        print(answer)