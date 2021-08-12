import sys

# * ========================================================
# * @Title       : 11729
# * @Path        : python\문제풀이\boj\z.분류별\11729_하노이 탑 이동 순서.py
# * @Link        : https://www.acmicpc.net/problem/11729
# * @Description :
# * @Note        :
# * @Date        : 2021-08-12 18:46:00
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# Solve 함수


def solution(n):
    answer = []

    def hanoi(cnt, start, end):

    hanoi(n, 1, 3)

    return 1

# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    n = 3
    # solution(n)
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
    assert solution(n) == 0


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
