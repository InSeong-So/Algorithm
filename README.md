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

## Recursion 예제
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