package week5;

public class NegativeInteger implements Integer {
	public NegativeInteger() {
		this.v = 0;
	}

	@Override
	public boolean equals(Object that) {
		if (that == this)
			return true;
		if (!(that instanceof NegativeInteger))
			return false;
		NegativeInteger negativeInteger = (NegativeInteger) that;
		return negativeInteger.get() == v;
	}

	public void set(int v) throws IllegalArgumentException {
		this.v = v;
	}

	public int get() {
		return v;
	}

	public int compareTo(NegativeInteger negativeInteger) {
		if (v > negativeInteger.get())
			return 1;
		else if (v < negativeInteger.get())
			return -1;
		return 0;
	}

	private int v;
}
