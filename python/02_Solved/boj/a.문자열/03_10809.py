import string


# * ========================================================
# * @Title       : 10809
# * @Path        : python\02_Solved\boj\a.문자열\03_10809.py
# * @Link        : https://www.acmicpc.net/problem/10809
# * @Description :
# * @Date        : 2021-08-09 15:26:59
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(T):
    az = string.ascii_lowercase
    for i in az:
        print(T.find(i), end=" ")
    # return 1


# 입력
# solution(input())


def test_01(capfd):
    T = 'baekjoon'
    solution(T)
    out, err = capfd.readouterr()
    result = '1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 '
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
