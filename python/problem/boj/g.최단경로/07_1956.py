import sys
INF = sys.maxsize
# * ========================================================
# * @Title       : 1956
# * @Path        : python\02_Solved\boj\g.최단경로\07_1956.py
# * @Link        : https://www.acmicpc.net/problem/1956
# * @Description : 운동
# * @Note        :
# * @Date        : 2021-08-11 15:57:38
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, graph):

    def floyd_warshall(start):
        result = INF
        for transfer in range(1, vertex + 1):
            for start in range(1, vertex + 1):
                for end in range(1, vertex + 1):
                    if graph[start][end] > graph[start][transfer] + graph[transfer][end]:
                        graph[start][end] = graph[start][transfer] + \
                            graph[transfer][end]
                    if start != end and result > graph[start][end] + graph[end][start]:
                        result = graph[start][end] + graph[end][start]
        return result

    p = floyd_warshall(1)

    print(-1 if p == INF else p)


# # 입력
# vertex, edge = list(map(int, sys.stdin.readline().split()))
# graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
# for _ in range(edge):
#     u, v, w = map(int, sys.stdin.readline().rstrip().split())
#     graph[u][u] = 0
#     graph[u][v] = w

# solution(vertex, edge, graph)


def test_01(capfd):
    vertex = 3
    edge = 4
    pairs = [
        [1, 2, 1],
        [3, 2, 1],
        [1, 3, 5],
        [2, 3, 2],
    ]
    graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u][u] = 0
        graph[u][v] = w
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_02(capfd):
    vertex = 3
    edge = 6
    pairs = [
        [1, 2, 1],
        [2, 3, 1],
        [3, 1, 1],
        [2, 1, 3],
        [3, 2, 3],
        [1, 3, 3],
    ]
    graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u][u] = 0
        graph[u][v] = w
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_03(capfd):
    vertex = 3
    edge = 3
    pairs = [
        [1, 2, 1],
        [2, 3, 1],
        [3, 1, 1],
    ]
    graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u][u] = 0
        graph[u][v] = w
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_04(capfd):
    vertex = 5
    edge = 8
    pairs = [
        [2, 5, 5],
        [1, 3, 5],
        [1, 5, 9],
        [2, 4, 2],
        [4, 1, 9],
        [3, 2, 10],
        [3, 4, 9],
        [4, 3, 7],
    ]
    graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u][u] = 0
        graph[u][v] = w
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '16\n'
    assert out == result
