expr_string = input()
cases = [
    ['+', '-'],
    ['-', '+']
]


def split_string(a):
    return a.replace('+', ',+,').replace('-', ',-,').split(',')


def calc(a, expr, b):
    if expr == '+':
        return str(int(a) + int(b))
    else:
        return str(int(a) - int(b))


result = []

for exp in cases:
    arr = split_string(expr_string)
    for k in exp:
        while True:
            try:
                idx = arr.index(k)
                left = arr[idx - 1]
                operator = arr[idx]
                right = arr[idx + 1]
                arr[idx-1:idx+2] = [calc(left, operator, right)]
            except:
                break
    result.append(int(arr[0]))

print(min(result))

# * ========================================================
# * @Title       : 1541
# * @Path        : python\02_Solved\boj\c.그리디알고리즘\1541.py
# * @Description :
# * @Date        : 2021-08-02 11:11:10
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(expr_string):
    cases = [
        ['+', '-'],
        ['-', '+']
    ]

    def split_string(a):
        return a.replace('+', ',+,').replace('-', ',-,').split(',')

    def calc(a, expr, b):
        result = 0

        if expr == '+':
            result = int(a) + int(b)
        else:
            result = int(a) - int(b)

        return str(result)

    result = []

    for exp in cases:
        arr = split_string(expr_string)
        for k in exp:
            while True:
                try:
                    idx = arr.index(k)
                    left = arr[idx - 1]
                    operator = arr[idx]
                    right = arr[idx + 1]
                    arr[idx-1:idx+2] = [calc(left, operator, right)]
                except:
                    break
        result.append(int(arr[0]))

    return min(result)


def test_01():
    exp = '55-50+40'
    assert solution(exp) == -35


def test_02():
    exp = '100-100+100'
    assert solution(exp) == -100


def test_03():
    exp = '05+060'
    assert solution(exp) == 65


def test_04():
    exp = '0-1'
    assert solution(exp) == -1


def test_05():
    exp = '55+50+100+52'
    assert solution(exp) == 257
