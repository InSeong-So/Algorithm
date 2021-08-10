import sys

# * ========================================================
# * @Title       : 1504
# * @Path        : python\02_Solved\boj\g.최단경로\02_1504.py
# * @Link        : https://www.acmicpc.net/problem/1504
# * @Description : 특정한 최단 경로
# * @Note        : 비둘기집의 원리...?, https://www.acmicpc.net/board/view/59341 <- java
# * @Date        : 2021-08-10 08:54:25
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, graph, require_path):
    from heapq import heappop, heappush
    INF = sys.maxsize
    v1, v2 = require_path  # 거쳐야 하는 정점

    def dijkstra(start):
        distance = [INF for _ in range(vertex + 1)]
        distance[start] = 0
        heap = [(0, start)]
        while heap:
            lw, lv = heappop(heap)
            if distance[lv] < lw:
                continue
            for nv, w in graph[lv]:
                nw = lw + w
                if distance[nv] > nw:
                    distance[nv] = nw
                    heappush(heap, (nw, nv))
        return distance

    # 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치려면?
    # 1 > v1 > v2 > N
    # 1 > v2 > v1 > N
    # 총 두 가지 케이스
    # 중복으로 발생하는 경우에 대한 처리가 되어있지 않음

    start_1 = dijkstra(1)       # 1 to vertex에 대한 가중치
    start_v1 = dijkstra(v1)     # v1 to vertex에 대한 가중치
    start_v2 = dijkstra(v2)     # v2 to vertex에 대한 가중치
    # 위의 케이스를 점화식 -> 코드로 구현
    # 1 > v1 > v2 > N
    w1 = start_1[v1] + start_v1[v2] + start_v2[vertex]
    # 1 > v2 > v1 > N
    w2 = start_1[v2] + start_v2[v1] + start_v1[vertex]
    if w1 >= INF or w2 >= INF:
        print(-1)
    else:
        print(min(w1, w2))


# 입력
vertex, edge = list(map(int, sys.stdin.readline().split()))
graph = [[] for _ in range(vertex + 1)]
for _ in range(edge):
    u, v, w = list(map(int, sys.stdin.readline().split()))
    graph[u].append((v, w))
    graph[v].append((u, w))
require_path = list(map(int, sys.stdin.readline().split()))

solution(vertex, edge, graph, require_path)


def test_01(capfd):
    vertex = 4
    edge = 6
    pairs = [
        [1, 2, 3],
        [2, 3, 3],
        [3, 4, 1],
        [1, 3, 5],
        [2, 4, 5],
        [1, 4, 4],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for p in pairs:
        u, v, w = p
        graph[u].append((v, w))
        graph[v].append((u, w))
    require_path = [2, 3]
    solution(vertex, edge, graph, require_path)
    out, err = capfd.readouterr()
    result = '7\n'
    assert out == result


def test_02(capfd):
    vertex = 4
    edge = 3
    pairs = [
        [1, 4, 1],
        [2, 4, 2],
        [3, 4, 3],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for p in pairs:
        u, v, w = p
        graph[u].append((v, w))
        graph[v].append((u, w))
    require_path = [2, 3]
    solution(vertex, edge, graph, require_path)
    out, err = capfd.readouterr()
    result = '11\n'
    assert out == result


def test_03(capfd):
    vertex = 3
    edge = 3
    pairs = [
        [1, 2, 1],
        [1, 3, 3],
        [2, 3, 1],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for p in pairs:
        u, v, w = p
        graph[u].append((v, w))
        graph[v].append((u, w))
    require_path = [1, 3]
    solution(vertex, edge, graph, require_path)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_04(capfd):
    vertex = 4
    edge = 5
    pairs = [
        [1, 3, 4],
        [1, 4, 6],
        [3, 4, 1],
        [4, 2, 2],
        [2, 3, 3],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for p in pairs:
        u, v, w = p
        graph[u].append((v, w))
        graph[v].append((u, w))
    require_path = [1, 3]
    solution(vertex, edge, graph, require_path)
    out, err = capfd.readouterr()
    result = '5\n'
    assert out == result


def test_05(capfd):
    vertex = 4
    edge = 6
    pairs = [
        [1, 4, 1],
        [4, 2, 1],
        [2, 3, 1],
        [2, 1, 1],
        [3, 2, 1],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for p in pairs:
        u, v, w = p
        graph[u].append((v, w))
        graph[v].append((u, w))
    require_path = [1, 3]
    solution(vertex, edge, graph, require_path)
    out, err = capfd.readouterr()
    result = '4\n'
    assert out == result


def test_06(capfd):
    vertex = 5
    edge = 4
    pairs = [
        [1, 2, 3],
        [2, 5, 3],
        [3, 4, 1],
        [1, 5, 5],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for p in pairs:
        u, v, w = p
        graph[u].append((v, w))
        graph[v].append((u, w))
    require_path = [2, 3]
    solution(vertex, edge, graph, require_path)
    out, err = capfd.readouterr()
    result = '-1\n'
    assert out == result
