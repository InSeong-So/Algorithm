import sys

# * ========================================================
# * @Title       : 11720
# * @Path        : python\02_Solved\boj\a.문자열\02_11720.py
# * @Link        : https://www.acmicpc.net/problem/11720
# * @Description : 숫자의 합
# * @Date        : 2021-08-09 15:22:04
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N, T):
    T = str(T)
    total = 0
    for i in range(N):
        total += int(T[i])
    print(total)
    # return 1


# 입력
# N = int(input())
# T = input()
# solution(N, T)


def test_01(capfd):
    N = 1
    T = 1
    solution(N, T)
    out, err = capfd.readouterr()
    result = '1\n'
    assert out == result
    # assert solution() == 0


def test_02(capfd):
    N = 5
    T = 54321
    solution(N, T)
    out, err = capfd.readouterr()
    result = '15\n'
    assert out == result


def test_03(capfd):
    N = 25
    T = 7000000000000000000000000
    solution(N, T)
    out, err = capfd.readouterr()
    result = '7\n'
    assert out == result


def test_04(capfd):
    N = 11
    T = 10987654321
    solution(N, T)
    out, err = capfd.readouterr()
    result = '46\n'
    assert out == result
