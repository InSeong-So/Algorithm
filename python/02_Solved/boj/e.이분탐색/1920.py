# import sys
# input()
# A = list(map(int, sys.stdin.readline().split()))
# input()
# B = list(map(int, sys.stdin.readline().split()))

# A.sort()

# result = []


# def binary_search(left, right, target):
#     while(left <= right):
#         mid = (left + right) // 2
#         if target == A[mid]:
#             return 1
#         elif target > A[mid]:
#             left = mid + 1
#         else:
#             right = mid - 1
#     return 0


# for target in B:
#     left = 0
#     right = len(A) - 1
#     print(binary_search(left, right, target))


# * ========================================================
# * @Title       : 1920
# * @Path        : python\02_Solved\boj\e.이분탐색\1920.py
# * @Description :
# * @Date        : 2021-08-04 14:59:45
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(A, B):
    A.sort()

    result = []

    def binary_search(left, right, target):
        while(left <= right):
            mid = (left + right) // 2
            if target == A[mid]:
                return 1
            elif target > A[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return 0

    for target in B:
        left = 0
        right = len(A) - 1
        result.append(binary_search(left, right, target))
    return result


def test_01():
    A = [4, 1, 5, 2, 3]
    B = [1, 3, 7, 9, 5]
    assert solution(A, B) == [1, 1, 0, 0, 1]


def test_02():
    A = [1, 1, 1, 1, 1]
    B = [1]
    assert solution(A, B) == [1]


def test_03():
    A = [3, 4, 5, 2, 1]
    B = [0]
    assert solution(A, B) == [0]


def test_04():
    A = [3, 4, 5, 2, 1]
    B = [5, 1, 3, 2, 4]
    assert solution(A, B) == [1, 1, 1, 1, 1]
