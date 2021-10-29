package tsuboin_hw5;

import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;

public class InventorySetTest {

	InventorySet s = new InventorySet();
	final VideoObj v1 = new VideoObj("A", 2000, "B");
	final VideoObj v1copy = new VideoObj("A", 2000, "B");
	final VideoObj v2 = new VideoObj("B", 2000, "B");

	@Test
	public void testAddNumOwned() {
		assertEquals(0, s.size());
		s.addNumOwned(v1, 1);
		assertEquals(v1, s.get(v1).video);
		assertEquals(1, s.get(v1).numOwned);
		s.addNumOwned(v1, 2);
		assertEquals(3, s.get(v1).numOwned);
		s.addNumOwned(v1, -1);
		assertEquals(2, s.get(v1).numOwned);
		s.addNumOwned(v2, 1);
		assertEquals(2, s.get(v1).numOwned);
		s.addNumOwned(v1copy, 1);
		assertEquals(3, s.get(v1).numOwned);
		assertEquals(2, s.size());
		s.addNumOwned(v1, -3);
		assertEquals(1, s.size());
		try {
			s.addNumOwned(null, 1);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testSize() {
		assertEquals(0, s.size());
		s.addNumOwned(v1, 1);
		assertEquals(1, s.size());
		s.addNumOwned(v1, 2);
		assertEquals(1, s.size());
		s.addNumOwned(v2, 1);
		assertEquals(2, s.size());
		s.addNumOwned(v2, -1);
		assertEquals(1, s.size());
		s.addNumOwned(v1, -3);
		assertEquals(0, s.size());
		try {
			s.addNumOwned(v1, -3);
			fail();
		} catch (IllegalArgumentException e) {
		}
		assertEquals(0, s.size());
	}

	@Test
	public void testCheckOutCheckIn() {
		s.addNumOwned(v1, 3);
		s.checkOut(v1);  // Check out Video1
		// Check numOut and numRentals are updated
		assertEquals(1, s.get(v1).numOut);
		assertEquals(1, s.get(v1).numRentals);
		s.checkIn(v1);  // Return Video1
		assertEquals(0, s.get(v1).numOut); // Check numOut updated

		s.clear();
		// Don't carry that video in inventory
		try {
			s.checkOut(v1);
			s.checkIn(v1);
		} catch(IllegalArgumentException e) {
		}
		// Carry the video but no copies available
		s.addNumOwned(v1, 1);
		s.checkOut(v1);
		try {
			s.checkOut(v1);
		} catch(IllegalArgumentException e) {
		}
		// All copies accounted for, cannot check in
		s.checkIn(v1);
		try {
			s.checkIn(v1);
		} catch(IllegalArgumentException e) {
		}






	}

	@Test
	public void testClear() {
		// A nonempty inventory is cleared, and has a size of 0 after
		s.addNumOwned(v1, 5);
		s.addNumOwned(v2, 5);
		assertEquals(2, s.size());
		s.clear();
		assertEquals(0, s.size());

		s.clear(); // No exceptions thrown on an empty inventory
		assertEquals(0, s.size());


	}

	@Test
	public void testGet() {
		// Get should return a COPY of the records, not the records themselves.
		s.addNumOwned(v1, 1);
		Record r1 = new Record(v1, 1, 0, 0);
		Record copy1 = s.get(v1);
		Record copy2 = s.get(v1);
		// Check that calling get x2 creates 2 separate shallow copies of the
		// stored Record
		assertNotSame(copy1, copy2);
		// Check fields are equal
		assertEquals(copy1.video, copy2.video); // uses video equals
		assertEquals(copy1.numOwned, copy2.numOwned);
		assertEquals(copy1.numRentals, copy2.numRentals);
		assertEquals(copy1.numOut, copy2.numOut);
	}

	@Test
	public void testToCollection() {
		// Be sure to test that changing records in the returned
		// collection does not change the original records in the
		// inventory.  ToCollection should return a COPY of the records,
		// not the records themselves.
		s.addNumOwned(v1, 5);
		s.addNumOwned(v2, 56);
		ArrayList<Record> list = s.toCollection();

		// Check that the entries in list are COPIES !=
		assertNotSame(s.get(v1), list.get(0));
		assertNotSame(s.get(v2), list.get(1));
	}

}
