# 2 : 더 맵게
from heapq import heapify, heappush, heappop


def solution(scoville, k):
    # 힙 정렬을 해주는 함수
    heapify(scoville)
    count = 0

    while scoville[0] < k:
        # heappop이 연속되므로 문제가 생길 수 있다.
        # heappush(scoville, heappop(scoville) + heappop(scoville) * 2)
        # count += 1

        # 위 코드를 변경
        food1 = heappop(scoville)
        if len(scoville) == 0:
            return -1
        food2 = heappop(scoville) * 2
        heappush(scoville, food1 + food2)
        count += 1

        # PEP 8에 의거 다시 변경
        # 하기 전에 검사하지 말고 일단 하고나서 허락받아라
        try:
            heappush(scoville, heappop(scoville) + heappop(scoville) * 2)
        # except IndexError:
        except:
            return -1
        count += 1

    return count
