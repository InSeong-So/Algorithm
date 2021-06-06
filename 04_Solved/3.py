from heapq import heapify, heappop, heappush, heapreplace


# 3 배상 비용 최소화
def solution(n, works):
    # 가지 치기
    if n >= sum(works):
        return 0

    for _ in range(n):
        works = sorted(works)  # Tim sort < 어느정도 정렬이 되어 있다면 속도가 빠르다.
        works[-1] -= 1

    return sum(work ** 2 for work in works)


# heap 이용하기
def solution(n, works):
    # 가지 치기
    if n >= sum(works):
        return 0

    # 파이썬은 max heap을 지원하지 않는다.
    works = [-i for i in works]  # max heap처럼 동작한다.
    heapify(works)  # [1, 2, 3]을 [-3, -2, -1]로 변경

    for _ in range(n):
        # heappush(works, heappop(works) + 1)
        heapreplace(works, works[0] + 1)  # pop과 push를 동시에 할 수 있는 효과, O(log n)

    return sum(work ** 2 for work in works)
