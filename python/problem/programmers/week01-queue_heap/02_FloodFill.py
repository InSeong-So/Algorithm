from collections import deque


def solution(n, m, images):
    answer = 0

    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    for sy in range(n):
        for sx in range(m):
            if images[sy][sx] == -1:
                continue

            target_color = images[sy][sx]
            queue = deque([(sy, sx)])

            while queue:
                y, x = queue.popleft()

                for dy, dx in directions:
                    py = dy + y
                    px = dx + x
                    if py >= n or py < 0 or px >= m or px < 0:
                        continue
                    if target_color == images[py][px]:
                        images[py][px] = -1
                        queue.append((py, px))
            answer += 1

    return answer


##
# 5: floodfill


def solution(n, m, image):
    # BFS, DFS 사용(FloodFill 알고리즘)
    # BFS는 Queue를 쓰겠다는 것
    answer = 0
    # BFS, DFS 팁 : 탐색할 변수를 미리 담아주면 편함
    directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]

    # sys.maxsize < float('inf')

    for sy in range(n):
        for sx in range(m):
            if image[sy][sx] == float('inf'):
                continue

            target_color = image[sy][sx]
            queue = deque([(sy, sx)])

            while queue:
                y, x = queue.popleft()

                # 사전에 변수를 담지 않는다면 아래 로직을 길게 적어야함
                # if y + 1 < n and image[y + 1][x] == target_color:
                #     image[y + 1][x] = float('inf')
                #     queue.append((y+1, x))
                # elif...

                for dy, dx in directions:
                    py = y + dy
                    px = x + dx
                    if px >= m or px < 0 or py >= n or py < 0:
                        continue
                    if image[py][px] == target_color:
                        image[py][px] = float('inf')
                        queue.append((py, px))

            answer += 1
    return answer
