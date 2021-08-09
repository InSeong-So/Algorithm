import sys
N = int(input())

for _ in range(N):
    T = input().split()
    result = ''
    for i in range(len(T[1])):
        result += T[1][i] * int(T[0])
    print(result)


# * ========================================================
# * @Title       : 2675
# * @Path        : python\02_Solved\boj\a.문자열\04_2675.py
# * @Link        : https://www.acmicpc.net/problem/2675
# * @Description :
# * @Date        : 2021-08-09 15:31:28
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution():
    print('')
    # return 1


# 입력
input()
int(input())
list(map(int, sys.stdin.readline().split()))
solution()


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
