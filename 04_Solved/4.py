# 4 : 게임 아이템
from heapq import heapify, heappop, heappush
from collections import deque


def solution(healths, items):
    healths.sort()  # 체력을 오름차순으로 정렬
    # list comprehension
    items = deque(sorted([(item[1], item[0], index + 1)
                          for index, item in enumerate(items)]))

    answer = []
    heap = []

    for health in healths:  # 제일 낮은 체력부터 루프 시작
        while items:  # 아이템 루프
            debuff, buff, index = items[0]  # 깎는 체력이 가장 낮은 아이템
            if health - debuff < 100:  # 조건이 안맞는다면 루프 종료
                break
            # items.pop(0)
            items.popleft()  # O(1)
            # max heap으로 아이템을 추가(buff 기준) O(log n)
            heappush(heap, (-buff, index))
        if heap:
            _, index = heappop(heap)
            answer.append(index)
    return sorted(answer)
