import sys

# * ========================================================
# * @Title       : 11729
# * @Path        : python\문제풀이\boj\z.분류별\11729_하노이 탑 이동 순서.py
# * @Link        : https://www.acmicpc.net/problem/11729
# * @Description : 하노이 탑 이동 순서
# * @Note        :
# * @Date        : 2021-08-12 18:46:00
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# Solve 함수


def solution(N):

    answer = []

    def hanoi(cnt, start, by, end, answer):
        if cnt == 1:
            answer.append([start, end])
            return

        hanoi(cnt - 1, start, end, by, answer)
        answer.append([start, end])
        hanoi(cnt - 1, by, start, end, answer)

    hanoi(N, 1, 2, 3, answer)

    print(len(answer))
    for a in answer:
        print(' '.join(map(str, a)))

# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    n = 3
    solution(n)
    out, err = capfd.readouterr()
    result = '7\n1 3\n1 2\n3 2\n1 3\n2 1\n2 3\n1 3\n'
    assert out == result


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
