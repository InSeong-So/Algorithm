# Recursion
> 자기 자신을 호출하는 함수 / 순환함수
```py
def solution():
    # ...
    solution()
```

<br>
<hr>
<br>

## Recursion 조건
1. 적어도 하나의 종료 조건이 존재해야 한다.
2. 재귀를 반복하면 최종적으로 하나의 종료 조건에 도달해야 한다.

<br>
<hr>
<br>

## Recursion 대표 예제
### n까지 더하기
```py
# 0 ~ n 까지의 합을 구하기
def recursionSum(n):
    # 종료조건 : n이 0이라면 0을 반환한다.
    if n == 0:
        return 0
    # n이 0보다 크다면 현재의 n값에 재귀함수(n - 1)을 더한다.
    else:
        return n + recursionSum(n - 1)

# 검증
print(recursionSum(4))
```

<br>

### Factorial : n!
```py
# 1 ~ n까지의 곱 구하기
def factorial(n):
    # 종료조건 : n이 0이라면 1을 반환한다.
    if n == 0:
        return 1
    # n이 0보다 크다면 현재의 n값에 재귀함수(n - 1)을 곱한다.
    else:
        return n * factorial(n - 1)
        
# 검증
print(factorial(4))
```

<br>

### n의 x제곱 구하기
```py
# n의 x제곱 구하기
def power(n, x):
    # 종료조건 : n이 0이라면 1을 반환한다.
    if n == 0:
        return 1
    # n이 0보다 크다면 제수 x값에 재귀함수(n - 1, x)을 곱한다.
    else:
        return x * power(n - 1, x)

# 검증
print(power(4, 3))
```

<br>

### Fibonacci Number
```py
# 피보나치 수 구하기
def fibonacci(n):
    # 종료조건 : n - 2가 0보다 작아질 경우 2를 반환한다.
    if n < 2:
        return n
    # n - 2가 0보다 크다면 각각 재귀함수를 호출하여 더한다.
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

# 검증
print(fibonacci(4))
```

<br>

### 최대공약수 : Euclid Method
```py
# m >= n인 두 양의 정수 m과 n에 대해 m이 n의 배수이면 euclid(m, n) = n이다.
# 그렇지 않다면 euclid(m, n) = euclid(n, m % n)이다.
def euclid(m, n):
    # m 이 n 보다 크다면 임시 변수를 통해 값을 치환한다.
    if m < n:
        t = m
        m = n
        n = t
    
    # m과 n을 나눈 뒤 나머지가 0이라면 최대 공약수이다.
    if m % n == 0:
        return n
    # 위에서 값을 치환했으므로 변수를 계산한 뒤 재귀함수를 호출한다.
    else:
        return euclid(n, m % n)

# 검증
print(euclid(180, 8))
```
```py
# 단순한 버전
def euclid2(m, n):
    if n == 0:
        return m
    else:
        return euclid2(n, m % n)

# 검증
print(euclid2(180, 8))
```

<br>
<hr>
<br>

## Recursion 사고
> Recursion은 수학 함수 계산 뿐만 아니라 많은 문제들을 해결할 수 있다.

- 문자열의 길이를 계산하기
    ```py
    '''
    if the string is empty
        return 0
    else
        return 1 plus the length of ther string that 
        excludes the first character
    '''
    def legnth(str):
        if str == "":
            return 0
        else:
            return 1 + length(str[1:])
    ```

- 문자열 출력
    ```py
    def printChars(str):
        if len(str) == 0:
            return
        else:
            print(str[:1], end="")  # 아래와 비교 1
            printChars(str[1:]) # 아래와 비교 2
    ```

- 문자열을 뒤집어 프린트
    ```py
    def printCharReverse(str):
        if len(str) == 0:
            return
        else:
            printCharReverse(str[1:])
            print(str[:1], end="")
    ```

- 2진수로 변환하여 출력하기 : 음이 아닌 정수 n을 이진수로 변환하여 출력
    ```py
    def printInBinary(n):
        if n < 2:
            print(n, end="")
        else:
            # n을 2로 나눈 몫을 먼저 2진수로 변환하여 인쇄
            printInBinary(n // 2)
            # n을 2로 나눈 나머지를 인쇄
            print(n % 2, end="")
    ```

- 배열의 합 구하기
    ```py
    def sum(n, array):
        if n <= 0:
            return 0
        else:
            return sum(n - 1, array) + array[n-1]
    ```

<br>
<hr>
<br>

## Recursion vs. Iteration
- 모든 순환 함수는 반복문(iteration)으로 변경할 수 있다.
    - 물론 이 역도 성립한다. 즉, 모든 반복문은 recuresion으로 표현이 가능하다.
- 순환 함수는 복잡한 알고리즘을 단순하고 알기 쉽게 표현한다.
    - 단, 함수 호출에 따른 오버헤드가 존재한다(매개변수 전달, 액티베이션 프레임 생성 등).

<br>
<hr>
<br>

## Recursion 설계
> 최소 하나의 base case(순환되지 않고 종료되는 case)가 존재해야 한다.
> - 모든 case는 결국 base case로 수렴해야 한다.

<br>

1. 암시적(implicit) 매개변수를 명시적(explicit) 매개 변수로 변환한다.
    - 예 : 순차 탐색
        ```py
        # 변경 전
        def search(data, n, target):
            for i in range(n):
                if data[i] == target:
                    return i
            return -1
        ```
        - 해당 함수는 data[0]에서 data[n-1] 사이의 target을 검색한다.
        - 검색 구간의 시작 인덱스 0은 보통 생략되므로 암시적인 매개변수이다.

        <br>
        
        ```py
        # 변경 후
        def search(data, start, end, target):
            if start > end:
                return -1
            else if taret == data[start]:
                return start
            else:
                return search(data, start + 1, end, target)
        ```
        - 해당 함수는 data[start]에서 data[end] 사이의 target을 검색한다.
        - 검색 구간의 시작점을 명시적으로 지정한다.
        - `search(data, 0, len(data) - 1, target)`으로 호출하면 변경 전의 함수와 동일하게 작동한다.

        <br>

        ```py
        # 다른 버전 : binary search와는 다름
        def search(data, start, end, target):
            if start > end:
                return -1
            else:
                middle = (start + end) // 2
                if data[middle] == target:
                    return middle
                index = search(data, start, middle - 1, target)
                if index != -1:
                    return index
                else:
                    return search(data, middle + 1, end, target)
        ```
    
    <br>

    - 예 : 최댓값 찾기
        ```py
        def findMax(data, start, end):
            if start == end:
                return data[start]
            else:
                return max(data[start], findMax(data, start + 1, end))
        ```
        - 해당 함수는 data[start]에서 data[end] 사이의 최댓값을 찾아 반환한다.
            - `start <= end`라고 가정한다.

        <br>

        ```py
        # 다른 버전
        def findMax(data, start, end):
            if start == end:
                return data[start]
            else:
                middle = (start + end) // 2
                max1 = findMax(data, start, middle)
                max2 = findMax(data, middle + 1, end)
                return max(max1, max2)
        ```