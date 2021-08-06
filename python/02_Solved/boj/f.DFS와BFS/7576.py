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

    visited = [[False for _ in range(N)] for _ in range(M)]
    tomatoes = deque()
    grow = [0]

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    def BFS(day, tomatoes):
        childs = deque()
        while tomatoes:
            lx, ly = tomatoes.popleft()
            for i in range(4):
                nx, ny = lx + dx[i], ly + dy[i]
                if nx >= 0 and nx < M and ny >= 0 and ny < N and not visited[nx][ny] and box[nx][ny] == 0:
                    visited[nx][ny] = True
                    box[nx][ny] = box[lx][ly] + 1
                    childs.append([nx, ny])
                    grow[0] -= 1
        if len(childs) != 0:
            return BFS(day + 1, childs)
        else:
            return day

    for i in range(M):
        for j in range(N):
            if box[i][j] == 1:
                tomatoes.append([i, j])
            elif box[i][j] == 0:
                grow[0] += 1

    if len(tomatoes) != 0:
        cnt = BFS(0, tomatoes)
        if grow[0] != 0:
            print(-1)
        else:
            print(cnt)
    elif len(tomatoes) == grow[0]:
        print(0)
    else:
        print(-1)


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
