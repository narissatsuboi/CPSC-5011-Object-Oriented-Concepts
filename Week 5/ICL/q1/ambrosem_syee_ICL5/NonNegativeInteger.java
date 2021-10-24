package ambrosem_syee_ICL5;

class NonNegativeInteger {
	private int v;
	
	  public NonNegativeInteger() { 
		  this.v = 0;
	  }
	  
	  public boolean equals (Object that) { 
		  if(this == that) return true;
		  if(!(that instanceof NonNegativeInteger)) return false;
		  //incomplete
	  }
	  
	  public void set(int v) throws IllegalArgumentException {
		  if(v < 0)
			  throw new IllegalArgumentException();
		  else {
			  this.v = v;
		  }
	  }
	  
	  public int get() {
		return v;
	  }
	}
