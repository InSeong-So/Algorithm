# Sort
> 데이터를 정렬하는 형태

<br>
<hr>
<br>

## Sort의 종류
- simple & slow
    - Bubble Sort
    - Insertion Sort
    - Selection Sort

<br>

- Fast
    - Quick Sort
    - Heap Sort

- O(N)
    - Radix Sort

<br>
<hr>
<br>

## Simple & Slow
### Selection Sort

<br>

<div align=center>

<img src="./img/09.jpg" width=500>

</div>

<br>

### Bubble Sort

<br>

<div align=center>

<img src="./img/10.jpg" width=500>

</div>

<br>

### Selection Sort

<br>

<div align=center>

<img src="./img/11.jpg" width=500>

<br>

<img src="./img/12.jpg" width=500>

</div>

<br>

## Divide & Conquer(분할정복)
### Merge Sort
> 개념
> - 분할 : 해결하고자 하는 문제를 작은 크기의 동일한 문제들로 분할
> - 정복 : 각각의 작은 문제를 순환적으로 해결
> - 합병 : 작은 문제의 해를 합하여 원래 문제에 대한 해를 구함

<br>

<div align=center>

<img src="./img/13.jpg" width=500>

<p>- 데이터가 저장된 배열을 절반으로 나눈다.</p>
<p>- 각각을 순환적으로 정렬한다.</p>
<p>- 정렬된 두 배열을 합쳐 전체를 정렬한다.</p>

</div>

<br>

### Quick Sort
> 개념
> - 분할 : 배열을 다음과 같은 조건이 만족되도록 두 부분으로 나눈다.
>> - elements in lower parts <= elements in upper parts
> - 정복 : 각각의 작은 문제를 순환적으로 해결
> - 합병 : -

<br>

### Heap Sort
- 최악의 경우 시간 복잡도는 O(nlogn)
- sorts in place로 추가 배열이 필요 없이 가지고 있는 메모리 내에서 정렬
- 이진 힙 자료구조를 사용한다.
- 조건이 필요한데, 완전 이진 트리(Complete Binary Tree)를 만족해야 한다.
    - 완전 이진 트리는 마지막 레벨을 제외한 모든 레벨이 가득 차 있고, 마지막 레벨은 오른쪽 노드부터 연속적으로 비어 있을 수 있다.
    - 동일한 데이터로 힙을 구성해도 모두가 동일한 힙은 아니다.
    - Max Heap, Min Heap 둘 중 하나를 충족해야 한다.
- 힙은 일차원 배열로 표현할 수 있다.
    ```js
    // 0번 인덱스는 편의상 비운다.
    A[1] = root
    
    // A[i]의 부모 노드
    A[i/2]

    // A[i]의 왼쪽 자식
    A[2i]

    // A[i]의 오른쪽 자식
    A[2i+1]
    ```
- 기본적으로 recursive한 특성을 지닌다.