# * ========================================================
# * @Title       : 1654
# * @Path        : python\02_Solved\boj\e.이분탐색\1654.py
# * @Description :
# * @Date        : 2021-08-05 09:40:19
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
def solution(N, K, LANS):
    return 1


def test_01():
    N = 4
    K = 11
    LANS = [802, 743, 457, 539]
    assert solution(N, K, LANS) == 200


def test_02():
    N = 3
    K = 6
    LANS = [40, 20, 1]
    assert solution(N, K, LANS) == 10


def test_03():
    N = 4
    K = 4
    LANS = [2, 1, 2, 1]
    assert solution(N, K, LANS) == 1


def test_04():
    N = 1
    K = 4
    LANS = [5]
    assert solution(N, K, LANS) == 1
