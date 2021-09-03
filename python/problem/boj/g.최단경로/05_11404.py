import sys
INF = sys.maxsize

# * ========================================================
# * @Title       : 11404
# * @Path        : python\02_Solved\boj\g.최단경로\05_11404.py
# * @Link        : https://www.acmicpc.net/problem/11404
# * @Description : 플로이드
# * @Note        : O(v^3)
# * @Date        : 2021-08-10 15:08:13
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, graph):
    def floyd_warshall():
        # 중앙정점, 거쳐가는 정점
        for center in range(1, vertex + 1):
            # 시작하는 정점
            for start in range(1, vertex + 1):
                # 종료하는 정점
                for end in range(1, vertex + 1):
                    if graph[start][end] > graph[start][center] + graph[center][end]:
                        graph[start][end] = graph[start][center] + \
                            graph[center][end]
        return graph

    result = floyd_warshall()

    for i in range(1, vertex + 1):
        for j in range(1, vertex + 1):
            print(0 if result[i][j] == INF else result[i][j], end=" ")
        print()


# 입력
vertex = int(input())
edge = int(input())
graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
for _ in range(edge):
    u, v, w = list(map(int, sys.stdin.readline().split()))
    graph[u][u] = 0
    if graph[u][v] > w:
        graph[u][v] = w
solution(vertex, edge, graph)


def test_01(capfd):
    vertex = 5
    edge = 14
    pairs = [
        [1, 2, 2],
        [1, 3, 3],
        [1, 4, 1],
        [1, 5, 10],
        [2, 4, 2],
        [3, 4, 1],
        [3, 5, 1],
        [4, 5, 3],
        [3, 5, 10],
        [3, 1, 8],
        [1, 4, 2],
        [5, 1, 7],
        [3, 4, 2],
        [5, 2, 4],
    ]
    graph = [[INF for _ in range(vertex + 1)] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u][u] = 0
        if graph[u][v] > w:
            graph[u][v] = w
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '0 2 3 1 4 \n12 0 15 2 5 \n8 5 0 1 1 \n10 7 13 0 3 \n7 4 10 6 0 \n'
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
