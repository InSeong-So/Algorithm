from heapq import heapify, heapreplace


def solution(n, works):

    if n >= sum(works):
        return 0

    answer = 0
    works = [-i for i in works]
    heapify(works)

    for _ in range(n):
        heapreplace(works, works[0] + 1)

    return sum(work ** 2 for work in works)
