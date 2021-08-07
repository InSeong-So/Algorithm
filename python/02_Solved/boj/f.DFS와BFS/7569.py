import sys
N, M, H = list(map(int, sys.stdin.readline().split()))
box = []
for _ in range(H):
    floor = []
    for _ in range(M):
        floor.append(list(map(int, sys.stdin.readline().split())))
    box.append(floor)

# * ========================================================
# * @Title       : 7569
# * @Path        : python\02_Solved\boj\f.DFS와BFS\7569.py
# * @Description :
# * @Date        : 2021-08-07 09:41:04
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, M, H, box):
    from collections import deque

    visited = [[[False for _ in range(N)] for _ in range(M)] for _ in range(H)]
    tomatoes = [0, 0, 0]
    growed = deque()

    dz = [-1, 0, 1]
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    def check(z, x, y, cnt):
        visited[z][x][y] = True
        box[z][x][y] = cnt
        target.append([z, x, y])
        tomatoes[0] -= 1
        tomatoes[1] += 1

    for i in range(H):
        for j in range(M):
            for k in range(N):
                tomatoes[box[i][j][k]] += 1
                if box[i][j][k] == 1:
                    growed.append([i, j, k])
    if tomatoes[1] == 0:
        print(-1)
    elif tomatoes[0] == 0 and tomatoes[1] != 0:
        print(0)
    else:
        day = 0
        target = deque()
        while growed:
            lz, lx, ly = growed.popleft()
            for i in range(3):
                nz = lz + dz[i]
                if nz >= 0 and nz < H and not visited[nz][lx][ly] and box[nz][lx][ly] == 0:
                    check(nz, lx, ly, box[lz][lx][ly] + 1)

            for j in range(4):
                nx, ny = lx + dx[j], ly + dy[j]
                if nx >= 0 and nx < M and ny >= 0 and ny < N and not visited[lz][nx][ny] and box[lz][nx][ny] == 0:
                    check(lz, nx, ny, box[lz][lx][ly] + 1)

            if len(growed) == 0:
                day += 1
                growed = target
                target = deque()
        if tomatoes[0] != 0:
            print(-1)
        else:
            print(day - 1)


solution(N, M, H, box)


def test_01(capfd):
    N = 5
    M = 3
    H = 1
    box = [
        [
            [0, -1, 0, 0, 0],
            [-1, -1, 0, 1, 1],
            [0, 0, 0, 1, 1]
        ]
    ]
    solution(N, M, H, box)
    out, err = capfd.readouterr()
    assert out == '-1\n'


def test_02(capfd):
    N = 5
    M = 3
    H = 2
    box = [
        [
            [0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0],
        ],
        [
            [0, 0, 0, 0, 0],
            [0, 0, 1, 0, 0],
            [0, 0, 0, 0, 0],
        ]
    ]
    solution(N, M, H, box)
    out, err = capfd.readouterr()
    assert out == '4\n'


def test_03(capfd):
    N = 4
    M = 3
    H = 2
    box = [
        [
            [1, 1, 1, 1],
            [1, 1, 1, 1],
            [1, 1, 1, 1]
        ],
        [
            [1, 1, 1, 1],
            [-1, -1, -1, -1],
            [1, 1, 1, -1]
        ]
    ]
    solution(N, M, H, box)
    out, err = capfd.readouterr()
    assert out == '0\n'


def test_04(capfd):
    N = 3
    M = 3
    H = 2
    box = [
        [
            [1, 1, 0],
            [1, 1, 0],
            [0, 0, 0],
        ],
        [
            [0, 0, 0],
            [0, 1, 1],
            [0, 1, 1],
        ]
    ]
    solution(N, M, H, box)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_05(capfd):
    N = 2
    M = 2
    H = 2
    box = [
        [
            [-1, -1],
            [1, -1]
        ],
        [
            [0, -1],
            [-1, -1]
        ]
    ]
    solution(N, M, H, box)
    out, err = capfd.readouterr()
    assert out == '-1\n'
