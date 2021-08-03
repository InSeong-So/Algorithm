print(pow(10, 11, 12))

# * ========================================================
# * @Title       : 1629
# * @Path        : python\02_Solved\boj\d.분할정복\1629.py
# * @Description :
# * @Date        : 2021-08-03 12:51:21
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, M, K):
    def recursion(x, y, z):
        if y == 0:
            return 1
        elif y == 1:
            return x * y

        if y % 2 == 0:
            return recursion(x, y // 2, z) % z * recursion(x, y // 2, z)
        else:
            return recursion(x, (y - 1) // 2, z) % z * recursion(x, (y - 1) // 2, z) * x

    return recursion(N, M, K) % K


def test_01():
    N, M, K = 10, 11, 12
    assert solution(N, M, K) == 4


def test_02():
    N, M, K = 2, 31, 5
    assert solution(N, M, K) == 3


def test_03():
    N, M, K = 9, 11, 1
    assert solution(N, M, K) == 0


def test_04():
    N, M, K = 100000, 100000, 12
    assert solution(N, M, K) == 4
