# 첫 번째 세션, 오리엔테이션

- 매주 코딩테스트 ㅠㅡㅠ
- https://github.com/kciter

- 자료구조와 알고리즘이랑 무엇인가 : 전산화

- 항상 여러가지 풀이 방법이 있다
- 항상 예외가 있을 수 있다
- 내가 푼 답은 베스트가 맞는가?
- 문제를 풀면서 시행착오가 있었다면 기록할 것
- 다른 사람의 코드를 많이 볼 것

## 라이브 코딩

- 완주하지 못한 선수

  1. 단순 반복으로 푸는 방법
     ```python
     # 효율성 테스트 통과 X
     def solution(participant, completion):
       # O(n^2)
       for i in completion: # O(n)
           participant.remove(i) # O(n)
       return str(participant[0])
     ```
  2. 정렬을 사용하여 푸는 방법

     ```python
     # 효율성 테스트 통과 O
     def solution(participant, completion):
       participant.sort() # 정렬은 시간복잡도가 O(n log n)이다.
       completion.sort()

       # Zip: 원소를 하나로 묶는 함수
       for p, c in zip(participant, completion): # O(n)
         if p != c: # 만약 다른게 나온다면 그게 완주하지 못한 사람임
           return p
       return participant[-1] # 마지막까지 간다면 그게 완주하지 못한 사람임
     ```

  3. 파이썬의 built-in 함수를 이용해서 푸는 방법

     ```python
     # 원소의 수를 세어 주는 라이브러리
     from collections import Counter # O(n)

     # 효율성 테스트 통과 O
     def solution(participant, completion):
       result = Counter(participant) - Counter(completion)
       return list(result.keys())[0]
     ```

- 올바른 괄호

  1. Stack 개념을 이용하여 풀기

     ```python
     def solution(s):
       c = 0
       for x in s:
           if x == '(':
               c += 1
           else:
               c -= 1
            if c < 0:
                return False
       return True
     ```

- 스킬트리

  1. 큐

  ```python
  def solution(skill, skill_trees):
    answer = 0

    # O(skill_trees^2)
    for skill_tree in skill_trees: # O(skill_trees)
        skill_list = list(skill)

        # skill = "CBD"
        # skill_tree = "BACDE"
        # skill_list = ["C", "B", "D"]

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

        for s in skill_tree: # O(skill_trees)
          if s in skill and s != skill_list.pop(0): # O(skill_list)
            break
        else: # for-else 문법을 사용하면 dirty flag를 제거할 수 있다.
            answer += 1

    return answer
  ```

  2.  dequeue

  ```python
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

  return answer
  ```

  - for-else 문법은 for loop 중간에 break가 걸리지 않는 경우 else로 빠진다.
    - 만약 중간에 break가 걸린 경우 else를 실행시키지 않는다.

- 파이썬은 bigint 값을 자동으로 처리해서 편하다. 연산도 된다

# 두 번째 세션
