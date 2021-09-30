/*
 * Sheila Oh
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package arrayIntList;

import java.util.Arrays;   

/**
 * An {@code ArrayIntList} class stores an ordered list of integers using an unfilled array.
 * <p>
 * Reference: <a href="https://courses.cs.washington.edu/courses/cse143/11wi/lectures/01-12/programs/ArrayIntList.java">ArrayIntList.java</a>: UW - CSE 143, Winter 2011
 * @author Marty Stepp
 * @author Sheila Oh
 *
 */
public class ArrayIntList {
    private static final int INITIAL_CAPACITY = 10;
    
    // fields - the data inside each ArrayIntList object
    private int size;			//
    private int[] elementData;	//
    
    /**
     * Initializes a new empty list with initial capacity of 10 integers.
     */
    public ArrayIntList() {
        this(INITIAL_CAPACITY);   // call the (int) constructor
    }
    
    /**
     * Initializes a new empty list with the given initial capacity. 
     * @custom.pre     Capacity must be greater than 0.			
     * @param capacity The capacity of the list.
     */
    public ArrayIntList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive: "
            										+ capacity);
        }
        size = 0;
        elementData = new int[capacity];
    }
    
    /**
     * Adds the given value to the end of the list. 
     * If necessary, resizes the array to fit the value.
     * @custom.pre  The precondition of add.
     * @custom.post The postcondition of add.
     * @param value The value to be stored.
     */
    public void add(int value) {
        // just call the other add method (to remove redundancy)
        add(size, value);
    }

    /**
     * Inserts the given value into the list at the given index. 
     * If necessary, resizes the array to fit the value.  
     * @custom.pre 	Index is between 0 and size - 1 (inclusive).
     * @custom.post	The postcondition of add.
     * @param index The index where the given value will be stored.
     * @param value The value to be stored.
     */
    public void add(int index, int value) {
    	// okay to add at index == size (end of list)
        checkIndex(index, 0, size);     
        checkResize();
        
        // slide elements to the right to make room
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        
        // insert the value in the hole we just made
        elementData[index] = value;
        size++;
    }
    
    /**
     * Returns the value in the list at the given index. 
     * @custom.pre 	Index is between 0 and size - 1 (inclusive).
     * @custom.post	The postcondition of get.
     * @param index The index of value you are trying to return.
     * @return		The value at the given index.
     */
    public int get(int index) {
        checkIndex(index, 0, size - 1);
        return elementData[index];
    }
    
    /**
     * Sets the given index to store the given value. Assumes that a
     * value already exists at the given index.
     * is already
     * @custom.pre 	Index is between 0 and size - 1 (inclusive).
     * @custom.post The postcondition of set.
     * @param index The index to store the given value.
     * @param value The value to be stored.
     */
    public void set(int index, int value) {
        checkIndex(index, 0, size - 1);
        elementData[index] = value;
    }
    
    /**
     * Returns the number of elements in the list.
     * @return The size of the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns true if the list does not contain any elements.
     * @return True if list is empty; else false.
     */
    public boolean isEmpty() {
        return size == 0;   // "boolean zen"
    }
    
    /**
     * Removes the value from the given index, shifting following elements 
     * left by 1 slot to cover the hole.  
     * @custom.pre 	Index is between 0 and size - 1 (inclusive).
     * @custom.post The postcondition of remove.	
     * @param index The index where you want to remove a value.
     */
    public void remove(int index) {
        checkIndex(index, 0, size - 1);
        for (int i = index; i <= size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }
    
    /**
     * Returns a String representation of the elements in the list, such as
     * "[42, -3, 17, 99]", or "[]" for an empty list. 
     * @return 		The string representation of the elements in the list.
     */    
    @Override
    public String toString() {
        if (size > 0) {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result = result + ", " + elementData[i];
            }
            result += "]";
            return result;
        } else {
            return "[]";   // empty list
        }
    }
    
    /** 
     * Returns the index of the first occurrence of the given value 
     * in the list, or -1 if the value is not found in the list.
     * @param value The value you are trying to find.
     * @return		The index of the first occurrence of the given value.
     */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;   // not found
    }
    
    /**
     * Returns true if the given value is found in this list.
     * @param value	The value you are trying to find.
     * @return		True if value found; else false.
     */
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }
    
    /** 
     * A "private helper method" to resize the array if necessary. 
     * Checks whether the list's array is full, and if so, doubles 
     * its size so that more elements can be added.
     */
    private void checkResize() {
        if (size == elementData.length) {
            // resize the array
            elementData = Arrays.copyOf(elementData, 2 * size);
        }
    }
    
    /** 
     * A helper that throws an exception unless the given index is between 
     * the given minimum / maximum values, inclusive.
     * @param index	
     * @param min
     * @param max
     */
    private void checkIndex(int index, int min, int max) {
        if (index < min || index > max) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
