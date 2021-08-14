import sys
sys.setrecursionlimit(10**6)

# * ========================================================
# * @Title       : 11724
# * @Path        : python\문제풀이\boj\z.분류별\11724_연결 요소의 개수.py
# * @Link        : https://www.acmicpc.net/problem/11724
# * @Description : 연결 요소의 개수
# * @Note        :
# * @Date        : 2021-08-14 12:25:55
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(vertex, edge, graph):
    visited = [False for _ in range(vertex + 1)]

    def DFS(v):
        for i in range(len(graph[v])):
            if not visited[graph[v][i]]:
                visited[graph[v][i]] = True
                DFS(graph[v][i])

    answer = 0

    for i in range(1, vertex + 1):
        if not visited[i]:
            visited[i] = True
            DFS(i)
            answer += 1

    print(answer)


# 입력
vertex, edge = list(map(int, sys.stdin.readline().split()))
graph = [[] for _ in range(vertex + 1)]
for _ in range(edge):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)
solution(vertex, edge, graph)


def test_01(capfd):
    vertex = 6
    edge = 5
    pairs = [
        [1, 2],
        [2, 5],
        [5, 1],
        [3, 4],
        [4, 6],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v in pairs:
        graph[u].append(v)
        graph[v].append(u)
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '2\n'
    assert out == result


def test_02(capfd):
    vertex = 6
    edge = 8
    pairs = [
        [1, 2],
        [2, 5],
        [5, 1],
        [3, 4],
        [4, 6],
        [5, 4],
        [2, 4],
        [2, 3],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v in pairs:
        graph[u].append(v)
        graph[v].append(u)
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '1\n'
    assert out == result


def test_03(capfd):
    vertex = 5
    edge = 1
    pairs = [
        [1, 2],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v in pairs:
        graph[u].append(v)
        graph[v].append(u)
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '4\n'
    assert out == result


def test_04(capfd):
    vertex = 6
    edge = 2
    pairs = [
        [3, 4],
        [4, 2],
    ]
    graph = [[] for _ in range(vertex + 1)]
    for u, v in pairs:
        graph[u].append(v)
        graph[v].append(u)
    solution(vertex, edge, graph)
    out, err = capfd.readouterr()
    result = '4\n'
    assert out == result
