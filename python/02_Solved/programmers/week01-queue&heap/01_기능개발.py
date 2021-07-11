# 1 : 기능개발
# O(n^2) : 효율성 테스트가 없어서 그냥 해도 됨
from math import ceil
from collections import deque
# pop(0)


def solution1(progresses, speeds):
    answer = []

    while progresses:
        for index in range(len(progresses)):
            progresses[index] += speeds[index]

        if progresses[0] >= 100:
            count = 0
            while progresses and progresses[0] >= 100:
                progresses.pop(0)  # pop(0) <- O(n)
                speeds.pop(0)
                count += 1
            answer.append(count)

    return answer


# 위의 경우보다 조금 개선
def solution2(progresses, speeds):
    answer = []

    progresses = deque(progresses)
    speeds = deque(speeds)

    while progresses:
        for index in range(len(progresses)):
            progresses[index] += speeds[index]

        if progresses[0] >= 100:
            count = 0
            while progresses and progresses[0] >= 100:
                progresses.popleft()  # popleft() <- O(1)
                speeds.popleft()
                count += 1
            answer.append(count)

    return answer


# O(n)
def solution3(progresses, speeds):
    answer = []
    # durations = []
    # for p, s in zip(progresses, speeds):
    #     durations.append(ceil((100 - p) / s))

    # 위 코드를 list comprehension 통해 아래로 만듦
    # durations = [ceil((100 - p) / s) for p, s in zip(progresses, speeds)]
    max_duration = ceil((100 - progresses[0]) / speeds[0])
    count = 0
    for progress, speed in zip(progresses, speeds):
        duration = ceil((100-progress) / speed)
        if max_duration < duration:
            answer.append(count)
            count = 0
            max_duration = duration
        count += 1

    if count > 0:
        answer.append(count)

    return answer


progresses = [93, 30, 55]
speeds = [1, 30, 5]
result = [2, 1]
# [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

solution3(progresses, speeds)