package probOne;

import static org.junit.jupiter.api.Assertions.*;

class NonNegativeIntegerTest {

    @org.junit.jupiter.api.Test
    void testEquals() {
        NonNegativeInteger one = new NonNegativeInteger();
        NonNegativeInteger two = new NonNegativeInteger();
        one.set(5);
        two.set(5);
        assertEquals(one.get(), two.get());
        assertTrue(one.equals(two));
    }


    @org.junit.jupiter.api.Test
    void set() {
        NonNegativeInteger one = new NonNegativeInteger();
        NonNegativeInteger two = new NonNegativeInteger();
        one.set(5);
        two.set(5);
        assertNotNull(one);
        assertNotNull(two);
    }

    @org.junit.jupiter.api.Test
    void get() {
        NonNegativeInteger one = new NonNegativeInteger();
        NonNegativeInteger two = new NonNegativeInteger();
        one.set(5);
        two.set(5);
        assertEquals(one.get(), two.get());
        assertEquals(one.get(), 5);
    }
}