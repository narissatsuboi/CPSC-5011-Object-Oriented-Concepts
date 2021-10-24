package q5;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTest {

	Circle c1 = new Circle();
	Circle c2 = new Circle();
	Circle c3 = new Circle();
	
	@Test
	public void testClone() {
		Circle c4 = (Circle)c1.clone();
		assertTrue(c1.equals(c4));	
		assertNotSame(c1, c4);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(c1.equals(c1));					// test reflexivity
		assertTrue(c1.equals(c2) && c2.equals(c1));	// test symmetry
		assertTrue(c3.equals(c3) && c1.equals(c3));	// test transitivity
	}

}
