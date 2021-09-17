from collections import deque


def solution(m, n, infests, vaccinateds):
    answer = 0

    # 상하좌우 좌표 선언
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    # 사무실
    space = [[0] * n for _ in range(m)]

    vaccins = deque(vaccinateds)
    queue = deque(infests)

    # 백신 위치 표시
    while vaccins:
        y, x = vaccins.popleft()
        space[y-1][x-1] = 1

    # 전염병 진행
    while True:
        temp = deque([])
        while queue:
            y, x = queue.popleft()

            space[y-1][x-1] = -1

            for dy, dx in directions:
                py = (y - 1) + dy
                px = (x - 1) + dx
                if py >= m or py < 0 or px >= n or px < 0:
                    continue
                if space[py][px] == 0:
                    space[py][px] = -1
                    temp.append((py+1, px+1))

        if not temp:
            break
        else:
            queue = temp
            answer += 1

    for sy in range(m):
        for sx in range(n):
            if space[sy][sx] == 0:
                return -1

    return answer
