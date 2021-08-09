import sys

N, M = list(map(int, sys.stdin.readline().split()))
map = []
for _ in range(N):
    map.append(input())

# * ========================================================
# * @Title       : 2206
# * @Path        : python\02_Solved\boj\f.DFS와BFS\2206.py
# * @Description :
# * @Date        : 2021-08-09 08:16:08
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
# BFS를 사용하면서, '현재 상태'를 어떻게 제어하는가


def solution(N, M, map):
    from collections import deque
    for i in range(len(map)):
        map[i] = list(map[i])

    # 두번째 원소는 벽을 부쉈는지의 '여부'에 대한 가중치
    visited = [[[0, 0] for _ in range(M + 1)] for _ in range(N + 1)]
    queue = deque()

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    # 초기화
    visited[0][0] = [0, 0]
    visited[1][1] = [1, 1]
    queue.append([1, 1, 0])

    broken = 0

    # BFS
    while queue:
        lx, ly, broken = queue.popleft()
        if lx == N and ly == 0:
            return
        for i in range(4):
            nx, ny = lx + dx[i], ly + dy[i]
            if nx > 0 and nx <= N and ny > 0 and ny <= M and visited[nx][ny][broken] == 0:
                # 벽이 있지만? 여태 벽을 부수지 않았다면 벽을 부수고 이동해도 됨, 그러나 다음번부터는 안됨
                if map[nx-1][ny-1] == '1' and broken == 0:
                    # 여기가 젤 중요하네...
                    visited[nx][ny][1] = visited[lx][ly][0] + 1
                    queue.append([nx, ny, 1])
                # 그냥 이동해도 됨
                elif map[nx-1][ny-1] == '0':
                    visited[nx][ny][broken] = visited[lx][ly][broken] + 1
                    queue.append([nx, ny, broken])

    print(-1 if visited[N][M][broken] == 0 else visited[N][M][broken])


solution(N, M, map)


def test_01(capfd):
    N = 6
    M = 4
    map = [
        '0100',
        '1110',
        '1000',
        '0000',
        '0111',
        '0000',
    ]

    solution(N, M, map)
    out, err = capfd.readouterr()
    assert out == '15\n'


def test_02(capfd):
    N = 4
    M = 4
    map = [
        '0111',
        '1111',
        '1111',
        '1110',
    ]

    solution(N, M, map)
    out, err = capfd.readouterr()
    assert out == '-1\n'


def test_03(capfd):
    N = 5
    M = 8
    map = [
        '01000000',
        '01010000',
        '01010000',
        '01010011',
        '00010010',
    ]

    solution(N, M, map)
    out, err = capfd.readouterr()
    assert out == '20\n'


def test_04(capfd):
    N = 2
    M = 4
    map = [
        '0111',
        '0010',
    ]

    solution(N, M, map)
    out, err = capfd.readouterr()
    assert out == '5\n'


def test_05(capfd):
    N = 1
    M = 1
    map = [
        '0',
    ]

    solution(N, M, map)
    out, err = capfd.readouterr()
    assert out == '1\n'
