def solution(m, n, puddles):
    area = [[0] * (m + 1) for _ in range(n + 1)]
    area[1][1] = 1

    for x, y in puddles:
        area[y][x] = -1

    for y in range(1, n + 1):
        for x in range(1, m + 1):
            if area[y][x] == -1:
                area[y][x] = 0
                continue

            area[y][x] += (area[y][x - 1] + area[y - 1][x]) % 1000000007

    return area[n][m]