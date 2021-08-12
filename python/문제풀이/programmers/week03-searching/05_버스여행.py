# BFS
from collections import deque


def solution(n, signs):
    for start in range(n):
        queue = deque([end for end, sign in enumerate(signs[start]) if sign])

        while queue:
            route = queue.popleft()

            for end, sign in enumerate(signs[route]):
                if sign and signs[start][end] == 0:
                    signs[start][end] = 1
                    queue.append(end)

    return signs


# 플로이드-워셜
def solution(n, signs):
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if signs[i][k] == 1 and signs[k][j] == 1:
                    signs[i][j] = 1

    return signs
