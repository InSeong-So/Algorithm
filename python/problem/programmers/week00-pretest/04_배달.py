# 배달
from heapq import heappush, heappop


def solution(N, road, K):
    dist = dijkstra(road, N)
    return len([x for x in dist if x <= K])  # list comprehension


def dijkstra(road, N):
    # 최단 거리는 거의 무조건 다익스트라(일종의 그리디 알고리즘)
    # 하지만 음수가 들어가는 경우는 벨먼포드
    queue = [(1, 0)]  # 1번 마을에서 시작, 튜플로 선언 : 비용 0

    # 도달할 노드의 이름을 최댓값으로 초기화한다.
    dist = [float('inf')] * (N+1)  # 계산하기 편하게 N +1
    dist[1] = 0

    while queue:
        current, current_cost = heappop(queue)  # 현재 선택된 마을(노드)과 비용
        for src, dest, cost in road:  # 출발지, 목적지, 비용
            next_cost = cost + current_cost
            if src == current and next_cost < dist[dest]:
                dist[dest] = next_cost  # 더 작은 값으로 갱신
                heappush(queue, (dest, next_cost))  # heap에 목적지와 비용을 넣는다.
            # 양방향이므로 목적지에서 출발지로 갈 수도 있다.
            elif dest == current and next_cost < dist[src]:
                dist[src] = next_cost
                heappush(queue, (src, next_cost))

    return dist
