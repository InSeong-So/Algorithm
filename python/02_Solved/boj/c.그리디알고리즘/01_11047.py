import sys
N, K = list(map(int, sys.stdin.readline().split()))

coins = []
for _ in range(N):
    coins.append(int(input()))

coins.sort(reverse=True)

count = 0
for coin in coins:
    div = K // coin
    K -= div * coin
    count += div

print(count)


# * ========================================================
# * @Title       : 11047
# * @Path        : python\02_Solved\boj\c.그리디알고리즘\11047.py
# * @Description :
# * @Date        : 2021-08-01 23:26:41
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
def solution(K, coins):
    result = 0
    return result


def test_01():
    K = 4200
    coins = [
        1,
        5,
        10,
        50,
        100,
        500,
        1000,
        5000,
        10000,
        50000
    ]
    assert solution(K, coins) == 6


def test_02():
    K = 4790
    coins = [
        1,
        5,
        10,
        50,
        100,
        500,
        1000,
        5000,
        10000,
        50000,
    ]
    assert solution(K, coins) == 12


def test_03():
    K = 1
    coins = [
        1,
    ]
    assert solution(K, coins) == 1


def test_04():
    K = 4000
    coins = [
        1,
        5,
    ]
    assert solution(K, coins) == 800
