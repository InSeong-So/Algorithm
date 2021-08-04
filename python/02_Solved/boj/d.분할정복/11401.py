

# * ========================================================
# * @Title       : 11401
# * @Path        : python\02_Solved\boj\d.분할정복\11401.py
# * @Description : 이항계수, 모듈러 연산
# * @Date        : 2021-08-04 09:24:32
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, K):
    MOD = 1000000007

    if N > 0 and K > 0:
        factorial = [1 for _ in range(N + 1)]
        for i in range(2, N + 1):
            factorial[i] = (factorial[i - 1] * i) % MOD
        inverse = [0 for _ in range(N + 1)]

        n, r, k = factorial[N], factorial[N - K], factorial[K]
        print(n, r, k)
    return 0


def test_01():
    N, K = 5, 2
    assert solution(N, K) == 10


def test_02():
    N, K = 4, 2
    assert solution(N, K) == 6


def test_03():
    N, K = 0, 0
    assert solution(N, K) == 0


def test_04():
    N, K = 5, 2
    assert solution(N, K) == 10
