## Python for Alogrithms
> 사용 언어 : Python3


> 본 문서는 프로그래머스의 [파이썬을 파이썬답게](https://programmers.co.kr/learn/courses/4008) 강의와 파이썬 알고리즘 스터디로 정리했습니다.

# 파이썬답게 : 정수다루기
## 목과 나머지
```
7을 3으로 나눈 몫과 나머지를 구해야 하는 경우
```

- ~~non-Pythonic : 나머지와 몫을 따로 구하기~~
    ```py
    a = 7
    b = 5
    print(a//b, a%b)
    ```

- *Pythonic : `divmod`의 `unpacking`을 이용하여 구하기*
    ```py
    a = 7
    b = 5
    print(*divmod(a, b))
    ```

가독성이나 팀의 코드 스타일에 따라 `a//b, a%b`와 같이 쓰는 걸 권장한다.
또한 divmod는 **작은 숫자를 다룰 때는 `a//b, a%b` 보다 느리다.** 대신 큰 숫자를 다룰 때는 **전자가 후자보다 더 빠르다.**

## n진법으로 표기된 string을 10진법 숫자로 변환하기
```
5진법으로 적힌 문자열 '3212'를 10진법으로 바꾸기
```

- ~~non-Pythonic : for문으로 숫자를 곱하기~~
    ```py
    num = '3212'
    base = 5

    answer = 0
    for idx, number in enumerate(num[::-1]):
        answer += int(number) * (base ** idx)
    ```

- *Pythonic : `int(x, base=10)` 함수로 진법 변환하기*
    ```py
    num = '3212'
    base = 5
    answer = int(num, base)
    ```

# 파이썬답게 : Str 다루기
## string 모듈의 사용
```
a부터 z까지의 소문자를 가져오기
```

- ~~non-Pythonic : 직접 입력하기~~
    ```py
    answer = 'abcdefghijk (편의상 생략)'
    ```

- *Pythonic : `상수(constants)` 사용하기*
    ```py
    import string 

    string.ascii_lowercase # 소문자 abcdefghijklmnopqrstuvwxyz
    string.ascii_uppercase # 대문자 ABCDEFGHIJKLMNOPQRSTUVWXYZ
    string.ascii_letters # 대소문자 모두 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
    string.digits # 숫자 0123456789
    ```

# 파이썬답게 : Iterable 다루기
## 원본을 유지하면서 정렬된 리스트 구하기
`sort()` 함수를 사용하면 원본 리스트의 원소를 정렬한다.

```
원본의 순서는 변경하지 않고, 정렬된 값을 구하기
```

- ~~non-Pythonic : 사전 처리 후 정렬하기~~
    ```py
    list1 = [3, 2, 1]
    list2 = [i for i in list1] # 또는 copy.deepcopy를 사용
    list2.sort()
    ```

- *Pythonic : `함수 sorted()` 사용하기*
    ```py
    # 반복문이나 deepcopy 함수를 사용하지 않고 정렬된 리스트를 반환 받을 수 있다.
    list1 = [3, 2, 1]
    list2 = sorted(list1)
    ```

## 2차원 리스트 뒤집기
```
2차원 배열을 뒤집기
```

- ~~non-Pythonic :  2중 for 문을 이용해 리스트의 row와 column을 뒤집기~~
    ```py
    mylist = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    new_list = [[], [], []]

    for i in range(len(mylist)):
        for j in range(len(mylist[i])):
            new_list[i].append(mylist[j][i])
    ```

- *Pythonic : `zip() 함수와 unpacking` 사용하기*
    ```py
    mylist = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    new_list = list(map(list, zip(*mylist)))
    ```

zip(*iterables)는 각 iterables 의 요소들을 모으는 이터레이터를 만든다.
튜플의 이터레이터를 돌려주는데 i번째 튜플은 각 인자로 전달된 시퀀스나 이터러블의 i번째 요소를 포함한다.
- 예시 
    ```py
    # 기본적인 사용법
    mylist = [1, 2, 3]
    new_list = [40, 50, 60]
    for i in zip(mylist, new_list):
        print (i)

    >>>> (1, 40)
    >>>> (2, 50)
    >>>> (3, 60)
    ```

    ```py
    # 여러 개의 Iterable 동시에 순회할 때 사용하기
    list1 = [1, 2, 3, 4]
    list2 = [100, 120, 30, 300]
    list3 = [392, 2, 33, 1]
    answer = []
    for number1, number2, number3 in zip(list1, list2, list3):
    print(number1 + number2 + number3)
    ```

    ```py
    # Key 리스트와 Value 리스트로 딕셔너리 생성하기
    animals = ['cat', 'dog', 'lion']
    sounds = ['meow', 'woof', 'roar']
    answer = dict(zip(animals, sounds)) # {'cat': 'meow', 'dog': 'woof', 'lion': 'roar'}
    ```

## i번째 원소와 i+1번째 원소
```
i번째 원소와 i+1번째 원소 접근하기
```

- ~~non-Pythonic : len과 index를 이용하여 각 원소에 접근하기~~
    ```py
    def solution(mylist):
        answer = []
        for i in range(len(mylist)-1):
            answer.append(abs(mylist[i] - mylist[i+1]))
        return answer

    if __name__ == '__main__':
        mylist = [83, 48, 13, 4, 71, 11]    
        print(solution(mylist))
    ```

- *Pythonic : `zip()`을 이용하여 index를 사용하지 않고 각 원소에 접근하기*
    ```py
    def solution(mylist):
        answer = []
        for number1, number2 in zip(mylist, mylist[1:]):
            answer.append(abs(number1 - number2))
        return answer

    if __name__ == '__main__':
        mylist = [83, 48, 13, 4, 71, 11]    
        print(solution(mylist))
    ```

zip 함수에 서로 길이가 다른 리스트가 인자로 들어오는 경우에는 길이가 짧은 쪽 까지만 이터레이션이 이루어진다.

## 모든 멤버의 type 변환하기
```
문자열 배열 ['1', '100', '33']을 정수 배열 [1, 100, 33]로 바꾸기
부동소숫점 튜플 (3.14, 3.5, 22.6)을 정수 배열 (3, 3, 22)로 바꾸기
```

- ~~non-Pythonic : for 문을 이용해 원소의 타입을 하나씩 바꾸기~~
    ```py
    list1 = ['1', '100', '33']
    list2 = []
    for value in list1:
        list2.append(int(value))
    ```

- *Pythonic : `map()`을 사용하여 멤버의 타입을 일괄 변환하기*
    ```py
    list1 = ['1', '100', '33']
    list2 = list(map(int, list1))
    ```

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