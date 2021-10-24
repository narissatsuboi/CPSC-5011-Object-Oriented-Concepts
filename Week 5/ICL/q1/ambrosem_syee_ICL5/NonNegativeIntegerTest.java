package ambrosem_syee_ICL5;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonNegativeIntegerTest {

	@Test
	public void testNonNegativeInteger() {	
		NonNegativeInteger test = new NonNegativeInteger();
		assertNotNull(test);
		assertEquals(0, test.get());
	}

//	@Test
//	public void testEquals() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testSet() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testGet() {
//		fail("Not yet implemented");
//	}
}
