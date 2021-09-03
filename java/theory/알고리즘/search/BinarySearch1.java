import java.util.List;

public class BinarySearch1 {

	/*
	 * 이진 검색 트리 이진 검색트리 장점 : 정렬된 리스트의 속성을 이용 많은 원소가 주어진 원소와 맞지 않다는 걸 이미 알고 사용하는 것이므로
	 * 원소를 일일이 비교해보지 않고도 주어진 원소를 찾을 수 있음 예로 백만 개의 원소가 있다면 20번 미만의 비교로도 주어진 원소를 찾을 수
	 * 있음 단점 : 정렬되지 않은 리스트는 IndexOfBound 예외가 발생
	 */
	public boolean binarySearch(List<Integer> numbers, Integer value) {
		if (numbers == null && numbers.isEmpty()) {
			return false;
		}

		System.out.println("리스트 최대 사이즈 :" + numbers.size());

		Integer comparison = numbers.get(numbers.size() / 2);
		System.out.println(comparison);

		if (value.equals(comparison)) {
			return true;
		}

		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size() / 2), value);
		} else {
			return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
		}
	}

}
