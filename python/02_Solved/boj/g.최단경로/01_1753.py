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
def solution(vertex, edge, start, pairs):
    from collections import deque
    graph = [[] for _ in range(vertex + 1)]
    for u, v, w in pairs:
        graph[u].append((v, w))

    # 출발점으로부터의 최단거리를 저장할 배열 d[v]를 만든다.
    visited = [False for _ in range(vertex + 1)]
    distance = [float('INF') for _ in range(vertex + 1)]
    # 출발 노드에는 0을, 출발점을 제외한 다른 노드들에는 매우 큰 값 INF를 채워 넣는다.
    distance[start] = 0

    queue = deque()

    # 현재 노드를 나타내는 변수 A에 출발 노드의 번호를 저장한다.
    queue.append(start)
    while queue:
        v = queue.popleft()
        for i in range(len(graph[v])):
            # A로부터 갈 수 있는 임의의 노드 B에 대해, d[A] + P[A][B][7]와 d[B][8]의 값을 비교한다.
            # INF와 비교할 경우 무조건 전자가 작다.

            # 만약 d[A] + P[A][B]의 값이 더 작다면, 즉 더 짧은 경로라면, d[B]의 값을 이 값으로 갱신시킨다.
            distance[graph[v][i][0]] = \
                min(distance[v] + graph[v][i][1], distance[graph[v][i][0]])
            # A의 모든 이웃 노드 B에 대해 이 작업을 수행한다.

            # "미방문" 상태인 모든 노드들 중, 출발점으로부터의 거리가 제일 짧은 노드 하나를 골라서 그 노드를 A에 저장한다.
            if not visited[graph[v][i][0]]:
                queue.append(graph[v][i][0])
        # A의 상태를 "방문 완료"로 바꾼다. 그러면 이제 더 이상 A는 사용하지 않는다.
        visited[v] = True

    for i in range(1, len(distance)):
        print(str(distance[i]).upper())


# 입력
vertex, edge = list(map(int, sys.stdin.readline().split()))
start = int(input())
pairs = []
for _ in range(edge):
    pairs.append(list(map(int, sys.stdin.readline().split())))

solution(vertex, edge, start, pairs)


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
    solution(vertex, edge, start, pairs)
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
    solution(vertex, edge, start, pairs)
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
    solution(vertex, edge, start, pairs)
    out, err = capfd.readouterr()
    result = '0\n7\n10\n5\n'
    assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
