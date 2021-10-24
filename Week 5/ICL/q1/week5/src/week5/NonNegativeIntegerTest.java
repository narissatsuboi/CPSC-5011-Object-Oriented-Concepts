package week5;

import org.junit.Assert;
import org.junit.Test;

class NonNegativeIntegerTest {

	@Test
	void testNonNegativeInteger() {
		NonNegativeInteger integer = new NonNegativeInteger();
		Assert.assertEquals(0, integer.get());
		Assert.assertNotNull(integer);

	}

	@Test
	void testEqualsObject() {
		NonNegativeInteger integer = new NonNegativeInteger();
		NonNegativeInteger nonInteger = new NonNegativeInteger();
		Assert.assertEquals(integer, nonInteger);

		nonInteger.set(5);
		Assert.assertNotEquals(integer, nonInteger);

		nonInteger = integer;
		Assert.assertEquals(integer, nonInteger);
	}

	@Test
	void testSet() {
		NonNegativeInteger integer = new NonNegativeInteger();
		integer.set(5);
		Assert.assertNotEquals(0, integer.get());
		Assert.assertEquals(5, integer.get());

	}

	@Test
	void testGet() {
		NonNegativeInteger integer = new NonNegativeInteger();
		integer.set(5);
		Assert.assertNotEquals(0, integer.get());
		Assert.assertEquals(5, integer.get());
	}

	@Test
	void testCompareTo() {
		NonNegativeInteger integer = new NonNegativeInteger();
		NonNegativeInteger nonNegativeInteger = new NonNegativeInteger();
		Assert.assertEquals(0, integer.compareTo(nonNegativeInteger));
		nonNegativeInteger.set(5);
		Assert.assertNotEquals(0, integer.compareTo(nonNegativeInteger));
	}

}
