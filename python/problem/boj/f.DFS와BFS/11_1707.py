import sys

# * ========================================================
# * @Title       : 1707
# * @Path        : python\02_Solved\boj\f.DFS와BFS\1707.py
# * @Link        : https://www.acmicpc.net/problem/1707
# * @Description : 이분그래프
# * @Date        : 2021-08-09 12:41:47
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
'''
1. 최초 탐색 시작할 정점의 색상을 빨간색으로 칠한다.(숫자 1로 표현)
2. 최초 정점의 인접 정점의 색상을 파란색으로 칠한다.(숫자 -1로 표현)
3. 해당 인접 정점들을 차례로 탐색을 시작하며 자신과 인접한 정점을 빨간색으로 칠한다.(숫자 1로 표현)
4. 이와 같은 방식을 탐색을 지속하며 반복하여 2개의 색상으로 모두 칠한다.
5. 색상을 칠하다가 이웃 정점이 같은 색으로 칠해져 있다면 이분 그래프가 될 수 없다.
'''


def solution(vertex, edge, pairs):
    from collections import deque
    graph = [[] for _ in range(vertex + 1)]
    for a, b in pairs:
        graph[a].append(b)
        graph[b].append(a)

    colors = [0 for _ in range(vertex + 1)]

    def BFS(graph, colors, queue):
        while queue:
            v = queue.popleft()
            for i in range(len(graph[v])):
                if colors[graph[v][i]] == 0:
                    colors[graph[v][i]] = colors[v] * -1
                    queue.append(graph[v][i])
                elif colors[v] == colors[graph[v][i]]:
                    return "NO"
        return "YES"

    queue = deque()
    result = "YES"
    for i in range(len(graph)):
        if colors[i] == 0:
            colors[i] = 1
            queue.append(i)
            result = BFS(graph, colors, queue)
            if result == "NO":
                break

    print(result)


# for _ in range(int(input())):
#     vertex, edge = list(map(int, sys.stdin.readline().split()))
#     pairs = []
#     for _ in range(edge):
#         pairs.append(list(map(int, sys.stdin.readline().split())))

#     solution(vertex, edge, pairs)


def test_01(capfd):
    vertex = 3
    edge = 2
    pairs = [
        [1, 3],
        [2, 3],
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'YES\n'


def test_02(capfd):
    vertex = 4
    edge = 4
    pairs = [
        [1, 2],
        [2, 3],
        [3, 4],
        [4, 2],
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'NO\n'


# 이 경우 1번을 건너뛴다.
def test_03(capfd):
    vertex = 5
    edge = 3
    pairs = [
        [2, 1],
        [3, 1],
        [3, 2],
        [2, 3],
        [4, 1]
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'NO\n'


def test_04(capfd):
    vertex = 4
    edge = 2
    pairs = [
        [1, 2],
        [3, 4]
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'YES\n'


def test_05(capfd):
    vertex = 5
    edge = 4
    pairs = [
        [1, 2],
        [3, 4],
        [4, 5],
        [3, 5]
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'NO\n'

# ==?? 답이 왜 다르지


def test_06(capfd):
    vertex = 3
    edge = 2
    pairs = [
        [3, 1],
        [3, 2],
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'YES\n'


def test_07(capfd):
    vertex = 3
    edge = 2
    pairs = [
        [1, 3],
        [2, 3],
    ]
    solution(vertex, edge, pairs)
    out, err = capfd.readouterr()
    assert out == 'YES\n'
