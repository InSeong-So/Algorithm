# import sys
# from collections import deque

# rooms = []
# for _ in range(int(input())):
#     rooms.append(list(map(int, sys.stdin.readline().split())))
# # 종료시간을 기준으로 정렬
# rooms.sort(key=lambda x: (x[1], x[0]))

# count = 0
# queue = deque([])
# for room in rooms:
#     if len(queue) == 0:
#         queue.append(room)
#         count += 1
#         continue

#     if queue[-1][1] <= room[0]:
#         queue.popleft()
#         queue.append(room)
#         count += 1
# print(count)

# * ========================================================
# * @Title       : 1931
# * @Path        : python\02_Solved\boj\c.그리디알고리즘\1931.py
# * @Description :
# * @Date        : 2021-08-02 09:39:23
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분


def solution(rooms):
    from collections import deque
    rooms.sort(key=lambda x: (x[1], x[0]))
    print(rooms)
    count = 0
    queue = deque([])
    for room in rooms:
        if len(queue) == 0:
            queue.append(room)
            count += 1
            continue

        if queue[-1][1] <= room[0]:
            queue.popleft()
            queue.append(room)
            count += 1
    return count


def test_01():
    rooms = [
        [1, 4],
        [3, 5],
        [0, 6],
        [5, 7],
        [3, 8],
        [5, 9],
        [6, 10],
        [8, 11],
        [8, 12],
        [2, 13],
        [12, 14],
    ]
    assert solution(rooms) == 4


def test_02():
    rooms = [
        [1, 1],
    ]
    assert solution(rooms) == 1


def test_03():
    rooms = [
        [1, 4],
        [7, 7],
        [3, 5],
        [0, 6],
        [5, 7],
        [3, 8],
        [5, 9],
        [6, 10],
        [8, 11],
        [8, 12],
        [7, 7],
        [7, 7],
        [7, 7],
        [2, 13],
        [12, 14],
    ]
    assert solution(rooms) == 8


def test_04():
    rooms = [
        [1, 4],
        [3, 3]
    ]
    assert solution(rooms) == 1


def test_05():
    rooms = [
        [4, 4],
        [4, 4],
        [3, 4],
        [2, 4],
        [1, 4],
    ]
    assert solution(rooms) == 3


def test_06():
    rooms = [
        [1, 2],
        [2, 3],
        [2, 4],
        [3, 5],
    ]
    assert solution(rooms) == 3


def test_07():
    rooms = [
        [4, 5],
        [4, 4],
        [3, 4],
        [2, 5],
        [1, 3],
    ]
    assert solution(rooms) == 4
