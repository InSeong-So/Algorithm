import sys

# * ========================================================
# * @Title       : 2839
# * @Path        : python\문제풀이\boj\z.분류별\2839_설탕 배달.py
# * @Link        : https://www.acmicpc.net/problem/2839
# * @Description : 설탕 배달
# * @Note        : 냅색 알고리즘
# * @Date        : 2021-08-13 21:26:56
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N):
    INF = sys.maxsize
    sugers = [3, 5]

    dp = [INF for _ in range(5001)]
    dp[3] = 1
    dp[5] = 1
    for s in sugers:
        for i in range(s, N + 1):
            dp[i] = min(dp[i], dp[i - s] + 1)

    print(-1 if dp[N] == INF else dp[N])


# 입력
solution(int(input()))


def test_01(capfd):
    solution(18)
    out, err = capfd.readouterr()
    result = '4\n'
    assert out == result


def test_02(capfd):
    solution(4)
    out, err = capfd.readouterr()
    result = '-1\n'
    assert out == result


def test_03(capfd):
    solution(6)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_04(capfd):
    solution(9)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_05(capfd):
    solution(11)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result
