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