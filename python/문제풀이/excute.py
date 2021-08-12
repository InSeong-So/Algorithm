# N = int(input())


def solution(N):
    matrix = [[' ' for _ in range(N)] for _ in range(N)]

    def stars(x, y, sz):
        if sz == 1:
            matrix[x][y] = '*'
            return
        for i in range(3):
            for j in range(3):
                if i != 1 or j != 1:
                    stars(x + sz // 3 * i, y + sz // 3 * j, sz // 3)
    stars(0, 0, N)
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            print(matrix[i][j], end="")
        print()


solution(27)
