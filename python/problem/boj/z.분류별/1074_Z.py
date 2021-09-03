import sys

# * ========================================================
# * @Title       : 1074
# * @Path        : python\문제풀이\boj\z.분류별\1074_Z.py
# * @Link        : https://www.acmicpc.net/problem/1074
# * @Description : Z
# * @Note        : 재귀...? 굳이? 쿼드트리랑 비슷한 문제인듯
# * @Date        : 2021-08-13 10:36:41
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N, R, C):

    def recursion(n, r, c):
        visited = 0
        while n > 0:
            if n == 0:
                if r == 0 and c == 1:
                    visited += 1
                elif r == 1 and c == 0:
                    visited += 2
                elif r == 1 and c == 1:
                    visited += 3
            else:
                div = (2 ** n) // 2
                if div > r and div <= c:
                    visited += div ** 2
                    c -= div
                elif div <= r and div > c:
                    visited += (div ** 2) * 2
                    r -= div
                elif div <= r and div <= c:
                    visited += (div ** 2) * 3
                    r -= div
                    c -= div
            n -= 1
        return visited

    print(recursion(N, R, C))


# 입력
N, R, C = list(map(int, sys.stdin.readline().split()))
solution(N, R, C)


def test_01(capfd):
    N = 2
    R = 3
    C = 1
    solution(N, R, C)
    out, err = capfd.readouterr()
    result = '11\n'
    assert out == result


def test_02(capfd):
    N = 3
    R = 7
    C = 7
    solution(N, R, C)
    out, err = capfd.readouterr()
    result = '63\n'
    assert out == result


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


# 숏코딩
# n, r, c = map(int, input().split())
# s = 0
# while n > 1:
#   n -= 1
#   s += 2**(2*n)*(2*(r//2**n)+c//2**n)
#   r %= 2**n
#   c %= 2**n
# s += 2*r+c
# print(s)
