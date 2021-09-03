import sys

# * ========================================================
# * @Title       : 1916
# * @Path        : python\문제풀이\boj\z.분류별\1916_최소비용 구하기.py
# * @Link        : https://www.acmicpc.net/problem/1916
# * @Description : 최소비용 구하기
# * @Note        :
# * @Date        : 2021-08-12 22:36:30
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, graph, goal):
    from heapq import heappop, heappush
    INF = sys.maxsize
    start = goal[0]
    end = goal[1]

    def dijkstra(start):
        distance = [INF for _ in range(vertex + 1)]
        distance[start] = 0
        heap = []
        heappush(heap, (0, start))
        while heap:
            lw, lv = heappop(heap)
            if distance[lv] < lw:
                continue
            for nv, w in graph[lv]:
                nw = w + lw
                if distance[nv] > nw:
                    distance[nv] = nw
                    heappush(heap, (nw, nv))
        return distance

    result = dijkstra(start)
    print(result[end])


# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    vertex = 5
    edge = 8
    pairs = [
        [1, 2, 2],
        [1, 3, 3],
        [1, 4, 1],
        [1, 5, 10],
        [2, 4, 2],
        [3, 4, 1],
        [3, 5, 1],
        [4, 5, 3],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    goal = [1, 5]
    solution(vertex, edge, graph, goal)
    out, err = capfd.readouterr()
    result = '4\n'
    assert out == result


def test_02(capfd):
    vertex = 5
    edge = 3
    pairs = [
        [1, 2, 2],
        [1, 3, 5],
        [2, 3, 1],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    goal = [1, 3]
    solution(vertex, edge, graph, goal)
    out, err = capfd.readouterr()
    result = '3\n'
    assert out == result


def test_03(capfd):
    vertex = 5
    edge = 3
    pairs = [
        [1, 2, 2],
        [1, 3, 1],
        [1, 3, 5],
        [2, 3, 1],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
    goal = [1, 3]
    solution(vertex, edge, graph, goal)
    out, err = capfd.readouterr()
    result = '1\n'
    assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
