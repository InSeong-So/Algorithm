# Pythonic : 다양한 Comprehension

Comprehension은 list, dictionary, set과 같은 iterable 객체를 생성할 수 있는 파이썬만의 독특한 sugar 문법으로, 잘 사용하면 깔끔한 코드를 작성할 수 있으며 성능상 이점도 가져올 수 있다.
- 성능상 이점이 있는 이유는 Function Call 비용을 크게 줄여서 그렇지만... 사실 큰 이점이 있는 유의미한 성능 차는 아니다.
- [참조](https://jeongukjae.github.io/posts/inspecting-list-comprehension/)

다음과 같이 대표적인 세 가지 Comprehension이 존재한다.
1. List Comprehension
2. Dictionary Comprehension
3. Set Comprehension
4. Generator Expression (생략)

## List Comprehension
> **list**를 만드는 문법

보통 `2의 배수가 담긴 리스트`를 for 반복문으로 초기화 및 선언하지만 파이썬은 List Comprehension을 이용해 간단히 만들 수 있다.

- non-Pythonic
    ```py
    lst = [0] * 10
    for i in range(1, 10):
        lst[i] = i * 2
    ```
- *Pythonic*
    ```py
    lst = [i * 2 for i in range(1, 10)]
    # [2, 4, 6, 8, 10, 12, 14, 16, 18]
    ```

List Comprehension은 초기화 및 선언 외에도 기존 리스트를 변형하거나 조건을 넣어 요소를 필터링하는 것이 가능하다.

```py
lst = [i for i in range(1, 10)]
odd = [i for i in range(1, 10) if i % 2 == 0] # 홀수만 들어간다.
square = [i ** 2 for i in lst] # 기존 리스트를 이용하여 제곱수가 들어간 리스트를 만들었다.
# [1, 2, 3, 4, 5, 6, 7, 8, 9]
# [2, 4, 6, 8]
# [1, 4, 9, 16, 25, 36, 49, 64, 81]
```

## Dictionary Comprehension
> **dictionary**를 만들 수 있는 문법

Dictionary Comprehension도 기존의 dictionary를 변경하거나 if를 이용해 필터링 할 수 있다.
```py
names = ['키보드', '마우스', '모니터']
prices = [150000, 90000, 450000]
products = {key: value for key, value in zip(names, prices)}
# {'키보드': 150000, '마우스': 90000, '모니터': 450000}
```

## Set Comprehension
> **set**을 만들 수 있는 문법

```py
lst = [1, 3, 5, 7, 9, 3, 5, 2, 6, 4, 1, 8, 2]
uniq = {i for i in lst} # 중복이 제거된다.
# set([1, 2, 3, 4, 5, 6, 7, 8, 9])
```

# Pythonic : defaultdict

> **Dictionary**를 만들며, 새롭게 키를 지정할 때 초기값을 제공

- ~~before~~
    ```py
    # 기존 dictionary는 초기값을 넣어줘야만 접근이 가능하다.
    d = dict()
    names = ['Lee', 'James', 'John', 'Smith', 'Lee', 'James']
    for name in names:
        if name in d: # 초기값이 없으면 에러가 발생하기 때문에 if로 체크
            d[name] += 1
        else:
            d[name] = 1
    ```

- *after*
    ```py
    # defaultdict를 사용하면 코드를 깔끔하게 만들 수 있다.
    from collections import defaultdict
    d = defaultdict(int) # 초기값을 int로 설정(여기서 0으로 초기화)
    names = ['Lee', 'James', 'John', 'Smith', 'Lee', 'James']
    for name in names:
        d[name] += 1
    ```

defaultdict은 int가 아닌 다른 타입도 초기화를 제공한다.

```py
from collections import defaultdict

list_dict = defaultdict(list)
list_dict['key'] += [1, 3, 5]
print(list_dict['key'])
# [1, 3, 5]

set_dict = defaultdict(set)
set_dict['key'].update((1, 3, 5, 3, 2, 8))
print(set_dict['key'])
# {1, 2, 3, 5, 8}
```

# Pythonic : 2차원 리스트 생성
- 생성 방법
    ```py
    # 리스트의 크기 및 원소를 지정하여 생성하는 문법
    lst = [0] * 5
    print(lst) # [0, 0, 0, 0, 0]
    ```
    ```py
    # 위와 동일한 방식으로 2차원 리스트를 생성
    lst = [[0] * 5 for __ in range(5)]
    print(lst)
    # [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
    ```

- 사용하지 말아야 하는 생성 방법
    ```py
    lst = [[0] * 5] * 5
    print(lst)
    # [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]

    # 첫 번째 원소를 변경... 했는데 전체가 바뀐다?
    lst[0][0] = 1
    print(lst)
    # [[1, 0, 0, 0, 0], [1, 0, 0, 0, 0], [1, 0, 0, 0, 0], [1, 0, 0, 0, 0], [1, 0, 0, 0, 0]]
    ```

    - 위와 같이 첫 번째 요소를 변경했을 때 나머지 요소가 변경되는 이유는 1차원 리스트가 복제가 되어 같은 주소의 값을 참조하기 때문이다.

# Pythonic : 2차원 리스트를 1차원 리스트로 간단하게 변환하기
1. 반복문을 통해 새로 리스트를 생성하는 방법
2. built-in 모듈인 itertools를 이용하는 방법
3. **`sum` 함수를 이용하는 방법**

```py
nested_list = [[1, 2, 3], [4, 5, 6]]
flat_list = sum(nested_list, [])
# start 값을 비어있는 리스트로 설정, sum 함수가 빈 리스트에 요소를 더하면서 리스트가 합쳐진다.

print(flat_list)
# [1, 2, 3, 4, 5, 6]
```

# Pythonic : 쉽게 Swap 하기
- non-Pythonic : 자바스크립트 예제 코드
    ```js
    a = 3;
    b = 5;

    temp = a;
    a = b;
    b = temp;
    // a = 5, b = 3, temp = 3
    ```

- **Pythonic**
    ```py
    a = 3
    b = 5

    a, b = b, a
    # a = 5, b = 3
    ```

# Pythonic : itertools 모듈을 이용한 조합

itertools 모듈로 iteration(반복되는) 값을 쉽게 만들 수 있다.

## product 함수를 이용하여 곱집합(데카르트 곱) 구하기
> 다음과 같이 여러 집합에서 각 원소를 선택하여 만들 수 있는 모든 튜플을 모아놓은 집합
> - 즉, 모든 경우의 수

<div align=center>

<img src="./img/01.png" width=400>

</div>

```py
from itertools import product

p = product(['x', 'y', 'z'], [1, 2, 3])
print(list(p))
# [('x', 1), ('x', 2), ('x', 3), ('y', 1), ('y', 2), ('y', 3), ('z', 1), ('z', 2), ('z', 3)]
```

## combinations를 이용한 조합 구하기
> 조합 : 집합에서 **서로 다른 각 요소**를 선택하여 만들 수 있는 경우의 수
> - 5개 요소에서 전부 선택할 수도, 3개만 선택할 수도 있다.

- **combinations 함수로 Pythonic하게 구하기**
    ```py
    from itertools import combinations

    # 5개 요소 중 3개 선택
    c = combinations(['a', 'b', 'c', 'd', 'e'], 3)
    print(list(c))
    """
    [
        ('a', 'b', 'c'), ('a', 'b', 'd'), ('a', 'b', 'e'),
        ('a', 'c', 'd'), ('a', 'c', 'e'), ('a', 'd', 'e'),
        ('b', 'c', 'd'), ('b', 'c', 'e'), ('b', 'd', 'e'),
        ('c', 'd', 'e')
    ]
    """
    
    # 5개 요소 중 5개 선택
    c = combinations(['a', 'b', 'c', 'd', 'e'], 5)
    print(list(c))
    """
    [
        ('a', 'b', 'c', 'd', 'e')
    ]
    """
    ```

## permutation를 통해 순열 구하기
> 순열 : 집합에서 **각 요소를 뽑아 배치**할 수 있는 경우의 수라고 볼 수 있습니다.
>  - 조합과 다르게 순서가 중요하다. ABC의 순열을 구하면 ABC, ACB, BAC, BCA, CAB, CBA 6개가 가능

```py
from itertools import permutations

# 3개 요소 중 2개를 선택한 순열
p = permutations(['a', 'b', 'c'], 2)
print(list(p))
"""
[
    ('a', 'b'), ('a', 'c'),
    ('b', 'a'), ('b', 'c'),
    ('c', 'a'), ('c', 'b')
]
"""

# 3개 요소 중 3개를 선택한 순열
p = permutations(['a', 'b', 'c'])
print(list(p))
"""
[
    ('a', 'b', 'c'), ('a', 'c', 'b'),
    ('b', 'a', 'c'), ('b', 'c', 'a'),
    ('c', 'a', 'b'), ('c', 'b', 'a')
]
"""
```

# 퍼포먼스(시간 효율성) 측정 방법
- `process_time` : **실제 코드의 연산 시간**을 측정
    ```py
    import time

    # process_time은 time 모듈에 속해있으며 사용되는 시점의 시간을 반환한다.
    def solution(participant, completion):
        start = time.process_time() # 로직 시작
        participant.sort()
        completion.sort()
        for par, com in zip(participant, completion):
            if par != com:
                return par
        end = time.process_time() # 로직 종료
        print(end - start) # 걸린 시간 출력

        return participant[-1]
    ```
- `perf_counter` : 코드의 연산 시간 외에 sleep, file io 등 pending에 들어가는 시간까지 **모두 포함해서** 측정
    ```py
    import time

    # perf_counter은 time 모듈에 속해있으며 모든 시간을 연산하여 반환한다.
    def solution(participant, completion):
        start = time.perf_counter() # 로직 시작
        time.sleep(10)
        participant.sort()
        completion.sort()
        for par, com in zip(participant, completion):
            if par != com:
                return par
        end = time.perf_counter() # 로직 종료
        print(end - start) # 걸린 시간 출력

        return participant[-1]
    ```

# 문제 유형 파악하기
## 개요 : 문제를 읽기전에 무조건 입출력 제한을 보자

- 입출력 제한을 유심히 보면 어떤 시간복잡도 내에 풀어야 하는지 알 수 있다.
- 예를 들어 입력이 100 이하인 경우 높은 확률로 완전 탐색 문제이다.
  - 시간복잡도 O(n^3) 까지도 감당이 가능하기 때문에 플로이드 워셜과 같이 시간복잡도가 높은 알고리즘도 사용이 가능하다.

### 입력이 100 이하인 경우

- 완전 탐색
- 백트래킹

### 입력이 10,000 이하인 경우

- 최대 O(n^2) 이내로 끝내야하는 문제
- 문제에 따라 O(n^2 log n)까지는 허용
- n\*n 2차원 리스트를 모두 순회해야하는 문제가 많다.

### 입력이 1,000,000 이하인 경우

- 최대 O(n log n)으로 끝내야하는 문제
- 힙, 우선순위 큐
- 정렬
- 동적 계획법
- 위상 정렬
- 다익스트라 알고리즘

### 입력이 100,000,000 이하인 경우

- 최대 O(n)으로 끝내야하는 문제
- 동적 계획법
- 그리디

### 그 이상인 경우

- 최대 O(log n)으로 끝내야하는 문제가 많다.
- 거의 안나오는 문제 유형
- 이진탐색

## 유형 : 자주 출제되는 문제 유형
### 입력값이 작은 문제

위에서 언급했듯 높은 확률로 완전 탐색 혹은 백트래킹이므로 구현력이 중요한 문제일 가능성이 높다.

### 지도가 주어지고 채워진 영역을 찾아야하는 경우

높은 확률로 BFS, DFS이나 `FloodFill`과 같이 정직한 방식으로 나오거나 `전염병`, `치즈` 문제처럼 살짝 변형되서 나오는 경우가 있다.

### 그래프 그림이 있는 경우

이 경우 높은 확률로 세 가지 유형 중 하나이다.

1. 최단 거리 찾기 : 다익스트라, BFS, DFS 등을 사용할 수 있다.
   - `가장 빠른 길`, `최단 거리`와 비슷한 키워드가 나온다면 당연히 최단 거리 찾기 유형이다.
   - `X 비용 내로 갈 수 있는 길을 찾아라`와 같은 키워드도 최단 거리 찾기 유형이다.
2. 최소 신장 트리 : 크루스칼, 프림 알고리즘을 사용할 수 있다.
   - 보통 `가장 저렴한 방법으로 모든 경로 연결해라` 등의 키워드로 출제된다.
   - 경로가 아니라 통신망, 전송 시간, 회로, 배관 등 다양한 용어로 나올 수 있지만 핵심은 모든 경로를 `가장 싸게 연결해라`이다.
   - 그래프는 양방향일수도 단방향일수도 있다.
3. 위상 정렬
   - 순서를 정해야할 때 사용되며 보통 `순서`, `차례` 등의 키워드가 나오면 위상 정렬이다.

### X라는 조건을 만족하는 가장 최대/최소값을 찾아라

높은 확률로 결정 문제이다. 파라메트릭 서치를 이용해서 풀어보자.

### 실시간으로 정렬이 이루어져야 하는 경우

높은 확률로 우선순위 큐 혹은 힙을 사용하는 문제이다.

### Dynamic Programming(DP)

보통 완전 탐색처럼 시간이 오래 걸리면 안되지만 특별한 알고리즘을 사용하는 문제가 아닐 경우 높은 확률로 DP 문제이다.
다른 문제처럼 "딱 봐도 이거네!" 하는 특징이 없어서 유형을 판단하기 힘든 경우 DP로 풀 수 있는지 생각해보자.
종이를 꺼내어 다음과 같이 진행한다.

1. 문제를 따라 먼저 초기값을 적는다.
2. 초기값을 포함해 모든 상태값을 적는다.
3. 현재 상태를 통해 다음 값을 구할 수 있는지 판단한다.
4. 혹은 이전 상태들을 통해 현재 값을 구할 수 있는지 판단한다.

위와 같이 프로세스를 여러 번 진행한 뒤 특정 규칙을 규정하여 함수를 만들어 해결하자.

### 문자열이 주어지는 경우

구현력 문제인 경우가 많다. 문자열을 자르거나, 붙이거나, 탐색하는 문제가 대부분이다.
문자열을 탐색하는 알고리즘이 필요한 경우 KMP 알고리즘을 사용할 수 있지만 보통 파이썬과 같은 스크립트 언어에선 문자열 탐색이 built-in으로 존재하기 때문에 구현에만 집중하자.

### 현재 상황에서 가장 최적인 선택을 해야하는 경우

`항상 최적의 선택`을 해야하는 경우, 혹은 `가장 많은 선택`을 할 수 있는, `가장 작은/큰` 등의 키워드가 들어가면 그리디 문제일 가능성이 높다.
최소 신장 트리도 그리디의 일종이다.