# 동적계획법 1

### 1003번 문제 [피보나치 함수](https://www.acmicpc.net/problem/1003)
> 단순 재귀에서 DP를 적용하는 기본 문제 1

피보나치 수에 적용되는 규칙은? 메모이제이션(Memoization)을 활용해보자.

<br>

### 9184번 문제 [신나는 함수 실행](https://www.acmicpc.net/problem/9184)
> 단순 재귀에서 DP를 적용하는 기본 문제 1

1003번의 응용이다.

<br>

### 1904번 문제 [01타일](https://www.acmicpc.net/problem/1904)
> 점화식의 값을 특정 상수로 나눈 나머지를 구하는 문제

1003번의 응용이다.

<br>

### 9461번 문제 [파도반 수열](https://www.acmicpc.net/problem/9461)
> 피보나치 수와 비슷한 규칙을 찾아 동적 계획법으로 푸는 문제

1003번의 응용이다.

<br>

### 1149번 문제 [RGB거리](https://www.acmicpc.net/problem/1149)
> i번째 집을 각각의 색으로 칠할 때, 1~i번째 집을 모두 칠하는 최소 비용으로 부분문제를 정의하는 문제

1003번의 응용이다.

<br>

### 1932번 문제 [정수 삼각형](https://www.acmicpc.net/problem/1932)
> 각 층의 모든 칸마다 최댓값을 저장하면서 동적 계획법으로 푸는 문제

1003번의 응용이다.

<br>

### 2579번 문제 [계단 오르기](https://www.acmicpc.net/problem/2579)
> i번째 계단에 오를 때, 몇 개의 연속한 계단을 올랐는지를 고려하여 부분문제를 정의하는 문제

완전탐색을 이용하여 풀 수도 있지만, 마지막 계단을 반드시 밟는다는 조건에 유의하여 점화식을 세운다. 배낭(Knapsack) 알고리즘을 적용하면 쉽게 풀 수 있다.

<br>

### 1463번 문제 [1로 만들기](https://www.acmicpc.net/problem/1463)
> 메모이제이션으로 N을 1로 바꾸기 위해 주어진 연산을 몇 번 사용하는지 계산하는 문제

2579번 계단 오르기와 동일하다.

<br>

### 10844번 문제 [쉬운 계단 수](https://www.acmicpc.net/problem/10844)
> 동적 계획법을 이용해 계단 수를 구하는 문제

0, 1, 2자릿수를 기준으로 인접한 모든 자릿수가 1인 경우는 몇 개인지 도출하고 각 수들의 특징을 살펴보고 점화식을 세우자.

<br>

### 2156번 문제 [포도주 시식](https://www.acmicpc.net/problem/2156)
> 규칙에 따라 포도주를 마실 때, 최대로 마실 수 있는 포도주의 양을 구하는 문제

배낭(Knapsack) 알고리즘을 적용하나, 주어진 조건이 연속으로 3잔을 못 마심에 유의하여 점화식을 세우자.

<br>

### 11053번 문제 [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
> LIS(Longest Increasing Subsequence)를 구하는 문제

LIS(Longest Increasing Subsequence)를 적용해보자.

<br>

### 11054번 문제 [가장 긴 바이토닉 부분 수열](https://www.acmicpc.net/problem/11054)
> LIS 응용 문제 1

11053의 응용이다.

<br>

### 2565번 문제 [전깃줄](https://www.acmicpc.net/problem/2565)
> LIS 응용 문제 2

11053의 응용이다. 왜 LIS의 응용이 되는지 분석하고 점화식을 세우자.

<br>

### 9251번 문제 [LCS](https://www.acmicpc.net/problem/9251)
> LCS(Longest Common Subsequence)를 구하는 문제

LCS(Longest Common Subsequence)을 적용해보자.

<br>

### 1912번 문제 [연속합](https://www.acmicpc.net/problem/1912)
> 가장 큰 연속합을 구하는 문제

연속적인 합은 메모이제이션(Memoization), 배낭(Knapsack) 알고리즘, 구현(Implementation) 등 다양한 방법을 활용할 수 있다.

<br>

### 12865번 문제 [평범한 배낭](https://www.acmicpc.net/problem/12865)
> 대표적인 DP 문제 중 하나인 "냅색 문제"

배낭(Knapsack) 알고리즘이나, 연속적이지 않은 가방도 선택 가능하므로 이를 어떻게 풀어 나갈지 생각해보자.

<br>