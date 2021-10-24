package ncomvandee_jlindsay_herstadd_drosato_icl5;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonNegativeIntegerTest {
	
	@Test
	public void testNonNegativeInteger() {
		NonNegativeInteger x = new NonNegativeInteger();
		NonNegativeInteger y = new NonNegativeInteger();
		assertTrue(x != null);
		assertTrue(x != y);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSet(){
		NonNegativeInteger x = new NonNegativeInteger();
		NonNegativeInteger y = new NonNegativeInteger();
		x.set(6);
		y.set(17);
		assertTrue(x.get() == 6);
		assertTrue(y.get() == 17);
		x.set(-8);
		y.set(-13);
	}

	@Test
	public void testGet() {
		NonNegativeInteger x = new NonNegativeInteger();
		NonNegativeInteger y = new NonNegativeInteger();
		assertTrue(x.get() == 0);
		assertTrue(y.get() == 0);
		x.set(6);
		y.set(17);
		assertTrue(x.get() == 6);
		assertFalse(x.get() == 0);
		assertTrue(y.get() == 17);
		assertFalse(y.get() == 0);
	}

	@Test
	public void testEqualsObject() {
		NonNegativeInteger x = new NonNegativeInteger();
		NonNegativeInteger y = new NonNegativeInteger();
		assertTrue(x.equals(y));
		assertTrue(y.equals(x));
		x.set(6);
		y.set(17);
		assertFalse(x.equals(y));
		assertFalse(y.equals(x));
		y.set(6);
		assertTrue(x.equals(y));
		assertTrue(y.equals(x));
		assertFalse(x.equals("Hello!"));
		assertTrue(x.equals(x));
		assertTrue(y.equals(y));
		assertFalse(x.equals(new Integer(6)));
	}

	@Test
	public void testCompareTo() {
		NonNegativeInteger x = new NonNegativeInteger();
		NonNegativeInteger y = new NonNegativeInteger();
		assertTrue(x.compareTo(y) == 0);
		x.set(6);
		y.set(17);
		assertTrue(x.compareTo(y) < 0);
		assertTrue(y.compareTo(x) > 0);
		y.set(6);
		assertTrue(x.compareTo(y) == 0);
		assertTrue(y.compareTo(x) == 0);
		
		assertTrue(x.compareTo(x) == 0);
		assertTrue(y.compareTo(y) == 0);
	}

}

