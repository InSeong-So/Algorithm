# DP로 풀었는데... 전혀 그럴 필요가 없었다. 다시 한 번 생각해보자.

# * ========================================================
# * @Title       : 13305
# * @Path        : python\02_Solved\boj\c.그리디알고리즘\13305.py
# * @Description :
# * @Date        : 2021-08-02 13:32:36
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(distance, expense):
    total = 0

    return total


def test_01():
    distance = [2, 3, 1]
    expense = [5, 2, 4, 1]
    assert solution(distance, expense) == 18


def test_02():
    distance = [3, 3, 4]
    expense = [1, 1, 1, 1]
    assert solution(distance, expense) == 10


def test_03():
    distance = [1, 1, 1, 1]
    expense = [1, 5, 4, 3, 2]
    assert solution(distance, expense) == 4


def test_04():
    distance = [3, 2, 1, 4]
    expense = [5, 8, 9, 4, 1]
    assert solution(distance, expense) == 46
