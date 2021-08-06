import sys

N, edge, start = list(map(int, sys.stdin.readline().split()))
arr = []
for _ in range(edge):
    arr.append(list(map(int, sys.stdin.readline().split())))


def solution(N, edge, start, arr):
    from collections import deque
    # 정렬
    arr.sort()

    # 방문 배열
    visited = [0 for _ in range(N + 1)]
    visited[start] = 1
    graph = [[] for _ in range(N + 1)]
    for a, b in arr:
        graph[a].append(b)
        graph[b].append(a)

    def BFS(start):
        queue = deque([])
        queue.append(start)
        while queue:
            v = queue.popleft()
            print(v, end=" ")
            graph[v].sort()
            for i in range(len(graph[v])):
                if visited[graph[v][i]] == 0:
                    visited[graph[v][i]] = 1
                    queue.append(graph[v][i])

    def DFS(v, n):
        for i in range(len(graph[v])):
            graph[v].sort()
            if visited[graph[v][i]] == 0:
                print(graph[v][i], end=" ")
                visited[graph[v][i]] = 1
                DFS(graph[v][i], n)
    print(start, end=" ")
    DFS(start, N)
    print()
    visited = [0 for _ in range(N + 1)]
    visited[start] = 1
    BFS(start)


solution(N, edge, start, arr)
# * ========================================================
# * @Title       : 1260
# * @Path        : python\02_Solved\boj\f.DFS와BFS\1260.py
# * @Description :
# * @Date        : 2021-08-06 09:15:43
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(N, edge, start, arr):
    from collections import deque
    # 정렬
    arr.sort()

    # 방문 배열
    visited = [0 for _ in range(N + 1)]
    visited[start] = 1
    graph = [[] for _ in range(N + 1)]
    for a, b in arr:
        graph[a].append(b)
        graph[b].append(a)

    def BFS(start):
        queue = deque([])
        queue.append(start)
        while queue:
            v = queue.popleft()
            print(v, end=" ")
            graph[v].sort()
            for i in range(len(graph[v])):
                if visited[graph[v][i]] == 0:
                    visited[graph[v][i]] = 1
                    queue.append(graph[v][i])

    def DFS(v, n):
        for i in range(len(graph[v])):
            graph[v].sort()
            if visited[graph[v][i]] == 0:
                print(graph[v][i], end=" ")
                visited[graph[v][i]] = 1
                DFS(graph[v][i], n)
    print(start, end=" ")
    DFS(start, N)
    print()
    visited = [0 for _ in range(N + 1)]
    visited[start] = 1
    BFS(start)


def test_01(capfd):
    N = 4
    edge = 5
    start = 1
    graph = [
        [1, 2],
        [1, 3],
        [1, 4],
        [2, 4],
        [3, 4],
    ]
    solution(N, edge, start, graph)
    out, err = capfd.readouterr()
    assert out == '1 2 4 3 \n1 2 3 4 '


def test_02(capfd):
    N = 5
    edge = 5
    start = 3
    graph = [
        [5, 4],
        [5, 2],
        [1, 2],
        [3, 4],
        [3, 1],
    ]
    solution(N, edge, start, graph)
    out, err = capfd.readouterr()
    assert out == '3 1 2 5 4 \n3 1 4 2 5 '


def test_03(capfd):
    N = 1000
    edge = 1
    start = 1000
    graph = [
        [999, 1000]
    ]
    solution(N, edge, start, graph)
    out, err = capfd.readouterr()
    assert out == '1000 999 \n1000 999 '


def test_04(capfd):
    N = 3
    edge = 2
    start = 1
    graph = [
        [1, 3],
        [2, 1],
    ]

    solution(N, edge, start, graph)
    out, err = capfd.readouterr()
    assert out == '1 2 3 \n1 2 3 '
    # assert solution(N, edge, start, graph) == 1
