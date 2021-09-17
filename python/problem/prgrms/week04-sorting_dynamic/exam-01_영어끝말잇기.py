def solution(n, words):
    answer = [0, 0]
    count = 1
    for idx in range(1, len(words)):
        word = words[idx]
        count %= n
        if (word in words[0:idx]) or (words[idx-1][-1] != word[0]):
            answer = [count + 1, 1 + idx//n]
            return answer
        count += 1
    return answer
