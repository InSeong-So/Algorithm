N = 8

cols = [0 for i in range(N + 1)]

def queens(level):
    if not promising(level):
        return False
    elif level == N:
        for i in range(1, N):
            print("(" + i + ", " + cols[i] + ")")
        return True
        
    for i in range(1, N):
        cols[level + 1] = i
        if queens(level + 1):
            return True
    return False

def promising(level):
    for i in range(1, level):
        if cols[i] == cols[level]:
            return False
        elif level - i == abs(cols[level] - cols[i]):
            return False
    return True

print(queens(0))