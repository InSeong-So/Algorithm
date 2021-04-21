def findMax(data, start: int, end: int):
    if start == end:
        return data[start]
    else:
        middle = (start + end) // 2
        max1 = findMax(data, start, middle)
        max2 = findMax(data, middle + 1, end)
        return max(max1, max2)

# 검증
print(findMax([1, 5, 4, 3, 2], 0, 4))
