import sys

# * ========================================================
# * @Title       : 2447
# * @Path        : python\문제풀이\boj\z.분류별\2447_별 찍기 10.py
# * @Link        : https://www.acmicpc.net/problem/2447
# * @Description :
# * @Note        :
# * @Date        : 2021-08-12 18:45:41
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution():
    print('')
    # return 1


# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    solution()
    out, err = capfd.readouterr()
    result = '\n'
    assert out == result
    # assert solution() == 0


# def test_02(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_03(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result

# 숏코딩
def solution(n):
    s = '*'
    while n > 1:
        t = [i*3 for i in s]
        s = t+[i+' '*len(i)+i for i in s]+t
        n //= 3
    print('\n'.join(s))


# 내 풀이
def solution(N):
    matrix = [[' ' for _ in range(N)] for _ in range(N)]

    def stars(x, y, sz):
        if sz == 1:
            matrix[x][y] = '*'
            return
        for i in range(3):
            for j in range(3):
                if i != 1 or j != 1:
                    stars(x + sz // 3 * i, y + sz // 3 * j, sz // 3)
    stars(0, 0, N)
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            print(matrix[i][j], end="")
        print()
