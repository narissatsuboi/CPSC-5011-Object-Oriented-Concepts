package q2.b;
class Main {
	public static void main(String[] argv) {
		new X();
		new X();
	}
}
class O {
	int i, j;
	O() { 
		i = 42; System.out.println(i); 
		j = 27; System.out.println(j);
		System.out.println("O"); 
	}
}
class X extends O {
	int k;
	X() { 
		k = 31; System.out.println(k);
		System.out.println("X"); 
	}
}

