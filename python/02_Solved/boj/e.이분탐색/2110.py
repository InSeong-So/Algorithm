import sys
input = sys.stdin.readline
n, c = map(int, input().split())
xs = []
for i in range(n):
    xs.append(int(input()))
xs.sort()


def pos(distance):
    completed = [0]
    for i in range(1, n):
        if xs[i]-xs[completed[-1]] >= distance:
            completed.append(i)
    return len(completed) >= c


start = 1
end = max(xs)-min(xs)+1
while end - start > 1:
    mid = (start + end) // 2
    if pos(mid):
        start = mid
    else:
        end = mid
print(start)
# * ========================================================
# * @Title       : 2110
# * @Path        : python\02_Solved\boj\e.이분탐색\2110.py
# * @Description :
# * @Date        : 2021-08-05 10:34:33
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(n, k, houses):

    houses.sort()
    result = 0
    min_dis = 1
    max_dis = houses[-1] - houses[0]
    while min_dis <= max_dis:
        mid_dis = (min_dis + max_dis) // 2
        count = 1
        last = houses[0]
        for i in range(1, len(houses)):
            if last + mid_dis <= houses[i]:
                count += 1
                last = houses[i]
        if count >= k:
            result = mid_dis
            min_dis = mid_dis + 1
        else:
            max_dis = mid_dis - 1
    return result


def test_01():
    n = 5
    k = 3
    houses = [1, 2, 8, 4, 9]
    assert solution(n, k, houses) == 3


def test_02():
    n = 5
    k = 3
    houses = [1, 6, 7, 8, 9]
    assert solution(n, k, houses) == 3


def test_03():
    n = 3
    k = 3
    houses = [1, 3, 4]
    assert solution(n, k, houses) == 1


def test_04():
    n = 3
    k = 3
    houses = [1, 4, 6]
    assert solution(n, k, houses) == 2
