import sys

# * ========================================================
# * @Title       : 11657
# * @Path        : python\02_Solved\boj\g.최단경로\04_11657.py
# * @Link        : https://www.acmicpc.net/problem/11657
# * @Description : 타임머신
# * @Note        : 벨먼-포드 알고리즘
# * @Date        : 2021-08-10 13:35:16
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, graph):
    INF = sys.maxsize
    start = 1
    # 간선 안화를 모든 간선에 대해 vertex - 1번 수행
    # 왜 간선 * (정점 - 1) 이냐면:
    # 정점의 갯수가 5개라면 최단 경로는 최대 4개까지 존재할 수 있기 떄문이다.
    # A B C D E
    # 만약 A-E에서의 최단경로가 A-E이라면 아래 또한 최단경로이다.
    # A-B, B-C, C-D, D-E

    def bellman_ford(start):
        distance = [INF for _ in range(vertex + 1)]
        distance[1] = 0

        # 시작정점을 제외하고 순회
        for _ in range(vertex - 1):
            for lu in range(1, vertex + 1):
                for nv, nw in graph[lu]:
                    if distance[lu] != INF and distance[nv] > distance[lu] + nw:
                        distance[nv] = distance[lu] + nw

        # 음수 사이클이 존재하는가?
        for lu in range(1, vertex + 1):
            for nv, nw in graph[lu]:
                if distance[lu] != INF and distance[nv] > distance[lu] + nw:
                    return []

        return distance

    result = bellman_ford(start)

    if len(result) == 0:
        print(-1)
    else:
        for i in range(start+1, vertex + 1):
            print(-1 if result[i] == INF else result[i])

    return 1


# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    vertex = 3
    edge = 4
    pairs = [
        [1, 2, 4],
        [1, 3, 3],
        [2, 3, -1],
        [3, 1, -2],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '4\n3\n'
    assert out == result


def test_02(capfd):
    vertex = 3
    edge = 4
    pairs = [
        [1, 2, 4],
        [1, 3, 3],
        [2, 3, -4],
        [3, 1, -2],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '-1\n'
    assert out == result


def test_03(capfd):
    vertex = 3
    edge = 2
    pairs = [
        [1, 2, 4],
        [1, 2, 3],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '3\n-1\n'
    assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
