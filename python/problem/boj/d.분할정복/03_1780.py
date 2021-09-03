import sys
matrix = []
for _ in range(int(input())):
    matrix.append(list(map(int, sys.stdin.readline().split())))


def recursion(x, y, N):
    div = N // 3
    target = matrix[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if target != matrix[i][j]:
                recursion(x, y, div)
                recursion(x, y+div, div)
                recursion(x, y+div*2, div)
                recursion(x+div, y, div)
                recursion(x+div, y+div, div)
                recursion(x+div, y+div*2, div)
                recursion(x+div*2, y, div)
                recursion(x+div*2, y+div, div)
                recursion(x+div*2, y+div*2, div)
                return
    result[target+1] += 1


result = [0, 0, 0]

recursion(0, 0, len(matrix))

print(result[0])
print(result[1])
print(result[2])

# * ========================================================
# * @Title       : 1780
# * @Path        : python\02_Solved\boj\d.분할정복\1780.py
# * @Description :
# * @Date        : 2021-08-03 12:03:30
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(matrix):

    def recursion(x, y, N):
        div = N // 3
        target = matrix[x][y]
        for i in range(x, x+N):
            for j in range(y, y+N):
                if target != matrix[i][j]:
                    recursion(x, y, div)
                    recursion(x, y+div, div)
                    recursion(x, y+div*2, div)
                    recursion(x+div, y, div)
                    recursion(x+div, y+div, div)
                    recursion(x+div, y+div*2, div)
                    recursion(x+div*2, y, div)
                    recursion(x+div*2, y+div, div)
                    recursion(x+div*2, y+div*2, div)
                    return
        result[target+1] += 1

    result = [0, 0, 0]

    recursion(0, 0, len(matrix))

    count = 0
    for r in result:
        if r == 0:
            count += 1

    if count == 2:
        return 1
    else:
        return result


def test_01():
    matrix = [
        [0, 0, 0, 1, 1, 1, -1, -1, -1],
        [0, 0, 0, 1, 1, 1, -1, -1, -1],
        [0, 0, 0, 1, 1, 1, -1, -1, -1],
        [1, 1, 1, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 0, 0, 0, 0, 0, 0],
        [0, 1, -1, 0, 1, -1, 0, 1, -1],
        [0, -1, 1, 0, 1, -1, 0, 1, -1],
        [0, 1, -1, 1, 0, -1, 0, 1, -1]]
    assert solution(matrix) == [10, 12, 11]


def test_02():
    matrix = [
        [0, 0, 0],
        [0, 0, 0],
        [0, 0, 0]
    ]
    assert solution(matrix) == 1


def test_03():
    matrix = [
        [0, 1, -1],
        [0, 1, -1],
        [0, 1, -1]
    ]
    assert solution(matrix) == [3, 3, 3]


def test_04():
    matrix = [
        [1, 1, -1],
        [1, 1, -1],
        [0, 0, -1]
    ]
    assert solution(matrix) == [3, 2, 4]
