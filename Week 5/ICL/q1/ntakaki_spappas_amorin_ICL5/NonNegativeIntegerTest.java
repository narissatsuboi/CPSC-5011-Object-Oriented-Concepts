import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class NonNegativeIntegerTest {
    /**
     * invariant - if set has not been called, get should return 0
     */
    @Test
    public void testGetZero() {
        NonNegativeInteger test = new NonNegativeInteger();
        assertEquals(test.get(), 0);
    }
    
    /**
     * invariant - if set has been called, get should return the value of the last set
     */
    @Test
    public void testLastSet() {
        NonNegativeInteger test = new NonNegativeInteger();
        test.set(1);
        assertEquals(test.get(), 1);
        test.set(2);
        assertEquals(test.get(), 2);
    }
    
    /**
     * invariant - get should never return a negative value
     */
    @Test(expected = IllegalArgumentException.class)
    public void noNegativesAllowed() {
        NonNegativeInteger test = new NonNegativeInteger();
        test.set(-1);
    }

    /**
     * test equals
     */
    @Test
    public void testEquals() {
        NonNegativeInteger test1 = new NonNegativeInteger();
        NonNegativeInteger test2 = new NonNegativeInteger();
        assertTrue(test1.equals(test2));
        assertTrue(test2.equals(test1));
        test1.set(1);
        assertFalse(test1.equals(test2));
        assertFalse(test2.equals(test1));
        test2.set(1);
        assertTrue(test1.equals(test2));
        assertTrue(test2.equals(test1));
    }
}
