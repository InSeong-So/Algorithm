import sys
input()
watings = list(map(int, sys.stdin.readline().split()))
time = 0
times = []
watings.sort()
for i in watings:
    time += i
    times.append(time)
print(times)
print(sum(times))

# * ========================================================s
# * @Title       : 11399
# * @Path        : python\02_Solved\boj\c.그리디알고리즘\11399.py
# * @Description :
# * @Date        : 2021-08-02 11:01:51
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(watings):
    watings.sort()

    time = 0
    times = []
    for i in watings:
        time += i
        times.append(time)

    return sum(times)


def test_01():
    watings = [5, 2, 3, 4, 1]
    assert solution(watings) == 35


def test_02():
    watings = [11, 103, 132, 19, 102]
    assert solution(watings) == 775


def test_03():
    watings = [3, 1, 4, 3, 2]
    assert solution(watings) == 775
