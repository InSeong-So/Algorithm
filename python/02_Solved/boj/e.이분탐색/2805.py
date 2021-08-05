import sys
N, K = list(map(int, sys.stdin.readline().split()))
trees = list(map(int, sys.stdin.readline().split()))

start = 1
end = max(trees)
while start <= end:
    mid = (start + end) // 2
    height = 0
    # 이 부분에서 시간초과?
    # for tree in trees:
    #     h = tree - mid
    #     height += (h if h > 0 else 0)
    if height >= K:
        start = mid + 1
    else:
        end = mid - 1
print(end)

# * ========================================================
# * @Title       : 2805
# * @Path        : python\02_Solved\boj\e.이분탐색\2805.py
# * @Description :
# * @Date        : 2021-08-05 10:03:18
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, K, trees):

    start = 1
    end = max(trees)
    while start <= end:
        mid = (start + end) // 2
        height = 0
        for tree in trees:
            height += (tree - mid if tree - mid > 0 else 0)
        if height >= K:
            start = mid + 1
        else:
            end = mid - 1

    return end


def test_01():
    n = 4
    k = 7
    trees = [20, 15, 10, 17]
    assert solution(n, k, trees) == 15


def test_02():
    n = 7
    k = 6
    trees = [1, 2, 3, 4, 5, 6, 7]
    assert solution(n, k, trees) == 4


def test_03():
    n = 5
    k = 20
    trees = [4, 42, 40, 26, 46]
    assert solution(n, k, trees) == 36


def test_04():
    n = 1
    k = 1
    trees = [1000000000]
    assert solution(n, k, trees) == 999999999
