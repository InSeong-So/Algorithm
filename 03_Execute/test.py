def sum(n, array):
    if n <= 0:
        return 0
    else:
        return sum(n - 1, array) + array[n-1]

print(sum(5, [1, 2, 3, 4, 5]))