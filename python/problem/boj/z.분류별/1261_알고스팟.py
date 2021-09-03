import sys


# * ========================================================
# * @Title       : 1261
# * @Path        : python\문제풀이\boj\z.분류별\1261_알고스팟.py
# * @Link        : https://www.acmicpc.net/problem/1261
# * @Description : 알고스팟
# * @Note        :
# * @Date        : 2021-08-12 23:07:51
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(n, m, matrix):
    from collections import deque
    INF = sys.maxsize

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    def BFS(x, y):
        visited = [[INF for _ in range(n + 1)] for _ in range(m + 1)]
        visited[x][y] = 0
        queue = deque()
        queue.append([x, y])
        while queue:
            lx, ly = queue.popleft()
            for i in range(4):
                nx = lx + dx[i]
                ny = ly + dy[i]
                if nx > 0 and nx <= m and ny > 0 and ny <= n:
                    if visited[nx][ny] > visited[lx][ly] + matrix[nx - 1][ny - 1]:
                        visited[nx][ny] = visited[lx][ly] + \
                            matrix[nx - 1][ny - 1]
                        queue.append([nx, ny])
        return visited

    print(BFS(1, 1)[m][n])


# 입력
n, m = list(map(int, sys.stdin.readline().split()))
matrix = [['' for _ in range(n)] for _ in range(m)]
for i in range(m):
    matrix[i] = list(map(int, input()))


solution(n, m, matrix)


def test_01(capfd):
    n = 3
    m = 3
    matrix = [
        '011',
        '111',
        '110',
    ]
    for i in range(len(matrix)):
        matrix[i] = list(map(int, matrix[i]))
    solution(n, m, matrix)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_02(capfd):
    n = 4
    m = 2
    matrix = [
        '0001',
        '1000',
    ]
    for i in range(len(matrix)):
        matrix[i] = list(map(int, matrix[i]))
    solution(n, m, matrix)
    out, err = capfd.readouterr()
    result = '0\n'
    assert out == result


def test_03(capfd):
    n = 6
    m = 6
    matrix = [
        '001111',
        '010000',
        '001111',
        '110001',
        '011010',
        '100010',
    ]
    for i in range(len(matrix)):
        matrix[i] = list(map(int, matrix[i]))
    solution(n, m, matrix)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
