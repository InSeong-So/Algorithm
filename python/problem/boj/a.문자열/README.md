# 문자열

### 11654번 문제 [아스키 코드](https://www.acmicpc.net/problem/11654)
> 아스키 코드에 대해 알아보는 문제

ord() 함수를 사용하면 해당 문자의 아스키코드를 가져올 수 있고, chr() 함수를 사용하면 해당 아스키코드를 문자로 변경할 수 있다.

<br>

### 11720번 문제 [숫자의 합](https://www.acmicpc.net/problem/11720)
> 정수를 문자열로 입력받는 문제. Python처럼 정수 크기에 제한이 없다면 상관 없으나, 예제 3은 일반적인 정수 자료형에 담기에 너무 크다는 점에 주목한다.

문자열은 배열 기능을 지원하므로 loop를 돌면서 원소를 int()로 정수형 치환 후 누적합을 반환한다.

<br>

### 10809번 문제 [알파벳 찾기](https://www.acmicpc.net/problem/10809)
> 한 단어에서 각 알파벳이 처음 등장하는 위치를 찾는 문제

전체 알파벳을 loop 돌면서 계산한다. string 라이브러리와 find() 함수를 이용하여 해결한다.

```py
import string
# 소문자 abcdefghijklmnopqrstuvwxyz
string.ascii_lowercase
# 대문자 ABCDEFGHIJKLMNOPQRSTUVWXYZ 
string.ascii_uppercase
# 대소문자 모두 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
string.ascii_letters
# 숫자 0123456789
string.digits
```

<br>

### 2675번 문제 [문자열 반복](https://www.acmicpc.net/problem/2675)
> 각 문자를 반복하여 출력하는 문제

파이썬의 문자열은 곱연산과 덧셈연산이 가능하다.

<br>

### 1157번 문제 [단어 공부](https://www.acmicpc.net/problem/1157)
> 주어진 단어에서 가장 많이 사용된 알파벳을 출력하는 문제

아스키코드 변환과 배열을 활용하자.

<br>

### 1152번 문제 [단어의 개수](https://www.acmicpc.net/problem/1152)
> 단어의 개수를 구하는 문제

단어라는 것은 공백으로 구분된 문자열이다.

<br>

### 2908번 문제 [상수](https://www.acmicpc.net/problem/2908)
> 숫자를 뒤집어서 비교하는 문제

문자열 뒤집기. reversed와 삼항 연산식을 사용해보자
<br>

### 5622번 문제 [다이얼](https://www.acmicpc.net/problem/5622)
> 규칙에 따라 문자에 대응하는 수를 출력하는 문제

아스키코드로 변환한 수를 DP로 풀어보자. 단, 주어진 조건을 잘 확인해야 한다. 다중 if문을 활용하지 않는다.

<br>

### 2941번 문제 [크로아티아 알파벳](https://www.acmicpc.net/problem/2941)
> 크로아티아 알파벳의 개수를 세는 문제

문자열을 치환한다.

<br>

### 1316번 문제 [그룹 단어 체커](https://www.acmicpc.net/problem/1316)
> 조건에 맞는 문자열을 찾는 문제

검사할 배열을 만들어두고 주어진 단어를 순회하며 글자가 배열에 있는지 확인한다.