package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class collectTest {

	public static void main(String[] args) {
		final List<String> names = Arrays.asList("홍길동", "박혁거세", "세종대왕", "이성계", "관우");

		// java 7
		for (int i = 0; i < names.size() - 1; i++) {
			System.out.print(names.get(i).toUpperCase() + ", ");
		}
		if (names.size() > 0)
			System.out.println(names.get(names.size() - 1).toUpperCase());

		// java 8
		System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
	}
}
