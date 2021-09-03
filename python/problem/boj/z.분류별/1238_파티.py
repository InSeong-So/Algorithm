import sys

# * ========================================================
# * @Title       : 1238
# * @Path        : python\문제풀이\boj\z.분류별\1238_파티.py
# * @Link        : https://www.acmicpc.net/problem/1238
# * @Description : 파티
# * @Note        : 그래프 뒤집기
# * @Date        : 2021-08-13 14:30:44
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, goal, graph):
    from heapq import heappop, heappush
    INF = sys.maxsize

    def dijkstra(start, graph):
        distance = [INF for _ in range(vertex + 1)]
        distance[0] = 0
        distance[start] = 0
        heap = []
        heappush(heap, (0, start))
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

    def reverse_graph(graph):
        rev = [[] for _ in range(vertex + 1)]
        for u in range(len(graph)):
            for v, w in graph[u]:
                rev[v].append((u, w))
        return rev

    goal_distance = dijkstra(goal, graph)
    start_distance = dijkstra(goal, reverse_graph(graph))

    answer = 0
    for a, b in zip(goal_distance, start_distance):
        answer = max(a+b, answer)

    print(answer)


# 입력
n, m, x = list(map(int, sys.stdin.readline().split()))
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v, w = list(map(int, sys.stdin.readline().split()))
    graph[u].append((v, w))

solution(n, m, x, graph)


def test_01(capfd):
    vertex = 4
    edge = 8
    goal = 2
    pairs = [
        [1, 2, 4],
        [1, 3, 2],
        [1, 4, 7],
        [2, 1, 1],
        [2, 3, 5],
        [3, 1, 2],
        [3, 4, 4],
        [4, 2, 3],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, goal, graph)
    out, err = capfd.readouterr()
    result = '10\n'
    assert out == result


# def test_02(capfd):
#     vertex = 4
#     edge = 8
#     goal = 2
#     pairs = [
#         [1, 2, 4],
#         [1, 3, 2],
#         [1, 4, 7],
#         [2, 1, 1],
#         [2, 3, 5],
#         [3, 1, 2],
#         [3, 4, 4],
#         [4, 2, 3],
#     ]
#     graph = [[] for _ in range(vertex + 1)]
#     for u, v, w in pairs:
#         graph[u].append((v, w))
#     solution(vertex, edge, goal, graph)
#     out, err = capfd.readouterr()
#     result = '\n'
#     assert out == result


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
