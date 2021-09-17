def solution(N, number):
    if N == number:  # 가지치기
        return 1

    set_list = []

    for count in range(1, 9):
        # count 만큼의 숫자를 미리 만들어서 저장한다. N이 5고 count가 3이라면 555이다.
        partial_set = {int(str(N) * count)}

        for i in range(count // 2):  # 6, 1...2
            set1 = set_list[i]  # 첫 집합에서 ->
            set2 = set_list[count - i - 2]  # 마지막으로 구한 집합에서 <=

            for num1 in set1:  # 첫 번째 집합
                for num2 in set2:  # 두 번째 집합
                    # 모든 경우의 수를 partial_set에 추가
                    partial_set.add(num1 + num2)
                    partial_set.add(num1 - num2)
                    partial_set.add(num2 - num1)
                    partial_set.add(num1 * num2)
                    if num2 != 0:
                        partial_set.add(num1 // num2)
                    if num1 != 0:
                        partial_set.add(num2 // num1)
        print(list(partial_set))
        print('----------------------------------------------------------')
        if number in partial_set:
            return count

        set_list.append(partial_set)

    return -1


solution(5, 12)
