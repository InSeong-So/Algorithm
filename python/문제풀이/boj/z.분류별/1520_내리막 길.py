import sys

# * ========================================================
# * @Title       : 1520
# * @Path        : python\문제풀이\boj\z.분류별\1520_내리막 길.py
# * @Link        : https://www.acmicpc.net/problem/1520
# * @Description : 내리막 길
# * @Note        :
# * @Date        : 2021-08-13 22:24:14
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(n, m, matrix):
    from collections import deque
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    visited = [[False for _ in range(m + 1)] for _ in range(n + 1)]
    cnt = 0

    def DFS(x, y):
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if nx + 1 == n and ny + 1 == m:
                print("진입")
            if nx >= 0 and nx < n and ny >= 0 and ny < m and not visited[nx][ny] and matrix[nx][ny] < matrix[x][y]:
                visited[nx][ny] = True
                DFS(nx, ny)
                visited[nx][ny] = False

    visited[0][0] = True
    DFS(0, 0)

    return 1


# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    n = 4
    m = 5
    matrix = [
        [50, 45, 37, 32, 30],
        [35, 50, 40, 20, 25],
        [30, 30, 25, 17, 28],
        [27, 24, 22, 15, 10],
    ]
    solution(n, m, matrix)
    # out, err = capfd.readouterr()
    # result = '3\n'
    # assert out == result
    assert solution(n, m, matrix) == 0


# def test_02(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_03(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
