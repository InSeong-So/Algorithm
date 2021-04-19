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

### 암시적(implicit) 매개변수를 명시적(explicit) 매개 변수로 변환한다.
- 순차 탐색
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
        elif taret == data[start]:
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

- 최댓값 찾기
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

<br>
<hr>
<br>

## Recursion 응용
### 미로 찾기
> 현재 위치에서 출구까지 가는 경로 찾기
1. 현재 위치가 출구여야 한다.
2. 1이 아니라면 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있어야 한다.

<br>

- 첫 번째 설계 : 방문한 장소를 재방문하여 무한 루프에 빠질 수 있음
    ```py
    boolean findPath(x, y)
        # 현재 위치가 출구라면 True
        if(x, y) is the exit
            return True
        else
            # 이웃한 셀을 검사
            for each neighbouring cell (x', y') of (x, y) do
                ## 이웃한 셀이 통로라면 검사, 아니라면 False
                if(x', y') is on then pathway
                    if findPath(x', y')
                        return True
            return False
    ```

<br>

- 두 번째 설계 : 검사한 위치를 저장하여 무한 루프를 방지
    ```py
    boolean findPath(x, y)
        # 현재 위치가 출구라면 True
        if(x, y) is the exit
            return True
        else
            # 검사한 위치를 마크(저장)
            mark(x, y) as a visited cell
            # 이웃한 셀을 검사
            for each neighbouring cell (x', y') of (x, y) do
                ## 이웃한 셀이 통로이고 방문하지 않았다면 검사, 아니라면 False
                if(x', y') is on then pathway and not visited
                    if findPath(x', y')
                        return True
            return False
    ```

<br>

- 세 번째 설계 : 함수는 더 많이 호출하나 코드는 간결해짐
    ```py
    boolean findPath(x, y)
        ## 이웃한 셀이 통로이고 방문하지 않았다면 검사, 아니라면 False
        if(x, y) is either on the wall or a visited cell
            return False
        # 현재 위치가 출구라면 True
        else if(x, y) is the exit
            return True
        else
            # 검사한 위치를 마크(저장)
            mark(x, y) as a visited cell
            # 이웃한 셀을 검사
            for each neighbouring cell (x', y') of (x, y) do
                if findPath(x', y')
                    return True
            return False
    ```

<br>

- 문제 해결
    ```py
    # 미로의 크기
    N = 8
    # 통로
    PATHWAY_VALUE = 0
    # 벽
    WALL_VALUE = 1
    # 방문(검사)했으며 출구까지의 경로에 있지 않다고 판별된 CELL
    BLOCKED_VALUE = 2
    # 방문(검사)했으며 아직 출구로 가는 경로가 될 가능성이 있는 CELL
    PATH_VALUE = 3

    maze = [
        [0, 0, 0, 0, 0, 0, 0, 1],
        [0, 1, 1, 0, 1, 1, 0, 1],
        [0, 0, 0, 1, 0, 0, 0, 1],
        [0, 1, 0, 0, 1, 1, 0, 0],
        [0, 1, 1, 1, 0, 0, 1, 1],
        [0, 1, 0, 0, 0, 1, 0, 1],
        [0, 0, 0, 1, 0, 0, 0, 1],
        [0, 1, 1, 1, 0, 1, 0, 0],
    ]
    
    def findMazePath(x, y):
        # x-1, y-1 등 검사하므로 x, y의 음수 여부를 체크하는 로직이 필요
        if x < 0 or y < 0 or x >= N or y>= N:
            return False
        elif maze[x][y] != PATHWAY_VALUE:
            return False
        elif x == N - 1 and y == N - 1:
            maze[x][y] = PATH_VALUE
            return True
        else:
            maze[x][y] = PATH_VALUE
            if findMazePath(x - 1, y) or findMazePath(x, y + 1) or findMazePath(x + 1, y) or findMazePath(x, y - 1):
                return True
            maze[x][y] = BLOCKED_VALUE
            return False


    print(maze)
    # 첫 번째 좌표 호출로 시작
    findMazePath(0, 0)
    print(maze)
    ```

<br>

- 결과

<div align=center>

<img src="./img/01.JPG" width="400">

</div>

<br>

### Counting Cells in a Blob
- 문제 정의
<div align=center>

<h4>[5, 1, 5, 13] 사이즈의 4개 Blob</h4>

