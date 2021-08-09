import sys

N, M = list(map(int, sys.stdin.readline().split()))
labyrinth = []
for _ in range(N):
    labyrinth.append(input())
# * ========================================================
# * @Title       : 2178
# * @Path        : python\02_Solved\boj\f.DFS와BFS\2178.py
# * @Description :
# * @Date        : 2021-08-06 15:24:08
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, M, labyrinth):
    from collections import deque
    for i in range(len(labyrinth)):
        labyrinth[i] = list(map(int, list(labyrinth[i])))

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    visited = [[False for _ in range(M)] for _ in range(N)]

    queue = deque()
    queue.append([0, 0])
    visited[0][0] = True

    def BFS():
        while queue:
            lx, ly = queue.popleft()
            for i in range(4):
                nx, ny = lx + dx[i], ly + dy[i]
                # 이동이 가능하다면
                if nx >= 0 and nx < N and ny >= 0 and ny < M and not visited[nx][ny] and labyrinth[nx][ny] != 0:
                    labyrinth[nx][ny] = labyrinth[lx][ly] + 1
                    visited[nx][ny] = True
                    queue.append([nx, ny])
    BFS()

    print(labyrinth[N - 1][M - 1])


solution(N, M, labyrinth)


def test_01(capfd):
    N = 4
    M = 6
    labyrinth = [
        '101111',
        '101010',
        '101011',
        '111011',
    ]
    solution(N, M, labyrinth)
    out, err = capfd.readouterr()
    assert out == '15\n'


def test_02(capfd):
    N = 4
    M = 6
    labyrinth = [
        '110110',
        '110110',
        '111111',
        '111101',
    ]
    solution(N, M, labyrinth)
    out, err = capfd.readouterr()
    assert out == '9\n'


def test_03(capfd):
    N = 2
    M = 25
    labyrinth = [
        '1011101110111011101110111',
        '1110111011101110111011101',
    ]
    solution(N, M, labyrinth)
    out, err = capfd.readouterr()
    assert out == '38\n'


def test_04(capfd):
    N = 7
    M = 7
    labyrinth = [
        '1011111',
        '1110001',
        '1000001',
        '1000001',
        '1000001',
        '1000001',
        '1111111',
    ]
    solution(N, M, labyrinth)
    out, err = capfd.readouterr()
    assert out == '13\n'
