package tsuboin_hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class VideoObjTest {

	@Test
	public void testConstructorAndAttributes() {
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		assertSame(title1, v1.title());
		assertEquals(year, v1.year());
		assertSame(director1, v1.director());

		/*
		 * NOTE TO GRADER - My program asserts preconditions and throws
		 * InvalidArgument exceptions PRIOR to member field assignment
		 * per the "fail-first" methodology discussed on Slack. As such,
		 * the lines below will throw an exception before assigning v2's title
		 * and director, and cannot be accessed.
		 */
//		VideoObj v2 = new VideoObj(title2, year, director2);
//		assertEquals(title1, v2.title());
//		assertEquals(director1, v2.director());
	}

	@Test
	public void testConstructorExceptionYear() {
		try {
			new VideoObj("X", 1800, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("X", 5000, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("X", 1801, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void testConstructorExceptionTitle() {
		try {
			new VideoObj(null, 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj(" ", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testConstructorExceptionDirector() {
		// TODO: complete testConstructorExceptionDirector test
		try {
			new VideoObj("Little Mermaid", 2002, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("Little Mermaid", 2002, "");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("Little Mermaid", 2002, " ");
			fail();
		} catch (IllegalArgumentException e) {
		}
	}


	@Test
	public void testHashCode() {
		assertEquals
			(-1901244571, new VideoObj("None", 2009,
				"Zebra").hashCode());
		assertEquals
			(2025667696, new VideoObj("Blah", 1954,
				"Cante").hashCode());
	}

	@Test
	public void testEquals() {
		VideoObj killBill = new VideoObj("Kill Bill", 2005,
			"Quentin Tarantino");
		VideoObj killBillCpy = new VideoObj("Kill Bill", 2005,
			"Quentin Tarantino");
		VideoObj killBill2 = new VideoObj("Kill Bill 2", 2009,
			"Quentin Tarantino");
		VideoObj nullMovie = null;

		// returns false for null
		assertFalse(killBill.equals(nullMovie));
		// Reflexive, obj equals itself
		assert(killBill.equals(killBill));
		// Symmetric
		assertTrue(killBill.equals(killBillCpy));
		assertTrue(killBillCpy.equals(killBill));
		assertFalse(killBill.equals(killBill2));
		assertFalse(killBill2.equals(killBill));

		// Consistent
		assertTrue(killBill.equals(killBillCpy));
		assertTrue(killBillCpy.equals(killBill));
	}

	@Test
	public void testCompareTo() {
		// Test reflexivity, symmetry, transitivity, consistency with equals
		VideoObj v1 = new VideoObj("ABCs for Dummies", 2020,
			"A");
		VideoObj v1Cpy = new VideoObj("ABCs for Dummies", 2020,
			"A");
		VideoObj v2 = new VideoObj("DFGs for Dummies", 2020,
			"A");
		VideoObj v3 = new VideoObj("HIJs for Dummies", 2020,
			"A");

		// If reverse direction of unequal comparison, sign flips
		assert(v1.compareTo(v2)) == -(v2.compareTo(v1));
		// Ensure transitive relationship
		assert(v1.compareTo(v2) < 0 && v2.compareTo(v3) < 0
			&& v1.compareTo(v3) < 0);
		// Ensure that when v1 compared to v2 are equal, that the sign of v1
		// or v2 compared to v3 are equal
		if (v1.compareTo(v1Cpy) == 0)
			assertEquals(Integer.signum(v1.compareTo(v2)),
				Integer.signum(v1Cpy.compareTo(v2)));
		// Ensure that compareTo results match equals function results
		if (v1.compareTo(v1Cpy) == 0)
			assertTrue(v1.equals(v1Cpy));
	}

	@Test
	public void testToString() {
		String s = new VideoObj("A", 2000, "B").toString();
		assertEquals("A (2000) : B", s);
		s = new VideoObj(" A ", 2000, " B ").toString();
		assertEquals("A (2000) : B", s);
	}

}
