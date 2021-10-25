package tsuboin_hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTest {

	@Test
	public void testCopy() {
		// be sure to test that copy returns a NEW reference!
		VideoObj video = new VideoObj("A", 2000, "B");
		java.lang.Record r1 = new java.lang.Record(video, 20, 10, 300);
		java.lang.Record r2 = r1.copy();
		assertTrue(r1 != r2);
		assertTrue(r1.toString().equals(r2.toString()));
	}
}	