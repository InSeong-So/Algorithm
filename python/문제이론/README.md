> 본 문서는 프로그래머스의 [파이썬을 파이썬답게](https://programmers.co.kr/learn/courses/4008) 강의를 보고 정리했습니다.

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