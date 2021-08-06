# import sys
# N = int(input())
# apts = []
# for _ in range(N):
#     apts.append(sys.stdin.readline())

# * ========================================================
# * @Title       : 2667
# * @Path        : python\02_Solved\boj\f.DFS와BFS\2667.py
# * @Description :
# * @Date        : 2021-08-06 13:33:02
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, apts):

    for i in range(N):
        apts[i] = list(apts[i])

    from collections import deque
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    queue = deque([])

    def BFS(x, y):
        count = 0
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx >= 0 and nx < N and ny >= 0 and ny < N and apts[nx][ny] == '1':
                    apts[nx][ny] = '0'
                    queue.append([nx, ny])
                    count += 1
        return count if count != 0 else 1

    result = []

    for i in range(N):
        for j in range(N):
            if apts[i][j] == '1':
                queue.append([i, j])
                result.append(BFS(i, j))

    print(len(result))
    result.sort()
    for r in result:
        print(r)


# solution(N, apts)


def test_01(capfd):
    N = 7
    apts = [
        '0110100',
        '0110101',
        '1110101',
        '0000111',
        '0100000',
        '0111110',
        '0111000',
    ]
    solution(N, apts)
    out, err = capfd.readouterr()
    assert out == '3\n7\n8\n9\n'


def test_02(capfd):
    N = 7
    apts = [
        '0110000',
        '0110000',
        '1110000',
        '0000000',
        '0000000',
        '0000000',
        '0000000',
    ]
    solution(N, apts)
    out, err = capfd.readouterr()
    assert out == '1\n7\n'


def test_03(capfd):
    N = 5
    apts = [
        '11010',
        '10110',
        '11010',
        '01110',
        '00000',
    ]
    solution(N, apts)
    out, err = capfd.readouterr()
    assert out == '1\n12\n'


def test_04(capfd):
    N = 7
    apts = [
        '0110111',
        '1101110',
        '1001011',
        '1011111',
        '1011111',
        '1111100',
        '1111000',
    ]
    solution(N, apts)
    out, err = capfd.readouterr()
    assert out == '1\n35\n'


def test_05(capfd):
    N = 5
    apts = [
        '10101',
        '01111',
        '11111',
        '01011',
        '10111',
    ]
    solution(N, apts)
    out, err = capfd.readouterr()
    assert out == '3\n1\n1\n17\n'
