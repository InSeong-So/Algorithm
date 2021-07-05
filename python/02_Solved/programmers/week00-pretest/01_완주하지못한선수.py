# 원소의 수를 세어 주는 라이브러리
from collections import Counter # O(n)

# 단순 반복으로 풀기 : 효율성 테스트 통과 X
def solution(participant, completion):
    # O(n^2)
    for i in completion:  # O(n)
        participant.remove(i)  # O(n)
    return str(participant[0])

# 정렬을 사용하여 풀기 : 효율성 테스트 통과 O
def solution(participant, completion):
    participant.sort()  # 정렬은 시간복잡도가 O(n log n)이다.
    completion.sort()

    # Zip: 원소를 하나로 묶는 함수
    for p, c in zip(participant, completion):  # O(n)
        if p != c:  # 만약 다른게 나온다면 그게 완주하지 못한 사람임
            return p

    return participant[-1]  # 마지막까지 간다면 그게 완주하지 못한 사람임

# 파이썬의 built-in 함수를 이용해서 풀기 : 효율성 테스트 통과 O
def solution(participant, completion):
    result = Counter(participant) - Counter(completion)
    return list(result.keys())[0]

# 더 간략하게 줄이기
def solution(participant, completion):
    return [i for i in (Counter(participant) - Counter(completion)).keys()][0]
