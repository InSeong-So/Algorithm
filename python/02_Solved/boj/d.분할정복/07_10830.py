N = [
    [1, 2],
    [3, 4],
]
M = [
    [1, 2],
    [3, 4],
]

matrix = [
    [0, 0],
    [0, 0]
]

for _ in range(1, 5):
    for i in range(len(N)):
        for j in range(len(M[0])):
            for k in range(len(N[0])):
                matrix[i][j] += ((N[i][k] % 1000) *
                                 (M[k][j] % 1000)) % 1000
            matrix[i][j] = matrix[i][j] % 1000
    N = matrix
    matrix = [
        [0, 0],
        [0, 0]
    ]


for i in range(2):
    for j in range(2):
        print(N[i][j], end=" ")
    print("")

# * ========================================================
# * @Title       : 10830
# * @Path        : python\02_Solved\boj\d.분할정복\10830.py
# * @Description :
# * @Date        : 2021-08-04 13:05:16
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, B):
    MOD = 1000

    def recursion(x, y):
        if y == 0:
            return 1
        if y == 1:
            return x * y

        root = recursion(x, y // 2) % MOD
        square = (root * root) % MOD

        if y % 2 == 0:
            return square
        return (square * (x % MOD)) % MOD

    for _ in range(B):
        for i in range(len(N)):
            for j in range(len(N)):
                N[i][j] += recursion(N[i][j], B)

    print(N)

    return 1


def test_01():
    N = [
        [1, 2],
        [3, 4],
    ]
    B = 5
    assert solution(N, B) == [
        [69, 558],
        [337, 406]
    ]


def test_02():
    N = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
    ]
    B = 3
    # assert solution(N, B) == 1
    assert 1 == 1


def test_03():
    N = [
        [1, 0, 0, 0, 1],
        [1, 0, 0, 0, 1],
        [1, 0, 0, 0, 1],
        [1, 0, 0, 0, 1],
        [1, 0, 0, 0, 1],
    ]
    B = 10
    # assert solution(N, B) == 1
    assert 1 == 1


def test_04():
    N = [
        [1, 2],
        [3, 4],
    ]
    B = 5
    assert 1 == 1
