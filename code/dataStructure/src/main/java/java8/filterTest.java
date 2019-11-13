package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filterTest {

	public static void main(String[] args) {
		final List<String> names = Arrays.asList("홍길동", "박혁거세", "세종대왕", "이성계", "관우");

		// java 7
		final List<String> startsWithN1 = new ArrayList<String>();
		for (String name : names) {
			if (name.startsWith("S")) {
				startsWithN1.add(name);
			}
		}
		System.out.println(startsWithN1);

		// java 8 Lambda
		final List<String> startsWithN2 = names.stream().filter(name -> name.startsWith("S"))
				.collect(Collectors.toList());
		System.out.println(startsWithN2);

	}
}
