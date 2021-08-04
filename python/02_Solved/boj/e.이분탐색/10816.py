# import sys
# input()
# A = list(map(int, sys.stdin.readline().split()))
# input()
# B = list(map(int, sys.stdin.readline().split()))

# A.sort()


# def binary_search(left, right, target):
#     while left <= right:
#         mid = (left + right) // 2
#         if target == A[mid]:
#             count = 1
#             start, end = mid, mid
#             # for i in range(left, mid):
#             #     if A[i] == target:
#             #         start = i
#             #         break
#             # for j in range(right, mid, -1):
#             #     if A[j] == target:
#             #         end = j
#             #         break
#             for i in range(mid-1, left-1, -1):
#                 if A[i] != target:
#                     start = i
#                     break
#             for j in range(mid + 1, right+1):
#                 if A[j] != target:
#                     end = j
#                     break
#             return count + end - start
#         elif target > A[mid]:
#             left = mid + 1
#         else:
#             right = mid - 1
#     return 0


# for target in B:
#     left = 0
#     right = len(A) - 1
#     print(binary_search(left, right, target), end=" ")

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

    result = []

    def binary_search(left, right, target):
        while left <= right:
            mid = (left + right) // 2
            if target == A[mid]:
                count = 1
                start, end = 0, len(A) - 1
                for i in range(mid - 1, left, -1):
                    if A[i] != target:
                        start = i
                        break
                for j in range(mid + 1, right):
                    if A[j] != target:
                        end = j
                        break
                return count + end - start
            elif target > A[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return 0

    for target in B:
        result.append(binary_search(0, len(A) - 1, target))

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
