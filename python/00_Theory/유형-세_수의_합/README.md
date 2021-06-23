# 세 수의 합(★★)

배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라.
- 입력
    ```py
    nums = [-1, 0, 1, 2, -1, -4]
    ```

- 출력
    ```py
    [
        [-1, 0, 1],
        [-1, -1, 2]
    ]
    ```

<br>

## 풀이 1 : 부르트 포스로 계산
### A. 단순히 보았을 때, O(n^3) 정도면 풀이가 가능하다?
- 이 경우 타임아웃이 발생할 수 있으니, 시간 복잡도를 줄이는 방법을 생각해보자.
- 정렬! 파이썬의 팀소트는 정렬 속도가 매우 빠르다.
    ```py
    # 정렬(O(n log n))한다. 
    nums.sort()
    ```

### B. 풀이를 도식화해보자.
```py
"""
[-4, -1, -1, 0, 1, 2]
    i   j   k ------->
    i       j  k ---->
    i          j  k ->
"""
```
- i, j, k 포인터가 계속 이동하면서 `i + j + k = 0`을 찾아낸다.
    - 굳이 지칭하자면... 쓰리 포인터 풀이 정도?
- 해당 풀이는 중복된 값이 존재할 수 있으므로 continue 처리를 해준다.
    ```py
    if i > 0 and nums[i] == nums[i - 1]:
        continue
    ```

### C. 전체 코드를 작성해보자.
```py
def three_sum(self, nums: List[int]) -> List[List[int]]:
    results = []
    nums.sort()

    # 브루트 포스 n^3 반복
    for i in range(len(nums) -2):
        # 중복된 값 건너뛰기
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        for j in range(i + 1, len(nums) - 1):
            if i > i + 1 and nums[j] == nums[j - 1]:
                continue
            for k in range(j + 1, len(nums)):
                if k > j + 1 and nums[k] == nums[k - 1]:
                    continue
                if nums[i] + nums[j] + nums[k] == 0:
                    results.append([nums[i], nums[j], nums[k]])

    return results
```
### D. 결론
> 리트코드 기준, 타임아웃으로 풀이에 실패한다. O(n^2) 이내로 최적화를 진행하자.

<br>

## 풀이 2 : 투 포인터로 계산
### A. 풀이 1에서 개선해야 하는 부분은 어딜까 생각해보자.
- `i`의 반복은 필요하지만, `j, k`의 반복은 꼭 필요할까?
- `i`를 중심으로 `i 다음 값`과 `배열의 끝` 값을 계산하면 반복되는 횟수를 줄일 수 있지 않을까?

### B. 풀이를 도식화해보자.
```py
"""
[-4, -1, -1, 0, 1, 2]
        i   |        |
            |->    <-|
            |        |
        sum<0    sum>0
            |        |
            left    right
"""
```
- i의 다음 지점과 마지막 지점을 left, right로 설정하고 간격을 좁히면서 sum을 계산한다.
    ```py
    left, right = i + 1, len(nums) - 1
    while left < right:
        sum = nums[i] + nums[left] + nums[right]
    ```
- sum이 0보다 작다면 값이 더 커야 하므로 left를 우측으로, sum이 0보다 크다면 값이 더 작아야하므로 right를 좌측으로 이동한다.
    ```py
    if sum < 0:
        left += 1
    
    elif sum > 0:
        right -= 1
    ```
- sum이 0이면 정답! 결과를 리스트 변수 results에 추가하고, left, right 양 옆으로 동일한 값이 존재할 수 있으므로 left += 1, right -= 1을 반복하여 스킵하도록 처리한다.
    ```py
    # 위 코드와 동일
    else:
        # 결과를 리스트 변수 results에 추가
        results.append((nums[i], nums[left], nums[]))

        # left += 1, right -= 1을 반복하여 스킵
        while left < right and nums[left] == nums[left + 1]:
            left += 1
        while left < right and nums[right] == nums[right - 1]:
            right -= 1
    ```
- 마지막으로 left를 한 칸 우측으로, right를 한 칸 왼쪽으로 더 이동시키고 다음으로 넘긴다.
    ```py
    left += 1
    right -= 1
    ```

### C. 전체 코드를 작성해보자.
- left, right 둘 중 하나만 이동해야 하는 게 아닌가 싶지만 어차피 `sum = 0`인 상황이므로 어느 한 쪽만 이동하는 경우는 없다. 즉, 나머지 값을 찾으려면 둘 다 이동해야 하는 것이다.

```py
def three_sum(self, nums: List[int]) -> List[List[int]]:
    results = []
    nums.sort()

    for i in range(len(nums) - 2):
        # 중복된 값 건너뛰기
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        
        # 간격을 좁혀가며 sum 계산
        left, right = i + 1, len(nums) - 1
        while left < right:
            sum = nums[i] + nums[left] + nums[right]
            if sum < 0:
                left += 1
            elif sum > 0:
                right -= 1
            else:
                results.append([nums[i], nums[left], nums[right]])

                while left < right and nums[left] == nums[left + 1]:
                    left += 1
                while left < right and nums[right] == nums[right - 1]:
                    right -= 1

                left += 1
                right -= 1

    return results
```

### D. 결론
> 리트코드 기준, 884밀리초가 소요된다!