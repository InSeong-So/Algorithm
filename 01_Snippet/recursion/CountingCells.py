# 주어진 그리드의 크기
N = 8
# Blob이 아닌 픽셀
BACKGROUND_COLOR = 0
# Blob인 픽셀
IMAGE_COLOR = 1
# 이미 횟수를 센 픽셀
ALREADY_COUNTED = 2

grid = [
    [1, 0, 0, 0, 0, 0, 0, 1],
    [0, 1, 1, 0, 0, 1, 0, 0],
    [1, 1, 0, 0, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 1, 0, 0],
    [0, 1, 0, 1, 0, 1, 0, 0],
    [0, 1, 0, 1, 0, 1, 0, 0],
    [1, 0, 0, 0, 1, 0, 0, 1],
    [0, 1, 1, 0, 0, 1, 1, 1],
]

def countCells(x: int, y: int):
    if x < 0 or x >= N or y < 0 or y >= N:
        return 0
    elif grid[x][y] != IMAGE_COLOR:
        return 0
    else:
        grid[x][y] = ALREADY_COUNTED
        return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1) \
            + countCells(x + 1, y + 1) + countCells(x - 1, y) \
            + countCells(x + 1, y) + countCells(x - 1, y - 1) \
            + countCells(x, y - 1) + countCells(x + 1, y - 1)
# 검증
print(countCells(0, 0))