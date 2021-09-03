import sys
input()
A = list(map(int, sys.stdin.readline().split()))
input()
B = list(map(int, sys.stdin.readline().split()))

cards = dict()
for i in A:
    if i not in cards:
        cards[i] = 1
    else:
        cards[i] += 1

result = []

for target in B:
    if target in cards:
        print(cards[target])
    else:
        print(0)

# * ========================================================
# * @Title       : 10816
# * @Path        : python\02_Solved\boj\e.이분탐색\10816.py
# * @Description :
# * @Date        : 2021-08-04 15:33:43
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(A, B):
    A.sort()

    cards = dict()
    for i in A:
        if i not in cards:
            cards[i] = 1
        else:
            cards[i] += 1

    result = []

    for target in B:
        if target in cards:
            result.append(cards[target])
        else:
            result.append(0)

    return result


def test_01():
    A = [6, 3, 2, 10, 10, 10, -10, -10, 7, 3]
    B = [10, 9, -5, 2, 3, 4, 5, -10]
    assert solution(A, B) == [3, 0, 0, 1, 2, 0, 0, 2]


def test_02():
    A = [6, 3, 2, 10, 10, 10, -10, -10, 7, 3]
    B = [6]
    assert solution(A, B) == [1]


def test_03():
    A = [1, 1, 1, 1, 1, 1, 1, 1, 1]
    B = [1]
    assert solution(A, B) == [9]


def test_04():
    A = [1]
    B = [0, 0]
    assert solution(A, B) == [0, 0]
