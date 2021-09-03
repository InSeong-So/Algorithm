import sys

# * ========================================================
# * @Title       : 11654
# * @Path        : python\02_Solved\boj\a.문자열\01_11654.py
# * @Link        : https://www.acmicpc.net/problem/11654
# * @Description : 아스키코드
# * @Date        : 2021-08-09 14:51:59
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(T):
    print(ord(T))
    # return 1


# 입력
T = input()
solution(T)


def test_01(capfd):
    solution()
    out, err = capfd.readouterr()
    result = '\n'
    assert out == result
    # assert solution() == 0


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
