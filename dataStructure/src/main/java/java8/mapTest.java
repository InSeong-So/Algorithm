package java8;

import java.util.Arrays;
import java.util.List;

public class mapTest {

	public static void main(String[] args) {
		final List<String> names = Arrays.asList("홍길동", "박혁거세", "세종대왕", "이성계", "관우");
		// java 7
		for (String name : names) {
			System.out.println(name);
		}

		// java 8
		names.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));
	}
}
