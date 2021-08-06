import sys
sys.setrecursionlimit(10000)
# * ========================================================
# * @Title       : 1012
# * @Path        : python\02_Solved\boj\f.DFS와BFS\1012.py
# * @Description :
# * @Date        : 2021-08-06 14:25:16
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(M, N, edge, cabbage):
    from collections import deque
    field = [[0 for _ in range(M)] for _ in range(N)]

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    # 필드 초기화
    for i, j in cabbage:
        field[j][i] = 1
    queue = deque()

    def BFS():
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
                if nx >= 0 and nx < N and ny >= 0 and ny < M and field[nx][ny] == 1:
                    field[nx][ny] = 0
                    queue.append([nx, ny])
                    BFS()

    count = 0
    for i in range(N):
        for j in range(M):
            if field[i][j] == 1:
                queue.append([i, j])
                BFS()
                count += 1

    print(count)


# for _ in range(int(input())):
#     M, N, edge = list(map(int, sys.stdin.readline().split()))
#     cabbage = []
#     for _ in range(edge):
#         cabbage.append(list(map(int, sys.stdin.readline().split())))

#     solution(M, N, edge, cabbage)


def test_01(capfd):
    M = 10
    N = 8
    edge = 17
    cabbage = [
        [0, 0],
        [1, 0],
        [1, 1],
        [4, 2],
        [4, 3],
        [4, 5],
        [2, 4],
        [3, 4],
        [7, 4],
        [8, 4],
        [9, 4],
        [7, 5],
        [8, 5],
        [9, 5],
        [7, 6],
        [8, 6],
        [9, 6],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '5\n'


def test_02(capfd):
    M = 10
    N = 10
    edge = 1
    cabbage = [
        [5, 5],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_03(capfd):
    M = 5
    N = 3
    edge = 6
    cabbage = [
        [0, 2],
        [1, 2],
        [2, 2],
        [3, 2],
        [4, 2],
        [4, 0],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '2\n'


def test_04(capfd):
    M = 3
    N = 2
    edge = 4
    cabbage = [
        [1, 0],
        [0, 1],
        [1, 1],
        [2, 1],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_05(capfd):
    M = 3
    N = 3
    edge = 6
    cabbage = [
        [2, 0],
        [0, 1],
        [2, 1],
        [0, 2],
        [1, 2],
        [2, 2],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_06(capfd):
    M = 15
    N = 15
    edge = 21
    cabbage = [
        [0, 3],
        [0, 12],
        [1, 12],
        [1, 14],
        [2, 1],
        [2, 10],
        [2, 11],
        [3, 6],
        [4, 1],
        [5, 4],
        [6, 10],
        [6, 13],
        [7, 7],
        [9, 3],
        [9, 4],
        [10, 3],
        [10, 10],
        [10, 11],
        [12, 1],
        [12, 9],
        [14, 14],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '16\n'


def test_07(capfd):
    M = 15
    N = 15
    edge = 80
    cabbage = [
        [0, 0],
        [0, 1],
        [0, 4],
        [0, 10],
        [1, 2],
        [1, 7],
        [1, 10],
        [1, 12],
        [1, 13],
        [2, 2],
        [2, 3],
        [2, 7],
        [3, 2],
        [3, 4],
        [3, 6],
        [3, 8],
        [3, 11],
        [3, 14],
        [4, 0],
        [4, 1],
        [4, 2],
        [4, 5],
        [4, 6],
        [4, 7],
        [4, 8],
        [4, 11],
        [4, 12],
        [4, 14],
        [5, 0],
        [5, 2],
        [5, 4],
        [5, 7],
        [5, 8],
        [5, 10],
        [5, 11],
        [5, 13],
        [5, 14],
        [6, 5],
        [6, 10],
        [6, 12],
        [6, 13],
        [6, 14],
        [7, 1],
        [7, 9],
        [7, 12],
        [7, 13],
        [8, 2],
        [8, 4],
        [8, 8],
        [8, 9],
        [8, 12],
        [8, 13],
        [9, 0],
        [9, 3],
        [9, 5],
        [9, 11],
        [10, 2],
        [10, 3],
        [10, 5],
        [10, 9],
        [10, 10],
        [11, 8],
        [11, 9],
        [11, 11],
        [11, 12],
        [11, 13],
        [12, 3],
        [12, 13],
        [12, 14],
        [13, 1],
        [13, 4],
        [13, 7],
        [13, 9],
        [13, 10],
        [13, 13],
        [14, 0],
        [14, 5],
        [14, 7],
        [14, 8],
        [14, 13],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '29\n'


def test_08(capfd):
    M = 5
    N = 5
    edge = 1
    cabbage = [
        [4, 4],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_09(capfd):
    M = 3
    N = 4
    edge = 6
    cabbage = [
        [1, 0],
        [0, 1],
        [1, 1],
        [2, 1],
        [1, 2],
        [1, 3],
    ]
    solution(M, N, edge, cabbage)
    out, err = capfd.readouterr()
    assert out == '1\n'
