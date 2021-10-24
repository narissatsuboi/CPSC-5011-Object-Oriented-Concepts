package q3.one;

class B {
	int g1(A that) {
		return that.x0 + that.x1 + that.x3;	// x0 compile error (not visible)
	}
}
