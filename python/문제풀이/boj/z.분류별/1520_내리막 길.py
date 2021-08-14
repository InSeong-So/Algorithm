import sys
sys.setrecursionlimit(10000)

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
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    dp = [[-1 for _ in range(501)] for _ in range(501)]

    def DFS(x, y):
        if x == n and y == m:
            return 1

        if dp[x][y] != -1:
            return dp[x][y]

        dp[x][y] = 0

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx > 0 and nx <= n and ny > 0 and ny <= m and matrix[nx-1][ny-1] < matrix[x-1][y-1]:
                dp[x][y] += DFS(nx, ny)

        return dp[x][y]

    DFS(1, 1)

    # for i in range(1, n + 1):
    #     for j in range(1, m + 1):
    #         print('-' if dp[i][j] == -1 else dp[i][j], end=" ")
    #     print()

    print(dp[1][1])


# 입력
n, m = list(map(int, sys.stdin.readline().split()))
matrix = [[] for _ in range(n)]
for i in range(n):
    matrix[i] = list(map(int, sys.stdin.readline().split()))
solution(n, m, matrix)


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
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_02(capfd):
    n = 4
    m = 4
    matrix = [
        [9, 8, 7, 6],
        [8, 7, 6, 5],
        [7, 6, 5, 4],
        [6, 5, 4, 3],
    ]
    solution(n, m, matrix)
    out, err = capfd.readouterr()
    result = '20\n'
    assert out == result


def test_03(capfd):
    n = 3
    m = 5
    matrix = [
        [55, 99, 49, 48, 47],
        [54, 99, 50, 99, 46],
        [53, 52, 51, 99, 45],
    ]
    solution(n, m, matrix)
    out, err = capfd.readouterr()
    result = '1\n'
    assert out == result


def test_04(capfd):
    n = 3
    m = 3
    matrix = [
        [9, 4, 3],
        [8, 5, 2],
        [7, 6, 1],
    ]
    solution(n, m, matrix)
    out, err = capfd.readouterr()
    result = '4\n'
    assert out == result
