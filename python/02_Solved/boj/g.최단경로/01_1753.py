import sys

# * ========================================================
# * @Title       : 1753
# * @Path        : python\02_Solved\boj\g.최단경로\01_1753.py
# * @Link        : https://www.acmicpc.net/problem/1753
# * @Description :
# * @Note        : https://www.acmicpc.net/board/view/71956
# * @Date        : 2021-08-09 15:38:00
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, start, graph):
    # 다익스트라는 최소 힙을 이용해야 한다. 가중치가 적은 인접 노드를 선택해야 하므로
    from heapq import heappop, heappush
    INF = sys.maxsize
    distance = [INF for _ in range(vertex + 1)]
    # 시작 노드는 가중치가 없으므로 0으로 초기화
    distance[start] = 0

    def dijkstra(start, graph):
        heap = []
        heappush(heap, (0, start))
        while heap:
            lw, lv = heappop(heap)

            # 저장된 노드의 가중치가 현재 가중치보다 작다면 패스
            if distance[lv] < lw:
                continue

            # 인접 노드
            for nv, w in graph[lv]:
                # 인접 노드의 가중치
                nw = lw + w
                if nw < distance[nv]:
                    distance[nv] = nw
                    heappush(heap, (nw, nv))

    dijkstra(start, graph)

    for i in range(1, len(distance)):
        print("INF" if distance[i] == INF else distance[i])


# 입력
vertex, edge = list(map(int, sys.stdin.readline().split()))
start = int(input())
graph = [[] for _ in range(vertex + 1)]
for _ in range(edge):
    u, v, w = list(map(int, sys.stdin.readline().split()))
    graph[u].append((v, w))

solution(vertex, edge, start, graph)


def test_01(capfd):
    vertex = 5
    edge = 6
    start = 1
    pairs = [
        [5, 1, 1],
        [1, 2, 2],
        [1, 3, 3],
        [2, 3, 4],
        [2, 4, 5],
        [3, 4, 6],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, start, graph)
    out, err = capfd.readouterr()
    result = '0\n2\n3\n7\nINF\n'
    assert out == result


def test_02(capfd):
    vertex = 5
    edge = 6
    start = 2
    pairs = [
        [5, 1, 1],
        [1, 2, 2],
        [1, 3, 3],
        [2, 3, 4],
        [2, 4, 5],
        [3, 4, 6],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, start, graph)
    out, err = capfd.readouterr()
    result = 'INF\n0\n4\n5\nINF\n'
    assert out == result


def test_03(capfd):
    vertex = 4
    edge = 4
    start = 1
    pairs = [
        [1, 2, 7],
        [1, 4, 5],
        [2, 3, 3],
        [3, 4, 7],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    solution(vertex, edge, start, graph)
    out, err = capfd.readouterr()
    result = '0\n7\n10\n5\n'
    assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
