# 알고리즘 스터디 커리큘럼

# 목표
> 기초 알고리즘을 이해하고 작성할 수 있다.

# 1주차
> 알고리즘의 이해

## 알고리즘의 분석
- 알고리즘의 실행 시간 및 기타 자원의 사용량을 분석

- 기타 자원으로 메모리, 저장장치, 통신 등

- 주로 실행 시간의 분석에 집중하는 이유는?

## 시간복잡도
- 실행시간은 실행환경에 따라 달라짐
  - 하드웨어, 운영체제, 언어, 컴파일러 등

- 실행 시간을 측정하는 대신 “연산의 실행 횟수를 카운트”

- 연산의 실행 횟수는 입력 데이터의 크기에 관한 함수로 표현

- 데이터의 크기가 같더라도 실제 데이터에 따라서 달라짐
  - 최악의 경우 시간복잡도 (worst case)
  - 평균 시간복잡도 (average case)

## 점근적 분석
- 점근적 표기법을 사용
  - 데이터의 개수 n→∞일때 수행시간이 증가하는 growth rate로 시간복잡도를 표현하는 기법
  - Θ-표기, Ο-표기 등을 사용

- 유일한 분석법도 아니고 가장 좋은 분석법도 아님
  - 다만 (상대적으로) 가장 간단하며 알고리즘의 실행환경에 비의존적임
  - 그래서 가장 광범위하게 사용됨

## 점근적 분석의 예: 선형 시간복잡도
- 선형 시간복잡도를 가진다고 말하고 O(n)이라고 표기한다.
    ```java
    int sum(int[] A) {
        int n = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++){
            result += A[i];
            n+=1;
        }
        return result;
    }
    ```
    ```
    가장 자주 실행되는 문장 중 하나이며 실행 횟수는 항상 n번이다.
    가장 자주 실행되는 문장이 n번이라면 모든 문장의 실행 횟수의 합은
    n에 선형적으로 비례하며, 모든 연산들의 실행횟수의 합도 역시 n에 선형적으로 비례한다.
    ```

    <br>

    ```java
    int search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target)
                return i;
        }
        return -1;
    }
    ```
    ```
    가장 자주 실행되는 문장 중 하나이며, 실행 횟수는 최악의 경우 n번이다.
    최악의 경우 시간복잡도는 O(n)이다.
    ```

    <br>

    ```java
    boolean isDistinct(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; i + 1 < A.length; j++) {
                if (A[i] == A[j])
                    return false;
            }
        }
        return true;
    }
    ```
    ```
    최악의 경우 배열에 저장된 모든 원소 쌍들을 비교하므로 비교 연산의 횟수는 n(n-1)/2이다.
    따라서 시간복잡도는 O(n2)이다
    ```

    <br>

    ```java
    int binarySearch(int n, int[] data, int target) {
        int begin = 0;
        int end = n - 1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (data[middle] == target)
                return middle;
            else if (data[middle] < target)
                begin = middle + 1;
            else
                end = middle - 1;
        }
        return - 1;
    }
    ```
    ```
    위 알고리즘의 시간복잡도는?
    ```

# 2주차
> 기본 자료구조의 종류와 개념

# 3주차
> 

# 4주차
> 