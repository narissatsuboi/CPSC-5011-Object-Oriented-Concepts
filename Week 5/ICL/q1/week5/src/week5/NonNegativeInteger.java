package week5;

public class NonNegativeInteger implements Integer {

	public NonNegativeInteger() {
		this.v = 0;
	}

	@Override
	public boolean equals(Object that) {
		if (that == this)
			return true;
		if (!(that instanceof NonNegativeInteger))
			return false;
		NonNegativeInteger nonNegativeInteger = (NonNegativeInteger) that;
		return nonNegativeInteger.get() == v;
	}

	public void set(int v) throws IllegalArgumentException {
		this.v = v;
	}

	public int get() {
		return v;
	}

	public int compareTo(NonNegativeInteger nonNegativeInteger) {
		if (v > nonNegativeInteger.get())
			return 1;
		else if (v < nonNegativeInteger.get())
			return -1;
		return 0;
	}

	private int v;
}
