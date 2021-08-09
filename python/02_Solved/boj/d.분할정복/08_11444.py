# * ========================================================
# * @Title       : 11444
# * @Path        : python\02_Solved\boj\d.분할정복\11444.py
# * @Description :
# * @Date        : 2021-08-04 14:26:38
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
def solution(N):

    if N == 0:
        return 0
    elif N == 1:
        return 1

    dp = [0 for _ in range(N + 1)]
    dp[1] = 1

    for i in range(2, N + 1):
        dp[i] = dp[i - 2] + dp[i - 1]

    return dp[N] % 1000000007


def test_01():
    assert solution(1000) == 517691607


def test_02():
    assert solution(0) == 0


def test_03():
    assert solution(1) == 1


def test_04():
    assert solution(1000000000000000000) == 1
