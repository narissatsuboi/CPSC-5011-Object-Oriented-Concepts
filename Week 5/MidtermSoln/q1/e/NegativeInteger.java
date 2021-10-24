package q1.e;

/**
 * Invariants: 
 * - if set has not been called, get should return -1
 * - if set has been called, get should return the value of the last set
 * - get should never return a nonnegative value
 * @author ohsh
 */
class NegativeInteger extends Q1Integer {

	private NegativeInteger(int v) { 
		this.v = v;
	}
	
	public NegativeInteger() { 
		this(MAX_VALUE);
	}	
	
	public void set(int v) { 
		if (v > MAX_VALUE)
			throw new IllegalArgumentException();
		this.v = v;
	}
	
	@Override
	public boolean equals (Object that) { 
		if (this == that) return true;
		if (!(that instanceof NegativeInteger)) return false;
		NegativeInteger ni = (NegativeInteger) that;
		return ni.v == v;
	}
	
	private final static int MAX_VALUE = -1;
}
