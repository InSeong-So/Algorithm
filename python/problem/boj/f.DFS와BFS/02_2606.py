import sys

N = int(input())
edge = int(input())
computers = []
for _ in range(edge):
    computers.append(list(map(int, sys.stdin.readline().split())))

# * ========================================================
# * @Title       : 2606
# * @Path        : python\02_Solved\boj\f.DFS와BFS\2606.py
# * @Description :
# * @Date        : 2021-08-06 12:46:16
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, edge, computers):

    computers.sort()

    visited = [0 for _ in range(N + 1)]
    graph = [[] for _ in range(N + 1)]

    for a, b in computers:
        graph[a].append(b)
        graph[b].append(a)

    def DFS(v):
        count = 0
        for i in range(len(graph[v])):
            if visited[graph[v][i]] == 0:
                visited[graph[v][i]] = 1
                count += DFS(graph[v][i]) + 1
        return count

    visited[1] = 1
    print(DFS(1))


solution(N, edge, computers)


def test_01(capfd):
    N = 10
    edge = 6
    computers = [
        [1, 2],
        [2, 3],
        [1, 5],
        [5, 2],
        [5, 6],
        [4, 7],
    ]

    solution(N, edge, computers)
    out, err = capfd.readouterr()
    assert out == '4\n'


def test_02(capfd):
    N = 10
    edge = 4
    computers = [
        [1, 2],
        [2, 3],
        [5, 6],
        [4, 7],
    ]

    solution(N, edge, computers)
    out, err = capfd.readouterr()
    assert out == '2\n'


def test_03(capfd):
    N = 10
    edge = 4
    computers = [
        [2, 3],
        [1, 2],
        [1, 5],
        [5, 2],
        [5, 6],
        [4, 7],
    ]

    solution(N, edge, computers)
    out, err = capfd.readouterr()
    assert out == '2\n'


# def test_04(capfd):
#     solution()
#     out, err = capfd.readouterr()
#     assert out == ''
