import sys

# * ========================================================
# * @Title       : 9370
# * @Path        : python\02_Solved\boj\g.최단경로\03_9370.py
# * @Link        : https://www.acmicpc.net/problem/9370
# * @Description :
# * @Note        :
# * @Date        : 2021-08-10 10:58:19
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(n, args, goal, graph):
    from heapq import heappop, heappush
    start, v1, v2 = args
    INF = sys.maxsize

    def dijkstra(start, graph):
        distance = [INF for _ in range(n + 1)]
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
                    heap.append((nw, nv))
        return distance

    # 1번부터 vertex까지
    start_1 = dijkstra(start, graph)
    start_v1 = dijkstra(v1, graph)
    start_v2 = dijkstra(v2, graph)

    # 1>v1>v2>goal
    # 1>v2>v1>goal

    result = []
    for g in goal:
        w1 = start_1[v1] + start_v1[v2] + start_v2[g]
        w2 = start_1[v2] + start_v2[v1] + start_v1[g]
        if start_1[g] >= min(w1, w2):
            result.append(g)
    result.sort()
    print(' '.join(list(map(str, result))))
    return 1


# 입력
for _ in range(int(input())):
    n, m, t = list(map(int, sys.stdin.readline().split()))
    args = list(map(int, sys.stdin.readline().split()))
    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        u, v, w = list(map(int, sys.stdin.readline().split()))
        graph[u].append((v, w))
        graph[v].append((u, w))
    goal = [0 for _ in range(t)]
    for i in range(t):
        goal[i] = int(sys.stdin.readline())

    solution(n, args, goal, graph)


def test_01(capfd):
    n = 5   # 교차로(정점)
    m = 4   # 도로(간선)
    t = 2   # 목적지후보갯수
    # start = 1   # 시작점
    # g = 2   # 경유해야 하는 지점 1
    # h = 3   # 경유해야 하는 지점 2
    args = [1, 2, 3]
    pairs = [
        [1, 2, 6],
        [2, 3, 2],
        [3, 4, 4],
        [3, 5, 3],
    ]
    goal = [5, 4]
    graph = [[] for _ in range(n + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
        graph[v].append((u, w))
    solution(n, args, goal, graph)
    out, err = capfd.readouterr()
    result = '4 5\n'
    assert out == result


def test_02(capfd):
    n = 6
    m = 9
    t = 2
    args = [2, 3, 1]
    pairs = [
        [1, 2, 1],
        [1, 3, 3],
        [2, 4, 4],
        [2, 5, 5],
        [3, 4, 3],
        [3, 6, 2],
        [4, 5, 4],
        [4, 6, 3],
        [5, 6, 7],
    ]
    goal = [5, 6]
    graph = [[] for _ in range(n + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
        graph[v].append((u, w))
    solution(n, args, goal, graph)
    out, err = capfd.readouterr()
    result = '6\n'
    assert out == result


def test_03(capfd):
    n = 3
    m = 3
    t = 1
    args = [1, 2, 3]
    pairs = [
        [1, 2, 3],
        [1, 3, 1],
        [2, 3, 1],
        [1, 2, 2],
    ]
    goal = [2]
    graph = [[] for _ in range(n + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
        graph[v].append((u, w))
    solution(n, args, goal, graph)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_04(capfd):
    n = 6
    m = 5
    t = 3
    args = [1, 2, 3]
    pairs = [
        [1, 2, 1],
        [2, 3, 1],
        [3, 4, 1],
        [4, 5, 1],
        [5, 6, 1],
    ]
    goal = [4, 5, 6]
    graph = [[] for _ in range(n + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
        graph[v].append((u, w))
    solution(n, args, goal, graph)
    out, err = capfd.readouterr()
    result = '4 5 6\n'
    assert out == result


def test_05(capfd):
    n = 8
    m = 7
    t = 3
    args = [8, 2, 1]
    pairs = [
        [1, 8, 1000],
        [1, 3, 1000],
        [1, 2, 1000],
        [1, 7, 1000],
        [2, 6, 1000],
        [5, 7, 1000],
        [3, 4, 1000],
    ]
    goal = [4, 5, 6]
    graph = [[] for _ in range(n + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
        graph[v].append((u, w))
    solution(n, args, goal, graph)
    out, err = capfd.readouterr()
    result = '6\n'
    assert out == result

# 9


def test_06(capfd):
    n = 11
    m = 12
    t = 2
    args = [1, 4, 7]
    pairs = [
        [1, 4, 7],
        [1, 2, 1],
        [2, 3, 1],
        [2, 4, 2],
        [2, 5, 3],
        [3, 6, 1],
        [4, 7, 1],
        [5, 8, 1],
        [6, 9, 3],
        [7, 9, 2],
        [8, 9, 1],
        [9, 10, 1],
        [7, 11, 1],
    ]
    goal = [10, 11]
    graph = [[] for _ in range(n + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))
        graph[v].append((u, w))
    solution(n, args, goal, graph)
    out, err = capfd.readouterr()
    result = '10 11\n'
    assert out == result
