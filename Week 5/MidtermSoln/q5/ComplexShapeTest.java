package q5;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexShapeTest {

	ComplexShape cs1 = new ComplexShape();
	ComplexShape cs2 = new ComplexShape();
	ComplexShape cs3 = new ComplexShape();
	Circle c1 = new Circle(); 
	Circle c2 = new Circle(); 
	Rectangle r1 = new Rectangle();
	Rectangle r2 = new Rectangle();

	
	@Test
	public void testClone() {
		ComplexShape cs4 = (ComplexShape)cs1.clone();
		assertTrue(cs1.equals(cs4));	
		assertNotSame(cs1, cs4);	
		// Circle: r=4; Circle: r=6; Rectangle: x=10, y=10
		// added to ComplexShape objects cs1 and cs2
		c1.setRadius(4); c2.setRadius(6); r1.setXY(10, 10);		
		cs2.addShape(c1); cs2.addShape(c2); cs2.addShape(r1);
		// clone cs2 and assign to cs5; test if objects are not same (true)
		ComplexShape cs5 = (ComplexShape)cs2.clone();
		assertNotSame(cs2, cs5);
		// Circle: r=5 added to ComplexShape object cs1
		c1.setRadius(5); cs1.addShape(c1);
		// clone cs1 and assign to cs2; test if objects are not same (true)
		cs2 = (ComplexShape)cs1.clone();
		assertNotSame(cs2, cs1);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(cs1.equals(cs1));					// test reflexivity
		assertTrue(cs1.equals(cs2) && cs2.equals(cs1));	// test symmetry
		assertTrue(cs3.equals(cs3) && cs1.equals(cs3));	// test transitivity		
		// Circle: r=4; Circle: r=6; Rectangle: x=10, y=10
		// added to ComplexShape objects cs1 and cs2
		c1.setRadius(4); c2.setRadius(6); r1.setXY(10, 10);
		cs1.addShape(c1); cs1.addShape(c2); cs1.addShape(r1);
		cs2.addShape(c1); cs2.addShape(c2); cs2.addShape(r1);
		// test if cs1 and cs2 are equal (true)
		assertTrue(cs1.equals(cs2) && cs2.equals(cs1));	
		
		// Circle: r=5; Circle: r=7; Rectangle: x=11, y=3
		// added to ComplexShape object cs1
		c1.setRadius(5); c2.setRadius(7); r1.setXY(11, 3);
		cs1.addShape(c1); cs1.addShape(c2); cs1.addShape(r1);
		// test if cs1 and cs2 are equal (false)
		assertFalse(cs1.equals(cs2) && cs2.equals(cs1));	
	}
	
}
