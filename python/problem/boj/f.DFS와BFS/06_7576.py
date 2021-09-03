import sys
sys.setrecursionlimit(10000)
N, M = list(map(int, sys.stdin.readline().split()))
box = []
for _ in range(M):
    box.append(list(map(int, sys.stdin.readline().split())))

# * ========================================================
# * @Title       : 7576
# * @Path        : python\02_Solved\boj\f.DFS와BFS\7576.py
# * @Description :
# * @Date        : 2021-08-06 17:00:26
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, M, box):
    from collections import deque
    # 0 - 익지 않은 토마토, 1 - 익은 토마토, -1 - 벽의 개수
    tomatoes = [0, 0, 0]
    visited = [[False for _ in range(N)] for _ in range(M)]
    growed = deque()

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    for i in range(M):
        for j in range(N):
            tomatoes[box[i][j]] += 1
            if box[i][j] == 1:
                growed.append([i, j])

    if tomatoes[1] == 0:
        print(-1)
    elif tomatoes[0] == 0 and tomatoes[1] != 0:
        print(0)
    else:
        day = 0
        target = deque()
        while growed:
            lx, ly = growed.popleft()
            for i in range(4):
                nx, ny = lx + dx[i], ly + dy[i]
                if nx >= 0 and nx < M and ny >= 0 and ny < N and not visited[nx][ny] and box[nx][ny] == 0:
                    visited[nx][ny] == True
                    box[nx][ny] = box[lx][ly] + 1
                    target.append([nx, ny])
                    tomatoes[0] -= 1
                    tomatoes[1] += 1
            if len(growed) == 0:
                growed = target
                target = deque()
                day += 1
        if tomatoes[0] != 0:
            print(-1)
        else:
            print(day - 1)


solution(N, M, box)


def test_01(capfd):
    N = 6
    M = 4
    box = [
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 1],
    ]
    solution(N, M, box)
    out, err = capfd.readouterr()
    assert out == '8\n'


def test_02(capfd):
    N = 6
    M = 4
    box = [
        [0, -1, 0, 0, 0, 0],
        [-1, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 1],
    ]
    solution(N, M, box)
    out, err = capfd.readouterr()
    assert out == '-1\n'


def test_03(capfd):
    N = 6
    M = 4
    box = [
        [1, -1, 0, 0, 0, 0],
        [0, -1, 0, 0, 0, 0],
        [0, 0, 0, 0, -1, 0],
        [0, 0, 0, 0, -1, 1],
    ]
    solution(N, M, box)
    out, err = capfd.readouterr()
    assert out == '6\n'


def test_04(capfd):
    N = 5
    M = 5
    box = [
        [-1, 1, 0, 0, 0],
        [0, -1, -1, -1, 0],
        [0, -1, -1, -1, 0],
        [0, -1, -1, -1, 0],
        [0, 0, 0, 0, 0],
    ]
    solution(N, M, box)
    out, err = capfd.readouterr()
    assert out == '14\n'


def test_05(capfd):
    N = 2
    M = 2
    box = [
        [1, -1],
        [-1, 1]
    ]
    solution(N, M, box)
    out, err = capfd.readouterr()
    assert out == '0\n'


def test_06(capfd):
    N = 6
    M = 5
    box = [
        [1, 0, 0, 0, 0, 0],
        [-1, -1, -1, -1, -1, -1],
        [-1, 0, 0, 0, 0, 0],
        [-1, 0, 0, 1, 0, 0],
        [-1, 0, 0, 0, 0, 0],
    ]
    solution(N, M, box)
    out, err = capfd.readouterr()
    assert out == '5\n'
