package tsuboin_hw5;

/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTest {

	@Test
	public void testCopy() {
		// be sure to test that copy returns a NEW reference!
		VideoObj video = new VideoObj("A", 2000, "B");
		Record r1 = new Record(video, 20, 10, 300);
		Record r2 = r1.copy();
		assertTrue(r1 != r2);
		System.out.println(r1.toString());
		assertTrue(r1.toString().equals(r2.toString()));
	}


}