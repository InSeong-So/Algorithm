import sys

# * ========================================================
# * @Title       : 10217
# * @Path        : python\02_Solved\boj\g.최단경로\06_10217.py
# * @Link        : https://www.acmicpc.net/problem/10217
# * @Description : KCM Travel
# * @Note        : 이거 파이썬으로는 DP로 푸는 문제임
# * @Date        : 2021-08-11 12:40:26
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, money, edge, graph):
    from heapq import heappop, heappush
    INF = sys.maxsize

    def dijkstra(start):
        dp = [[INF for _ in range(money + 1)] for _ in range(vertex + 1)]
        dp[start][0] = 0
        heap = []
        heappush(heap, (0, 0, start))
        result = INF
        while heap:
            # last distance, last cost, last vertex
            ld, lc, lv = heappop(heap)
            if lv == vertex:
                result = ld
                break
            # next vertex, next cost, next distance
            for nv, c, d in graph[lv]:
                nc = c + lc
                nd = d + ld
                if nc > money or dp[nv][nc] <= nd:
                    continue
                for i in range(nc, money + 1):
                    if dp[nv][i] > nd:
                        dp[nv][i] = nd
                    else:
                        break
                heappush(heap, (nd, nc, nv))
        return result
    final_distance = dijkstra(1)
    print("Poor KCM" if final_distance == INF else final_distance)


# 입력
for _ in range(int(input())):
    vertex, money, edge = list(map(int, sys.stdin.readline().split()))
    graph = [[] for _ in range(vertex + 1)]
    for _ in range(edge):
        u, v, c, d = list(map(int, sys.stdin.readline().split()))
        graph[u].append((v, c, d))
    solution(vertex, money, edge, graph)


def test_01(capfd):
    vertex = 3
    money = 100
    edge = 3
    pairs = [
        [1, 2, 1, 1],
        [2, 3, 1, 1],
        [1, 3, 3, 30],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, c, d in pairs:
        graph[u].append((v, c, d))
    solution(vertex, money, edge, graph)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_02(capfd):
    vertex = 4
    money = 10
    edge = 4
    pairs = [
        [1, 2, 5, 3],
        [2, 3, 5, 4],
        [3, 4, 1, 5],
        [1, 3, 10, 6],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, c, d in pairs:
        graph[u].append((v, c, d))
    solution(vertex, money, edge, graph)
    out, err = capfd.readouterr()
    result = 'Poor KCM\n'
    assert out == result


def test_03(capfd):
    vertex = 6
    money = 149
    edge = 8
    pairs = [
        [1, 2, 60, 20],
        [2, 3, 30, 70],
        [1, 3, 100, 80],
        [1, 3, 20, 180],
        [3, 4, 20, 100],
        [3, 5, 150, 20],
        [5, 6, 50, 40],
        [4, 6, 30, 50],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v, c, d in pairs:
        graph[u].append((v, c, d))
    solution(vertex, money, edge, graph)
    out, err = capfd.readouterr()
    result = '240\n'
    assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
