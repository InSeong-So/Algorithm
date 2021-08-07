import sys
N, K = list(map(int, sys.stdin.readline().split()))

# * ========================================================
# * @Title       : 1697
# * @Path        : python\02_Solved\boj\f.DFS와BFS\1697.py
# * @Description :
# * @Date        : 2021-08-07 10:47:00
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, K):
    from collections import deque
    dp = [0 for _ in range(100001)]
    visited = [False for _ in range(100001)]
    queue = deque()

    dp[N] = 1
    visited[N] = True
    queue.append(N)

    de = ['-', '+', '*']

    def calc(a, expr):
        if expr == '-' and a > 0:
            return a - 1
        elif expr == '+' and a < 100000:
            return a + 1
        elif expr == '*' and (a * 2) <= 100000:
            return a * 2
        return -1

    def BFS(v):
        while queue:
            n = queue.popleft()
            for expr in de:
                target = calc(n, expr)
                if target != -1 and not visited[target]:
                    dp[target] = dp[n] + 1
                    queue.append(target)
                    visited[target] = True
    BFS(N)

    print(dp[K] - 1)


solution(N, K)


def test_01(capfd):
    N = 5
    K = 17
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '4\n'


def test_02(capfd):
    N = 1
    K = 1
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '0\n'


def test_03(capfd):
    N = 0
    K = 1
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_04(capfd):
    N = 1
    K = 0
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_05(capfd):
    N = 99999
    K = 100000
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '1\n'


def test_06(capfd):
    N = 10
    K = 19
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '2\n'


def test_07(capfd):
    N = 5
    K = 19
    solution(N, K)
    out, err = capfd.readouterr()
    assert out == '3\n'