<img src="./img/02.JPG" width="400">

<p>Binary 이미지이며, 서로 연결된 픽셀의 집합을 Blob이라 부른다.</p>
    <p>상하좌우 및 대각선도 연결된 것으로 간주한다.</p>

</div>

<br>

- 사고하기 1 : 현재 픽셀(x, y)이 속한 Blob의 크기를 카운트하기 위해서는?
    1. 현재 픽셀이 image color가 아니라면 0을 반환한다.
    2. 현재 픽셀이 image color라면 먼저 현재 픽셀을 카운트한다(count=1).
    3. 현재 픽셀이 중복 카운트 되는 것을 방지하기 위해서 다른 색으로 칠한다.
    4. 현재 픽셀에 이웃한 모든 픽셀들에 대해 그 픽셀이 속한 Blob의 크기를 카운트하여 기존 카운트에 더한다.
    5. 카운트를 반환한다.

<br>

- 사고하기 2 : 따라가기
    1. `x = 5, y = 3`이라 가정하고 해당 픽셀이 포함된 Blob의 크기를 계산해보자.
    2. `count`는 `0`으로 `초기화`한다.
    3. 현재 cell을 `중복 카운트되는 것을 방지하기 위해 다른 색`으로 칠하고 `count를 1 증가`한다.
    4. 인접한 8개의 픽셀 각각에 대해 순서대로 그 픽셀이 포함된 Blob의 크기를 count한다. `시계 방향(북, 북동, 동...)`으로 고려한다.
    5. 북쪽 픽셀이 포함된 Blob의 크기는 0이므로 count 값은 변하지 않는다.
    6. 북동쪽 픽셀이 속한 Blob을 count하고, count 된 픽셀들을 색칠한다.
    7. 3개의 픽셀이 Blob에 속한다. 즉 count는 `1 + 3 = 4`이다.
    8. 동쪽과 남동쪽 픽셀이 포함된 Blob의 크기는 0이므로 count 값은 변하지 않는다.
    9. 남쪽 픽셀이 속한 Blob을 count하고, count 된 픽셀들을 색칠한다.
    10. 9개의 픽셀이 Blob에 속한다. 즉 count는 `4 + 9 = 13`이다.
    11. 남서, 서, 북서 방향의 픽셀이 속한 Blob은 없거나 혹은 이미 count 되었다.
    12. 최종적으로 x = 5, y = 3의 픽셀이 가진 Blob의 크기는 13이다.

<br>

- 사고하기 3 : pseudo code 작성하기
    ```py
    Algorithm for countCells(x, y)
        if the pixel(x, y) is outside the grid
            the result is 0
        else if pixel(x, y) is not an image pixel or already counted
            the result is 0
        else
            # 이미 카운트 되었음을 표시한다.
            set the color of the pixel(x, y) to a red color
            the result is 1 plus the number of cells in each piece of
                the blob that includes a nearest neighbour
    ```

<br>

- 문제 해결
    ```py
    # 주어진 그리드의 크기
    N = 8
    # Blob이 아닌 픽셀
    BACKGROUND_COLOR = 0
    # Blob인 픽셀
    IMAGE_COLOR = 1
    # 이미 횟수를 센 픽셀
    ALREADY_COUNTED = 2

    grid = [
        [1, 0, 0, 0, 0, 0, 0, 1],
        [0, 1, 1, 0, 0, 1, 0, 0],
        [1, 1, 0, 0, 1, 0, 1, 0],
        [0, 0, 0, 0, 0, 1, 0, 0],
        [0, 1, 0, 1, 0, 1, 0, 0],
        [0, 1, 0, 1, 0, 1, 0, 0],
        [1, 0, 0, 0, 1, 0, 0, 1],
        [0, 1, 1, 0, 0, 1, 1, 1],
    ]

    def countCells(x, y):
        if x < 0 or x >= N or y < 0 or y >= N:
            return 0
        elif grid[x][y] != IMAGE_COLOR:
            return 0
        else:
            grid[x][y] = ALREADY_COUNTED
            return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1)
                     + countCells(x + 1, y + 1) + countCells(x - 1, y)
                     + countCells(x + 1, y) + countCells(x - 1, y - 1)
                     + countCells(x, y - 1) + countCells(x + 1, y - 1)
    ```