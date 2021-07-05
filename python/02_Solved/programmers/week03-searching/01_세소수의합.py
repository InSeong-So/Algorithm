# def solution(n):
#     answer = 0
    
#     a = [False,False] + [True]*(n-1)
#     primes = []

#     for i in range(2,n+1):
#         if a[i]:
#             primes.append(i)
#             for j in range(2*i, n+1, i):
#                 a[j] = False
    
#     for index in range(len(primes)):
#         for index2 in range(index + 1, len(primes)):
#             for index3 in range(index2 + 1, len(primes)):
#                 c = primes[index] + primes[index2] + primes[index3]
#                 if c == n:
#                     answer += 1
    
#     return answer

# 에라토스테스트의 체(조합)
from itertools import combinations

def get_primes(n):
    # list로 return
    is_prime = [False, False] + [True] * (n - 2)

    for i in range(int(n // 2) + 1):
        if is_prime[i]:
            for j in range(i * i, n, i):
                is_prime[j] = False

    return [i for i, p in enumerate(is_prime) if p]

def solution(n):
    primes = get_primes(n)
    return [sum(c) for c in combinations(primes, 3)].count(n)