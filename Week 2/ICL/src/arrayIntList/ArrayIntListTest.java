/*
 * Narissa Tsuboi
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package arrayIntList;

import static org.junit.Assert.*;  // for assert statements
import org.junit.Test; // for junit4

/**
 * This JUnit testing program checks some of the basic features of our 
 * ArrayIntList.
 * @author Narissa Tsuboi
 */
public class ArrayIntListTest {

	/**
	 * This test checks default constructor formed non-null
	 * ArrayIntList object.
	 */
	@Test
	public void testDefaultConstructor() {
		// Arrange preconditions

		// Act
		var obj = new ArrayIntList();
		// Assert
		assertNotNull(obj);
	}

	/**
	 * This test checks overloaded constructor of capacity 10 formed a
	 * non-null ArrayIntList object.
	 */
	@Test
	public void testConstructor() {
		// Arrange preconditions

		// Act
		var obj = new ArrayIntList(10);
		// Assert
		assertNotNull(obj);
	}

	/**
	 * This test checks that after adding a value to the list, the
	 * size of the list is 1 greater than previous.
	 */
	@Test
	public void testAddValue() {
		var obj = new ArrayIntList(10);
		var size_pre = obj.size();
		obj.add(1);
		assertEquals(size_pre + 1, obj.size());
	}

	/**
	 * This test checks that a value is added at an index.
	 * Preconditions include adding an index in range.
	 */
	@Test
	public void testAddValueAtIndex() {
		// Arrange preconditions
		var testIndex = 5;
		var testValue = 2;
		var capacity = 6;
		var obj = new ArrayIntList(capacity);

		for (var i=0; i < capacity; i++) // fill arraylist
		{ obj.add(0); }

		// Act
		obj.set(testIndex, testValue);
		// Assert
		assertEquals(testValue, obj.get(testIndex));

	}

    /** 
     * This test makes sure that the list enforces its precondition
     * about the legal indexes passed to the get method.
     * If an ArrayIndexOutOfBoundsException is NOT thrown, the test
     * fails.
     */
	@Test(expected = ArrayIndexOutOfBoundsException.class) 
	public void testGet() {
		ArrayIntList list = new ArrayIntList();                                            
        list.get(17);   // this should crash  
	}

	/**
	 * This test checks that a value is set into the ArrayIntList.
	 * Preconditions include setting the test index, value, capacity,
	 * and fill it with default values before testing set.
	 */
	@Test
	public void testSet() {
		// Arrange preconditions
		var testIndex = 5;
		var testValue = 2;
		var capacity = 6;
		var obj = new ArrayIntList(capacity);

		for (var i=0; i < capacity; i++) // fill arraylist
		{ obj.add(0); }

		// Act
		obj.set(testIndex, testValue);
		// Assert
		assertEquals(testValue, obj.get(testIndex));
	}

	/**
	 * This test checks the basic functionality of the size method
	 * after adding a few elements.
	 */
	@Test
	public void testSize() {
        ArrayIntList list = new ArrayIntList();                                                      
        list.add(42);                                     
        list.add(-3);                               
        list.add(17);                                                         
        list.add(999);                                               
        assertEquals(4, list.size()); 
	}

    /**
     * Checks the basic functionality of the isEmpty method after
     * adding and removing.
     */
	@Test
	public void testIsEmpty() {
		ArrayIntList list = new ArrayIntList();                                            
        assertTrue(list.isEmpty());                                               
                                               
        list.add(42);                                           
        assertFalse(list.isEmpty());                                         
        list.add(-3);                                              
        assertFalse(list.isEmpty());                                       
                               
        list.remove(1);                                                    
        list.remove(0);                                        
        assertTrue(list.isEmpty());  
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	/** 
	 * Checks the basic functionality of the indexOf method after
	 * adding a few elements.
	 */
	@Test
	public void testIndexOf() {
        ArrayIntList list = new ArrayIntList();                               
        list.add(42);                                      
        list.add(-3);                                         
        list.add(17);                                            
        list.add(999);                                     
        list.add(17);                                                   
        list.add(86);
        assertEquals(0, list.indexOf(42));
        assertEquals(5, list.indexOf(86));
        assertEquals(2, list.indexOf(17));         // not 4!
        assertEquals(-1, list.indexOf(5555555));   // not found in list
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

}
