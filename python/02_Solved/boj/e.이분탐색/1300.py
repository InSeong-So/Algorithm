# * ========================================================
# * @Title       : 1300
# * @Path        : python\02_Solved\boj\e.이분탐색\1300.py
# * @Description : 단조증가, 단조감소 https://www.acmicpc.net/board/view/37110
# * @Date        : 2021-08-05 14:10:41
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
def solution(N, K):

    def binary_search(left, right):
        result = 0
        while left <= right:
            mid = (left + right) // 2
            count = 0
            for i in range(1, N + 1):
                count += min(mid // i, N)
            if count >= K:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result

    return binary_search(1, K)


def test_01():
    N = 3
    K = 7
    assert solution(N, K) == 6


def test_02():
    N = 7
    K = 49
    assert solution(N, K) == 49


def test_03():
    N = 8
    K = 58
    assert solution(N, K) == 42


def test_04():
    N = 150
    K = 99
    assert solution(N, K) == 28
