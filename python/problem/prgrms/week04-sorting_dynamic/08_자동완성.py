# trie 알고리즘 사용

def make_trie(words):
    root = {} # 루트 노드
    for word in words: # trie를 구성하기 위해 루프
        current = root # 루트부터 시작
        for letter in word:
            current.setdefault(letter, [0, {}])
            # 리스트의 첫 번째 값은 학습된 단어가 몇 개인지 카운팅하는 요소
            # 리스트의 두 번째 값은 트리 구조로 이용하기 위한 노드
            current[letter][0] += 1 # 카운팅을 위해 + 1
            current = current[letter][1] # letter에 해당하는 다음 노드로 이동

def solution(words):
    answer = 0
    trie = make_trie(words)

    for word in words:
        current = trie
        for index, letter in enumerate(word):
            if current[letter][0] <= 1: # 단어가 하나 이하로 남을 경우
                break
            current = current[letter][1] # 다음 노드로 이동
        answer += index + 1

    return 