import sys
N, M = list(map(int, sys.stdin.readline().split()))
T1 = []
for _ in range(N):
    T1.append(list(map(int, sys.stdin.readline().split())))

M, K = list(map(int, sys.stdin.readline().split()))
T2 = []
for _ in range(M):
    T2.append(list(map(int, sys.stdin.readline().split())))

matrix = [[0 for _ in range(K)] for _ in range(N)]

for i in range(N):
    for j in range(K):
        for k in range(M):
            matrix[i][j] += T1[i][k] * T2[k][j]

for i in range(len(matrix)):
    for j in range(len(matrix[0])):
        print(matrix[i][j], end=" ")
    print("")


# * ========================================================
# * @Title       : 2740
# * @Path        : python\02_Solved\boj\d.분할정복\2740.py
# * @Description :
# * @Date        : 2021-08-04 11:19:08
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
def solution(N, M):
    matrix = [[0 for _ in range(len(M[0]))] for _ in range(len(N))]

    for i in range(len(N)):
        for j in range(len(M[0])):
            for k in range(len(N[0])):
                # print(i, j, end="//")
                # print(i, k, end="//")
                # print(k, j)
                matrix[i][j] += N[i][k] * M[k][j]
    print(matrix)
    return matrix


def test_01():
    N = [
        [1, 2],
        [3, 4],
        [5, 6],
    ]
    M = [
        [-1, -2, 0],
        [0, 0, 3],
    ]
    assert solution(N, M) == [
        [-1, -2, 6],
        [-3, -6, 12],
        [-5, -10, 18]
    ]


def test_02():
    N = [
        [1, 2, 3],
        [4, 5, 6],
    ]
    M = [
        [-1, -2],
        [0, 0],
        [0, 3],
    ]
    assert solution(N, M) == [
        [-1, 7],
        [-4, 10],
    ]


def test_03():
    N = [
        [1, 2, 3],
        [4, 5, 6],
        [3, 6, 7],
        [7, 11, 5],
    ]
    M = [
        [-1, -2],
        [0, 0],
        [0, 3],
    ]
    assert solution(N, M) == [
        [-1, 7],
        [-4, 10],
        [-3, 15],
        [-7, 1]
    ]


def test_04():
    N = [
        [1, 2, 3, 5, 6, 7],
        [4, 5, 6, 10, 12, 13],
        [3, 6, 7, 1, 9, -4],
        [7, 11, 5, 2, 13, 0],
    ]
    M = [
        [-1, -2],
        [0, 0],
        [0, 3],
        [0, 7],
        [0, -5],
        [12, -5],
    ]
    assert solution(N, M) == [
        [83, -23],
        [152, -45],
        [-51, -3],
        [-7, -50]
    ]
