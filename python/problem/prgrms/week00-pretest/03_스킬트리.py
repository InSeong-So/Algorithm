# queue를 이용하여 풀기
def solution(skill, skill_trees):
    answer = 0

    # O(skill_trees^2)
    for skill_tree in skill_trees:  # O(skill_trees)
        skill_list = list(skill)

        # skill = "CBD"
        # skill_tree = "BACDE"
        # skill_list = ["C", "B", "D"]S

        # 1
        # s = "B"
        # skill_list.pop(0) = "C"

        # 2
        # s = "B"
        # skill_list.pop(0) = "B"

        # 3
        # s = "A"

        # 4
        # s = "D"
        # skill_list.pop(0) = "D"

        # 5
        # s = "F"

        for s in skill_tree:  # O(skill_trees)
            if s in skill and s != skill_list.pop(0):  # O(skill_list)
                break
        else:  # for-else 문법을 사용하면 dirty flag를 제거할 수 있다.
            answer += 1

    return answer


# deque를 이용하여 풀기
from collections import deque

def solution(skill, skill_trees):
    answer = 0

    # O(skill_trees^2)
    for skill_tree in skill_trees: # O(skill_trees)
        skill_list = deque(skill)

        for s in skill_tree: # O(skill_trees)
            # O(skill)
            if s in skill and s != skill_list.popleft(0): # O(1)
                break
        else: # for-else 문법을 사용하면 dirty flag를 제거할 수 있다.
            answer += 1
        '''
        1. for-else 문법은 for loop 중간에 break가 걸리지 않는 경우 else로 빠진다.
            만약 중간에 break가 걸린 경우 else를 실행시키지 않는다.

        2. 파이썬은 bigint 값을 자동으로 처리해서 편하다. 연산도 된다
        '''

    return answer