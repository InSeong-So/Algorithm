import sys

N = int(input())
matrix = []
for _ in range(N):
    matrix.append(list(sys.stdin.readline()))

result = []


def recursion(x, y, N):
    div = N // 2
    target = matrix[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if target != matrix[i][j]:
                result.append('(')
                recursion(x, y, div)
                recursion(x, y+div, div)
                recursion(x+div, y, div)
                recursion(x+div, y+div, div)
                result.append(')')
                return
    result.append(target)


recursion(0, 0, len(matrix))

print(''.join(result))


# * ========================================================
# * @Title       : 1992
# * @Path        : python\02_Solved\boj\d.분할정복\1992.py
# * @Description :
# * @Date        : 2021-08-02 15:52:18
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(matrix):
    result = []

    input_len = len(matrix)

    def recursion(x, y, N):
        div = N // 2
        target = matrix[x][y]

        for i in range(x, x + N):
            for j in range(y, y + N):
                if target != matrix[i][j]:
                    result.append('(')
                    recursion(x, y, div)
                    recursion(x, y+div, div)
                    recursion(x+div, y, div)
                    recursion(x+div, y+div, div)
                    result.append(')')
                    return

        result.append(target)

    recursion(0, 0, input_len)

    return ''.join(result)


def test_01():
    matrix = [
        ['1', '1', '1', '1', '0', '0', '0', '0'],
        ['1', '1', '1', '1', '0', '0', '0', '0'],
        ['0', '0', '0', '1', '1', '1', '0', '0'],
        ['0', '0', '0', '1', '1', '1', '0', '0'],
        ['1', '1', '1', '1', '0', '0', '0', '0'],
        ['1', '1', '1', '1', '0', '0', '0', '0'],
        ['1', '1', '1', '1', '0', '0', '1', '1'],
        ['1', '1', '1', '1', '0', '0', '1', '1']
    ]
    assert solution(matrix) == '((110(0101))(0010)1(0001))'


def test_02():
    matrix = [
        ['1', '1', '0', '0'],
        ['1', '1', '0', '0'],
        ['0', '0', '1', '1'],
        ['0', '0', '1', '1']
    ]
    assert solution(matrix) == '(1001)'


def test_03():
    matrix = [
        ['1', '1', '0', '0', '0', '0', '1', '1'],
        ['1', '0', '1', '0', '0', '0', '1', '1'],
        ['0', '0', '0', '0', '1', '1', '0', '0'],
        ['0', '0', '0', '0', '1', '1', '0', '0'],
        ['1', '0', '0', '0', '1', '1', '1', '1'],
        ['0', '1', '0', '0', '1', '1', '1', '1'],
        ['0', '0', '1', '1', '1', '1', '0', '1'],
        ['0', '0', '1', '1', '1', '1', '1', '1'],
    ]
    assert solution(matrix) == '(((1110)(0010)00)(0110)((1001)001)(111(0111)))'


def test_04():
    matrix = [
        ['1', '0', '1', '0'],
        ['0', '0', '0', '0'],
        ['1', '0', '1', '0'],
        ['0', '0', '0', '0'],
    ]
    assert solution(matrix) == '((1000)(1000)(1000)(1000))'
