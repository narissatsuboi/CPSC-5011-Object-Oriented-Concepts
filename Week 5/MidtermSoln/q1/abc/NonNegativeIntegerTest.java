package q1.abc;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * NonNegativeIntegerTest tests the following:
 * - tests to check that this class obeys all of its invariants.
 * - test to check the equals operation. (It should return true exactly
 *   when this.get() is the same as that.get().)
 *   
 * @author ohsh
 */
public class NonNegativeIntegerTest {

	NonNegativeInteger i = new NonNegativeInteger();
	NonNegativeInteger i2 = new NonNegativeInteger();
	NonNegativeInteger i3 = new NonNegativeInteger();
	
	/**
	 * Test if two distinct objects are equal (same value, but not same 
	 * NonnegativeInteger object); equal and same if a NonnegativeInteger 
	 * object is assigned to another NonnegativeInteger object.
	 */	
	@Test
	public void testEqualsObject() {
		assertTrue(i.equals(i));			// test reflexivity
		assertTrue(i.equals(i2) && i2.equals(i));	// test symmetry
		assertTrue(i2.equals(i3) && i.equals(i3));	// test transitivity
		assertNotSame(i, i2);
		i = i2;
		assertTrue(i.equals(i2) && i2.equals(i));
		assertSame(i, i2);
	}
	
	/**
	 * Test invariants: 
	 * - if set has not been called, get should return 0
	 * - get should never return a negative value
	 */
	@Test
	public void testGetDefaultConstructor() {
		assertEquals(i.get(), 0);
		assertEquals(i2.get(), 0);
		assertEquals(i3.get(), 0);
		assertEquals(i.get(), i.get());
		assertEquals(i.get(), i2.get());
		assertEquals(i2.get(), i.get());
		assertEquals(i2.get(), i3.get());
		assertEquals(i.get(), i3.get());
		assertTrue(i.get() >= 0);
		assertTrue(i2.get() >= 0);
		assertTrue(i3.get() >= 0);
	}
	
	/**
	 * Test invariant: 
	 * - if set has been called, get should return the value of the last set
	 * - fails test if set a negative number (and throws IllegalArgumentException)
	 */
	@Test
	public void testSetGetLast() {
		i.set(5);
		assertEquals(i.get(), 5);
		i2.set(8);
		assertEquals(i2.get(), 8);
		try {
			i3.set(-3);
			fail();
		} catch (IllegalArgumentException e) {}
	}

}
