import sys

# * ========================================================
# * @Title       : 2748
# * @Path        : python\문제풀이\boj\z.분류별\2748_피보나치 수 2.py
# * @Link        : https://www.acmicpc.net/problem/2748
# * @Description : 피보나치 수 2
# * @Note        :
# * @Date        : 2021-08-13 22:20:44
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N):
    dp = [0 for _ in range(91)]
    dp[1] = 1
    dp[2] = 1
    for i in range(3, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]
    print(dp[N])


# 입력
solution(int(input()))


def test_01(capfd):
    solution(10)
    out, err = capfd.readouterr()
    result = '55\n'
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
