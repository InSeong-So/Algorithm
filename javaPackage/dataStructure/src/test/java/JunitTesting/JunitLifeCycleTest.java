package JunitTesting;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// 생명주기 테스트
public class JunitLifeCycleTest {

	private static int counter = 0;

	@BeforeClass
	public static void suiteSetup() {
		assertEquals(0, counter);
		counter++;
	}

	public JunitLifeCycleTest() {
		assertTrue(Arrays.asList(1, 5).contains(counter));
		counter++;
	}

	@Before
	public void prepareTest() {
		assertTrue(Arrays.asList(2, 6).contains(counter));
		counter++;
	}

	@Test
	public void peformFirstTest() {
		assertTrue(Arrays.asList(3, 7).contains(counter));
		counter++;
	}

	@Test
	public void peformSecondTest() {
		assertTrue(Arrays.asList(3, 7).contains(counter));
		counter++;
	}
	
	@After
	public void cleanupTest() {
		assertTrue(Arrays.asList(4, 8).contains(counter));
		counter++;
	}

	@AfterClass
	public static void suiteFinished() {
		assertEquals(9, counter);
	}
}
