import sys

# * ========================================================
# * @Title       : 9095
# * @Path        : python\문제풀이\boj\z.분류별\9095_1,2,3 더하기.py
# * @Link        : https://www.acmicpc.net/problem/9095
# * @Description : 1, 2, 3 더하기
# * @Note        : Tribonacci Numbers
# * @Date        : 2021-08-13 21:45:23
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N):
    INF = sys.maxsize
    dp = [INF for _ in range(11)]

    nums = [1, 2, 3]

    dp[0] = 0
    dp[1] = 1
    dp[2] = 2   # 1, 1 / 2
    dp[3] = 4   # 1, 1, 1 / 1, 2 / 2, 1 / 3
    # 4 = 7
    for n in nums:
        for i in range(4, N + 1):
            # a(n-1) + a(n-2) + a(n-3)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    print(dp[N])


# 입력
for _ in range(int(input())):
    solution(int(input()))


def test_01(capfd):
    solution(4)
    out, err = capfd.readouterr()
    result = '7\n'
    assert out == result


def test_02(capfd):
    solution(7)
    out, err = capfd.readouterr()
    result = '44\n'
    assert out == result


def test_03(capfd):
    solution(10)
    out, err = capfd.readouterr()
    result = '274\n'
    assert out == result


def test_04(capfd):
    solution(9)
    out, err = capfd.readouterr()
    result = '149\n'
    assert out == result
