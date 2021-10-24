package q3.two;
import q3.one.A;

class D {
	int g2(A that) {			  
		return that.x0 + that.x1 + that.x3; // if import, "x0" and "x1" compile error (not visible)
	}
}
