import sys

# * ========================================================
# * @Title       : 11726
# * @Path        : python\문제풀이\boj\z.분류별\11726_2xn 타일링.py
# * @Link        : https://www.acmicpc.net/problem/11726
# * @Description : 2xn 타일링
# * @Note        :
# * @Date        : 2021-08-13 21:54:09
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N):
    INF = sys.maxsize
    #     0
    # 2x1 2
    # 2x2 2
    # 2x3 3
    # 2x4 5
    dp = [INF for _ in range(1001)]
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3

    for i in range(4, N + 1):
        dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007

    print(dp[N] % 10007)


# 입력
# solution(int(input()))


def test_01(capfd):
    solution(2)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_02(capfd):
    solution(9)
    out, err = capfd.readouterr()
    result = '55\n'
    assert out == result


def test_03(capfd):
    solution(1000)
    out, err = capfd.readouterr()
    result = '1115\n'
    assert out == result


def test_04(capfd):
    solution(78)
    out, err = capfd.readouterr()
    result = '2083\n'
    assert out == result
