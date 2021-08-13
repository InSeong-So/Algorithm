import sys

# * ========================================================
# * @Title       : 6603
# * @Path        : python\문제풀이\boj\z.분류별\6603_로또.py
# * @Link        : https://www.acmicpc.net/problem/6603
# * @Description : 로또
# * @Note        : 못풀겠다 이해가 안됨
# * @Date        : 2021-08-13 13:03:52
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(arr):

    return 1


# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    arr = [7, 1, 2, 3, 4, 5, 6, 7]
    # solution(arr)
    # out, err = capfd.readouterr()
    # result = '1 2 3 4 5 6 \n1 2 3 4 5 7 \n1 2 3 4 6 7 \n1 2 3 5 6 7 \n1 2 4 5 6 7 \n1 3 4 5 6 7 \n2 3 4 5 6 7 \n'
    # assert out == result
    assert solution(arr) == 0


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
