package java8;

import java.util.Arrays;
import java.util.List;

public class reduceTest {

	public static void main(String[] args) {
		final List<String> names = Arrays.asList("홍길동", "박혁거세", "세종대왕", "이성계", "관우");

		// java 7
		String LongerEliment1 = "";
		for (String name : names) {
			if (("hoone".length() <= name.length()) && (LongerEliment1.length() <= name.length())) {
				LongerEliment1 = name;
			}
		}
		System.out.println("java 7 " + LongerEliment1);

		// java 8 Lambda
		String LongerEliment2 = names.stream().reduce("세종대왕",
				(name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		System.out.println("java 8 " + LongerEliment2);
	}
}
