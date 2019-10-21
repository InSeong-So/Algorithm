package JunitTesting;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class assertionMessageTest {

	@Test
	public void assertionWithMessage() {
		final List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		
		assertTrue("The list is not empty", numbers.isEmpty());
		// 첫번째 매개변수는 '이것은 비어있지 않다'를 의미하나 두번째 배개변수는 numbers 리스트가 비어 있다고 말하므로 모순이다. 아래처럼 바꾸면 어순이 맞다.
		assertTrue("The numbers list should not be empty", numbers.isEmpty());
		// 결과 : java.lang.AssertionError: The list is not empty
	}
	
	@Test
	public void assertionWithoutMessage() {
		final List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		
		assertTrue(numbers.isEmpty());
		// 결과 : java.lang.AssertionError: null
	}
}
