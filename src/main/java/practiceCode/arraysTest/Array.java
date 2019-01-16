package practiceCode.arraysTest;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		ArrayCopy();
		System.out.println("----------------------------");
		ArraySort();
		System.out.println("----------------------------");
		ArraySearch();
	}

	// 배열 항목 복사
	static void ArrayCopy() {
		char[] arr1 = { 'J', 'A', 'V', 'A' };

		// 방법1
		// arr[1] ~ arr[2]를 arr3[0] ~ arr3[1]로 복사
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));

		// 방법2
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);

		// 방법3
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		for (int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "]=" + arr4[i]);
		}
	}

	// 배열 항목 정렬
	static void ArraySort() {

		// 방법 1
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] = " + scores[i]);
		}
		System.out.println();

		// 방법 2
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "] = " + names[i]);
		}
		System.out.println();

		// 방법 3
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = { m1, m2, m3 };
		Arrays.sort(members);
		for (int i = 0; i < members.length; i++) {
			System.out.println("members[" + i + "].name = " + members[i].name);
		}
	}

	static void ArraySearch() {

		// 기본 타입값 검색
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println("찾은 인덱스 : " + index);

		// 문자열 검색
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스 : " + index);

		// 객체 검색
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = { m1, m2, m3 };
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스 : " + index);
	}
}
