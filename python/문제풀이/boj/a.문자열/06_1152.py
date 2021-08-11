# * ========================================================
# * @Title       : 1152
# * @Path        : python\02_Solved\boj\a.문자열\1152.py
# * @Link        : https://www.acmicpc.net/problem/1152
# * @Description :
# * @Date        : 2021-08-09 14:45:46
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(N):
    print(len(N.split()))
    # return 1


# 입력
# N = input()
# solution(N)


def test_01(capfd):
    N = 'The Curious Case of Benjamin Button'
    solution(N)
    out, err = capfd.readouterr()
    result = '6\n'
    assert out == result
    # assert solution() == 0


def test_02(capfd):
    N = ' Mazatneunde Wae Teullyeoyo'
    solution(N)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_03(capfd):
    N = 'Teullinika Teullyeotzi '
    solution(N)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_04(capfd):
    N = ' Test '
    solution(N)
    out, err = capfd.readouterr()
    result = '1\n'
    assert out == result
