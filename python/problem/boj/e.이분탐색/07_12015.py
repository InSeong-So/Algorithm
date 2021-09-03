import sys
N = int(input())
nums = list(map(int, sys.stdin.readline().split()))
dp = [-float('inf') for _ in range(N + 1)]
dp[1] = nums[0]
index = 1


def binary_search(start, end, target):
    while start <= end:
        if start == end:
            return start
        elif start + 1 == end:
            return start if dp[start] >= target else end
        mid = (start + end) // 2
        if dp[mid] == target:
            return mid
        elif dp[mid] < target:
            start = mid + 1
        else:
            end = mid


for target in nums:
    if dp[index] < target:
        index += 1
        dp[index] = target
    else:
        next = binary_search(0, index, target)
        dp[next] = target

print(index)

# * ========================================================
# * @Title       : 12015
# * @Path        : python\02_Solved\boj\e.이분탐색\12015.py
# * @Description : LIS의 O(nlogn) 구현
# * @Date        : 2021-08-05 16:08:34
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, nums):

    dp = [-float('inf') for _ in range(N + 1)]
    dp[1] = nums[0]
    index = 1

    def binary_search(start, end, target):
        while start <= end:
            if start == end:
                return start
            elif start + 1 == end:
                return start if dp[start] >= target else end
            mid = (start + end) // 2
            if dp[mid] == target:
                return mid
            elif dp[mid] < target:
                start = mid + 1
            else:
                end = mid

    for target in nums:
        if dp[index] < target:
            index += 1
            dp[index] = target
        else:
            next = binary_search(0, index, target)
            dp[next] = target
    return index


def test_01():
    N = 6
    nums = [10, 20, 10, 30, 20, 50]
    assert solution(N, nums) == 3


def test_02():
    N = 6
    nums = [8, 5, 1, 10, 5, 9]
    assert solution(N, nums) == 3


def test_03():
    N = 7
    nums = [7, 2, 9, 10, 3, 8, 10]
    assert solution(N, nums) == 4


def test_04():
    N = 7
    nums = [4, 8, 3, 7, 1, 2, 7]
    assert solution(N, nums) == 3


def test_05():
    N = 14
    nums = [7, 1, 2, 3, 3, 9, 5, 10, 9, 10, 6, 3, 8, 10]
    assert solution(N, nums) == 7


def test_06():
    N = 13
    nums = [6, 5, 1, 9, 2, 6, 8, 10, 3, 8, 4, 7, 10]
    assert solution(N, nums) == 6
