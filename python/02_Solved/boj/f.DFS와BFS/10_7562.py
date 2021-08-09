import sys

# * ========================================================
# * @Title       : 7562
# * @Path        : python\02_Solved\boj\f.DFS와BFS\7562.py
# * @Link        : https://www.acmicpc.net/problem/7562
# * @Description : 나이트의 이동
# * @Date        : 2021-08-09 12:13:19
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, knight):
    from collections import deque
    board = [[0 for _ in range(N)] for _ in range(N)]

    dx = [-1, -2, -2, -1, 1, 2, 2, 1]
    dy = [-2, -1, 1, 2, 2, 1, -1, -2]

    queue = deque()
    x, y = knight[0]
    # 방문 처리
    board[x][y] = 1
    queue.append([x, y])

    while queue:
        lx, ly = queue.popleft()
        if lx == knight[1][0] and ly == knight[1][1]:
            break
        for i in range(8):
            nx, ny = lx + dx[i], ly + dy[i]
            if nx >= 0 and nx < N and ny >= 0 and ny < N and board[nx][ny] == 0:
                board[nx][ny] = board[lx][ly] + 1
                queue.append([nx, ny])

    print(board[knight[1][0]][knight[1][1]] - 1)


# T
for _ in range(int(input())):
    N = int(input())
    knight = []
    for _ in range(2):
        knight.append(list(map(int, sys.stdin.readline().split())))
    solution(N, knight)


def test_01(capfd):
    N = 8
    knight = [
        [0, 0],
        [7, 0]
    ]
    solution(N, knight)
    out, err = capfd.readouterr()
    assert out == '5\n'


def test_02(capfd):
    N = 100
    knight = [
        [0, 0],
        [30, 50]
    ]
    solution(N, knight)
    out, err = capfd.readouterr()
    assert out == '28\n'


def test_03(capfd):
    N = 10
    knight = [
        [1, 1],
        [1, 1]
    ]
    solution(N, knight)
    out, err = capfd.readouterr()
    assert out == '0\n'


def test_04(capfd):
    N = 8
    knight = [
        [0, 0],
        [7, 7]
    ]
    solution(N, knight)
    out, err = capfd.readouterr()
    assert out == '6\n'


# 숏코딩;
def short():
    for __ in range(int(input())):
        n = int(input())
        sx, sy = map(int, input().split())
        ex, ey = map(int, input().split())
        if sx > ex:
            (sx, sy), (ex, ey) = (ex, ey), (sx, sy)
        if sy > ey:
            sy = (n-1)-sy
            ey = (n-1)-ey
        dx, dy = ex-sx, ey-sy
        if dx > dy:
            sx, sy = sy, sx
            ex, ey = ey, ex
            dx, dy = dy, dx
        ans = max((dy+1)//2, (dx+dy+2)//3)
        ans += dx+dy+ans & 1
        d = dx, dy
        if d == (0, 1):
            ans = 3
        elif d == (0, 3):
            if n == 4 and sx in (0, 3):
                ans = 5
            else:
                ans = 3
        elif d == (1, 1):
            m1x, m1y = sx+2, sy-1
            m2x, m2y = sx-1, sy+2
            if 0 <= m1x < n > m1y >= 0 or 0 <= m2x < n > m2y >= 0:
                ans = 2
            else:
                ans = 4
        elif d == (2, 2):
            ans = 4
        print(ans)
