package java8.sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
	}

	private static void test1() {
		final List<sortedTest> sts = Arrays.asList(new sortedTest("홍길동", 25), new sortedTest("박혁거세", 21),
				new sortedTest("세종대왕", 21), new sortedTest("이성계", 35));

		// java7 sort 사용
		Collections.sort(sts, new Comparator<sortedTest>() {
			public int compare(sortedTest o1, sortedTest o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		Collections.sort(sts, new Comparator<sortedTest>() {
			public int compare(sortedTest o1, sortedTest o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		System.out.println("sort 이름순 정렬 " + sts);

		// java8 sorted 사용
		List<sortedTest> sts1 = sts.stream().sorted(Comparator.comparing((sortedTest st) -> st.getAge()))
				.collect(Collectors.toList());
		System.out.println("sorted 나이순 정렬 " + sts1);
		List<sortedTest> sts2 = sts.stream().sorted(Comparator.comparing((sortedTest st) -> st.getName()))
				.collect(Collectors.toList());
		System.out.println("sotred 이름순 정렬 " + sts2);
	}

	private static void test2() {
		List<sortedTest2> stsList = new ArrayList<>();
		stsList.add(new sortedTest2("Y", "B", "1"));
		stsList.add(new sortedTest2("N", "B", "0"));
		stsList.add(new sortedTest2("Y", "B", "3"));
		stsList.add(new sortedTest2("Y", "B", "2"));
		stsList.add(new sortedTest2("", "A", ""));
		stsList.add(new sortedTest2("", "A", ""));

		for (sortedTest2 personVO : stsList) {
			System.out.println(personVO.toString());
		}
		System.out.println("---------------------------------------------------------");

		List<sortedTest2> peopleSortedList = new ArrayList();
		peopleSortedList = stsList.stream().map(p -> {        // expsFdC(영역코드)가 A인것은 우선노출여부가 없으므로 N으로 set
			sortedTest2 obj = p;
			if ("A".equals(obj.getExpsFdC())) {
				obj.setPrioYn("N");
			}
			return obj;
		}).sorted(Comparator.comparing(sortedTest2::getPrioYn).reversed()
				.thenComparing(Comparator.comparing(sortedTest2::getExpsFdC))
				.thenComparing(Comparator.comparing(sortedTest2::getPrioOr))).collect(Collectors.toList());

		System.out.println("peopleSortedList");
		for (sortedTest2 personVO : peopleSortedList) {
			System.out.println(personVO.toString());
		}
	}
}
