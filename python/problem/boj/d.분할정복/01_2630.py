import sys

matrix = []
for _ in range(int(input())):
    matrix.append(list(map(int, sys.stdin.readline().split())))


def recursion(x, y, N):
    div = N // 2
    target = matrix[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if target != matrix[i][j]:
                recursion(x, y, div)
                recursion(x, y+div, div)
                recursion(x+div, y, div)
                recursion(x+div, y+div, div)
                return
    result[target] += 1


result = [0, 0]
recursion(0, 0, len(matrix))

print(result[0])
print(result[1])

# * ========================================================
# * @Title       : 2630
# * @Path        : python\02_Solved\boj\d.분할정복\2630.py
# * @Description :
# * @Date        : 2021-08-02 16:28:19
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(matrix):
    result = [0, 0]

    input_len = len(matrix)

    # 쿼드 트리 구성
    def recursion(x, y, N):
        div = N // 2

        target = matrix[x][y]
        for i in range(x, x + N):
            for j in range(y, y + N):
                if target != matrix[i][j]:
                    recursion(x, y, div)
                    recursion(x, y+div, div)
                    recursion(x+div, y, div)
                    recursion(x+div, y+div, div)
                    return

        result[int(target)] += 1

    recursion(0, 0, input_len)

    return result


def test_01():
    matrix = [
        ['1', '1', '0', '0', '0', '0', '1', '1'],
        ['1', '1', '0', '0', '0', '0', '1', '1'],
        ['0', '0', '0', '0', '1', '1', '0', '0'],
        ['0', '0', '0', '0', '1', '1', '0', '0'],
        ['1', '0', '0', '0', '1', '1', '1', '1'],
        ['0', '1', '0', '0', '1', '1', '1', '1'],
        ['0', '0', '1', '1', '1', '1', '1', '1'],
        ['0', '0', '1', '1', '1', '1', '1', '1'],
    ]
    assert solution(matrix) == [9, 7]


def test_02():
    matrix = [
        ['1', '0', '1', '0'],
        ['0', '0', '0', '0'],
        ['1', '0', '1', '0'],
        ['0', '0', '0', '0'],
    ]
    assert solution(matrix) == [12, 4]


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
    assert solution(matrix) == [13, 15]


def test_04():
    assert 1 == 1
