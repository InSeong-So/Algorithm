# 미로의 크기
N = 8
# 통로
PATHWAY_VALUE = 0
# 벽
WALL_VALUE = 1
# 방문(검사)했으며 출구까지의 경로에 있지 않다고 판별된 CELL
BLOCKED_VALUE = 2
# 방문(검사)했으며 아직 출구로 가는 경로가 될 가능성이 있는 CELL
PATH_VALUE = 3

maze = [
    [0, 0, 0, 0, 0, 0, 0, 1],
    [0, 1, 1, 0, 1, 1, 0, 1],
    [0, 0, 0, 1, 0, 0, 0, 1],
    [0, 1, 0, 0, 1, 1, 0, 0],
    [0, 1, 1, 1, 0, 0, 1, 1],
    [0, 1, 0, 0, 0, 1, 0, 1],
    [0, 0, 0, 1, 0, 0, 0, 1],
    [0, 1, 1, 1, 0, 1, 0, 0],
]


def findMazePath(x: int, y: int):
    # x-1, y-1 등 검사하므로 x, y의 음수 여부를 체크하는 로직이 필요
    if x < 0 or y < 0 or x >= N or y >= N:
        return False
    elif maze[x][y] != PATHWAY_VALUE:
        return False
    elif x == N - 1 and y == N - 1:
        maze[x][y] = PATH_VALUE
        return True
    else:
        maze[x][y] = PATH_VALUE
        if findMazePath(x - 1, y) or findMazePath(x, y + 1) or findMazePath(x + 1, y) or findMazePath(x, y - 1):
            return True
        maze[x][y] = BLOCKED_VALUE
        return False


print(maze)
# 첫 번째 좌표 호출로 시작
findMazePath(0, 0)
print(maze)
