def check(queen, row):
    for i in range(row):
        if queen[i] == queen[row] or abs(queen[i] - queen[row]) == row - i:
            return False
    return True


def search(queen, row):
    n = len(queen)
    count = 0

    if n == row:
        return 1

    for col in range(n):
        queen[row] = col
        if check(queen, row):
            count += search(queen, row + 1)

    return count


def solution(n):
    return search([0] * n, 0)


# # others
# def search(col, ld, rd, row):
#     n = len(col)
#     count = 0

#     if row == n:
#         return 1

#     for i in range(n):
#         if col[i] or ld[i + row] or rd[i - row + n]:
#             continue
#         col[i] = ld[i + row] = rd[i - row + n] = True
#         count += search(col, ld, rd, row + 1)
#         col[i] = ld[i + row] = rd[i - row + n] = False

#     return count


# def solution(n):
#     col = [False] * n
#     ld = [False] * (n * 2)
#     rd = [False] * (n * 2)
#     return search(col, ld, rd, 0)


# # 비트 연산
# def search(col, ld, rd, n):
#     size = ((1 << n) - 1)
#     count = 0

#     if col == size:
#         return 1

#     slots = ~(col | ld | rd) & size
#     while slots:
#         bit = slots & -slots
#         count += search(col | bit, (ld | bit) >> 1, (rd | bit) << 1, n)
#         slots -= bit

#     return count


# def solution(n):
#     return search(0, 0, 0, n)
